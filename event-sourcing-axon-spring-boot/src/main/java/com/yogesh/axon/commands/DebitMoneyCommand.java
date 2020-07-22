/* (C)2020 */
package com.yogesh.axon.commands;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class DebitMoneyCommand extends BaseCommand<String> {
    private final double debitAmount;
    private final String currency;
}
