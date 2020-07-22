/* (C)2020 */
package com.yogesh.axon.commands;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class CreateAccountCommand extends BaseCommand<String> {
    private final double accountBalance;
    private final String currency;
}
