package com.yogesh.axon.coreapi.commands;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@RequiredArgsConstructor
public class ShipOrderCommand {
    @TargetAggregateIdentifier
    private final String orderId;
}
