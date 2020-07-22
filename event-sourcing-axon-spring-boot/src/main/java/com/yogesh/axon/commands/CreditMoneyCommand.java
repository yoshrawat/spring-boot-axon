/* (C)2020 */
package com.yogesh.axon.commands;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class CreditMoneyCommand extends BaseCommand<String> {
    private final double creditAmount;
    private final String currency;
}
