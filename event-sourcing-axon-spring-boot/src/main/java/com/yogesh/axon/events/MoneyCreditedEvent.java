/* (C)2020 */
package com.yogesh.axon.events;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class MoneyCreditedEvent extends BaseEvent<String> {
    private final double creditAmount;
    private final String currency;
}
