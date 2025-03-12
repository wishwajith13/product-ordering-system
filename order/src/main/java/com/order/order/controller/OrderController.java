package com.order.order.controller;


import com.order.order.common.OrderResponse;
import com.order.order.dto.OrderDTO;
import com.order.order.kafka.OrderProducer;
import com.order.order.service.OrderService;
import com.umsm.base.dto.OrderEventDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/order")
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;
    private OrderProducer orderProducer;

    @PostMapping
    public OrderResponse saveOrder(@RequestBody OrderDTO orderDTO)
    {
        OrderEventDTO orderEventDTO = new OrderEventDTO();
        orderEventDTO.setMessage("Order is commited");
        orderEventDTO.setStatus("Pending");
        orderProducer.sendMessage(orderEventDTO);
        return orderService.saveOrder(orderDTO);
    }

    @GetMapping
    public List<OrderDTO> getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public OrderDTO getOrderById(@PathVariable Integer orderId) {
        return orderService.getOrderById(orderId);
    }

    @PutMapping
    public OrderDTO updateOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.updateOrder(orderDTO);
    }

    @DeleteMapping("/{orderId}")
    public String deleteOrder(@PathVariable Integer orderId) {
        return orderService.deleteOrder(orderId);
    }
}
