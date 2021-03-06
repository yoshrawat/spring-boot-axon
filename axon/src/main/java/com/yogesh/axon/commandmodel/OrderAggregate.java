/* (C)2020 */
package com.yogesh.axon.commandmodel;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import com.yogesh.axon.coreapi.commands.ConfirmOrderCommand;
import com.yogesh.axon.coreapi.commands.PlaceOrderCommand;
import com.yogesh.axon.coreapi.commands.ShipOrderCommand;
import com.yogesh.axon.coreapi.events.OrderConfirmedEvent;
import com.yogesh.axon.coreapi.events.OrderPlacedEvent;
import com.yogesh.axon.coreapi.events.OrderShippedEvent;
import com.yogesh.axon.coreapi.exceptions.UnconfirmedOrderException;
import lombok.Data;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Data
@Aggregate
public class OrderAggregate {
    @AggregateIdentifier private String orderId;
    private boolean orderConfirmed;

    protected OrderAggregate() {
        // Required by Axon to build a default Aggregate prior to Event Sourcing
    }

    @CommandHandler
    public OrderAggregate(PlaceOrderCommand command) {
        apply(new OrderPlacedEvent(command.getOrderId(), command.getProduct()));
    }

    @CommandHandler
    public void handle(ConfirmOrderCommand command) {
        apply(new OrderConfirmedEvent(orderId));
    }

    @CommandHandler
    public void handle(ShipOrderCommand command) {
        if (!orderConfirmed) {
            throw new UnconfirmedOrderException();
        }

        apply(new OrderShippedEvent(orderId));
    }

    @EventSourcingHandler
    public void on(OrderPlacedEvent event) {
        this.orderId = event.getOrderId();
        this.orderConfirmed = false;
    }

    @EventSourcingHandler
    public void on(OrderConfirmedEvent event) {
        this.orderConfirmed = true;
    }
}
