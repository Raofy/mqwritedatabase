package com.ryan.mqwritedatabase.service;

import com.ryan.mqwritedatabase.async.SendToMQ;
import com.ryan.mqwritedatabase.config.RabbitMQConfig;
import com.ryan.mqwritedatabase.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MQStudentService {

    private static long i = 0;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SendToMQ sendToMQ;


    public void insert(Student student) {
        long start = System.currentTimeMillis();
        sendToMQ.send(student);
        log.info("MQ层耗费的时间：" + (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * 监听消息队列并消费信息
     */
    @RabbitListener(queues = RabbitMQConfig.STUDENT_SEARCH_QUEUE)
    public void getAll() {
        log.info("收到队列消息，获取数据信息" + i++);
        studentService.list();
    }

    @RabbitListener(queues = RabbitMQConfig.STUDENT_INSERT_QUEUE)
    public void add(Student student) {
        studentService.save(student);
    }


}
