package com.order.order.kafka;

import com.umsm.base.dto.OrderEventDTO;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderProducer {
    //slf4j logger use to log the information
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderEventDTO.class);

    private final NewTopic orderTopic;
    private final KafkaTemplate<String, OrderEventDTO> kafkaTemplate;

    public void sendOrder(OrderEventDTO orderEventDTO) {
        LOGGER.info(String.format("Sending order event to topic %S", orderEventDTO.toString()));

        Message<OrderEventDTO> message = MessageBuilder
                .withPayload(orderEventDTO)
                .setHeader(KafkaHeaders.TOPIC, orderTopic.name())
                .build();

        kafkaTemplate.send(message);
    }
}
