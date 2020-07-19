package com.yogesh.axon.coreapi.commands;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
public class ShipOrderCommand {
    @TargetAggregateIdentifier
    private String orderId;
}
