/* (C)2020 */
package com.yogesh.axon.commands;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@SuperBuilder
@Getter
public class BaseCommand<T> {
    @TargetAggregateIdentifier private final T id;
}
