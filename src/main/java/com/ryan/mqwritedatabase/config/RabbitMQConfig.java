package com.ryan.mqwritedatabase.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    //学生表交换机
    public static final String STUDENT_EXCHANGE = "STUDENT_EXCHANGE";

    //学生表队列
    public static final String STUDENT_QUEUE = "STUDENT_QUEUE";

    //学生表路由键
    public static final String STUDENT_ROUTING_KEY = "STUDENT_ROUTING_KEY";

    /**
     * Direct Exchange 示例的配置类
     */
    public static class DirectExchangeDemoConfiguration {

        // 创建 Queue
        @Bean
        public Queue StudentQueue() {
            return new Queue(STUDENT_QUEUE, // Queue 名字
                    true, // durable: 是否持久化
                    false, // exclusive: 是否排它
                    false); // autoDelete: 是否自动删除
        }

        // 创建 Direct Exchange
        @Bean
        public DirectExchange StudentExchange() {
            return new DirectExchange(STUDENT_EXCHANGE,
                    true,  // durable: 是否持久化
                    false);  // exclusive: 是否排它
        }

        // 创建 Binding
        @Bean
        public Binding StudentBinding() {
            return BindingBuilder.bind(StudentQueue()).to(StudentExchange()).with(STUDENT_ROUTING_KEY);
        }

    }
}
