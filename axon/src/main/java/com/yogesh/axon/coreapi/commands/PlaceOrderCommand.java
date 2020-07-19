package com.yogesh.axon.coreapi.commands;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class PlaceOrderCommand {
    @TargetAggregateIdentifier
    private String orderId;
    private String product;
}
