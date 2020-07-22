/* (C)2020 */
package com.yogesh.axon.events;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class AccountCreatedEvent extends BaseEvent<String> {
    private final double accountBalance;
    private final String currency;
}
