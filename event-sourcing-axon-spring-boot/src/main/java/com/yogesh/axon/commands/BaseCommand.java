/* (C)2020 */
package com.yogesh.axon.commands;

import lombok.experimental.SuperBuilder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@SuperBuilder
public class BaseCommand<T> {
    @TargetAggregateIdentifier public final T id;
}
