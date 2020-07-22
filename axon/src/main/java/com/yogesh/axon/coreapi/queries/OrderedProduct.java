/* (C)2020 */
package com.yogesh.axon.coreapi.queries;

import lombok.*;

@Data
@RequiredArgsConstructor
public class OrderedProduct {
    private final String orderId;
    private final String product;
    private OrderStatus orderStatus;

    public void setOrderConfirmed() {
        this.orderStatus = OrderStatus.CONFIRMED;
    }

    public void setOrderShipped() {
        this.orderStatus = OrderStatus.SHIPPED;
    }
}
