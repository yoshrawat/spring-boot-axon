package com.yogesh.axon.coreapi.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class ConfirmOrderCommand {
    @TargetAggregateIdentifier
    private String orderId;
}
