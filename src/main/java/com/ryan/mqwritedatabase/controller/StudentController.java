package com.ryan.mqwritedatabase.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ryan.mqwritedatabase.config.RabbitMQConfig;
import com.ryan.mqwritedatabase.entity.Student;
import com.ryan.mqwritedatabase.service.MQStudentService;
import com.ryan.mqwritedatabase.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private MQStudentService mqStudentService;

    @GetMapping("/getAll")
    public Object getAll() {
        return studentService.list();
//        rabbitTemplate.convertAndSend(RabbitMQConfig.STUDENT_EXCHANGE, RabbitMQConfig.STUDENT_ROUTING_SEARCH_KEY, "");
//        return "ok";
    }

    @GetMapping("/add")
    public void add(@RequestParam String name, @RequestParam int age) {
        long start = System.currentTimeMillis();
        mqStudentService.insert(new Student(name, age));
        log.info("-----controller层耗费的时间：" + (System.currentTimeMillis() - start) + "ms");
    }


}
