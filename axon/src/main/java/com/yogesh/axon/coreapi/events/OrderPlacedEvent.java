/* (C)2020 */
package com.yogesh.axon.coreapi.events;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderPlacedEvent {
    private String orderId;
    private String product;
}
