/* (C)2020 */
package com.yogesh.axon.coreapi.commands;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@RequiredArgsConstructor
public class ConfirmOrderCommand {
    @TargetAggregateIdentifier private final String orderId;
}
