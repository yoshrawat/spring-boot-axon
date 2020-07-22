/* (C)2020 */
package com.yogesh.axon.events;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class BaseEvent<T> {
    private final T id;
}
