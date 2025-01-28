package com.order.order.common;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.order.order.dto.OrderDTO;
import lombok.Getter;

@Getter
public class SuccessOrderResponse implements OrderResponse {
    @JsonUnwrapped // Annotation to unwrap the OrderDTO object(to get order as a flat order use this)
    private final OrderDTO order;

    public SuccessOrderResponse(OrderDTO order) {
        this.order = order;
    }
}
