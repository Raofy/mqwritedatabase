package com.ryan.mqwritedatabase.async;

import com.ryan.mqwritedatabase.config.RabbitMQConfig;
import com.ryan.mqwritedatabase.entity.Student;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SendToMQ {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Async("asyncMq")
    public void send(Student student) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.STUDENT_EXCHANGE, RabbitMQConfig.STUDENT_ROUTING_INSERT_KEY, student);
    }
}
