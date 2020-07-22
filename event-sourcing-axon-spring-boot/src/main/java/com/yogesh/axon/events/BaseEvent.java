/* (C)2020 */
package com.yogesh.axon.events;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class BaseEvent<T> {
    private final T id;
}
