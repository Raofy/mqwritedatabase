package com.ryan.mqwritedatabase.service;

import com.ryan.mqwritedatabase.config.RabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MQStudentService {

    @Autowired
    private StudentService studentService;

    /**
     * 监听消息队列并消费信息
     */
    @RabbitListener(queues = RabbitMQConfig.STUDENT_QUEUE)
    public void getAll() {
        log.info("收到队列消息，获取数据信息");
        studentService.list();
    }
}
