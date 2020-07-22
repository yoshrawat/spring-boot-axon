/* (C)2020 */
package com.yogesh.axon.events;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class MoneyDebitedEvent extends BaseEvent<String> {
    private final double debitAmount;
    private final String currency;
}
