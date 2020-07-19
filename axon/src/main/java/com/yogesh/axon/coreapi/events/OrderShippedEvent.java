package com.yogesh.axon.coreapi.events;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderShippedEvent {
    private String orderId;
}
