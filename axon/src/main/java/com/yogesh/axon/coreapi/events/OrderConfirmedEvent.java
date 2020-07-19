package com.yogesh.axon.coreapi.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class OrderConfirmedEvent {
    private String orderId;
}
