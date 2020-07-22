/* (C)2020 */
package com.yogesh.axon.commands;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class CreateAccountCommand extends BaseCommand<String> {
    private final double accountBalance;
    private final String currency;
}
