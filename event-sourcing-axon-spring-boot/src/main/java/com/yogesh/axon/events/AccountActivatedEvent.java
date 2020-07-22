/* (C)2020 */
package com.yogesh.axon.events;

import com.yogesh.axon.aggregates.Status;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class AccountActivatedEvent extends BaseEvent<String> {
    private final Status status;
}
