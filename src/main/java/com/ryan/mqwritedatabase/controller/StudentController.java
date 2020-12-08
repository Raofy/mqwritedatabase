package com.ryan.mqwritedatabase.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ryan.mqwritedatabase.config.RabbitMQConfig;
import com.ryan.mqwritedatabase.entity.Student;
import com.ryan.mqwritedatabase.service.StudentService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/getAll")
    public Object getAll() {
//        return studentService.list();
        rabbitTemplate.convertAndSend(RabbitMQConfig.STUDENT_EXCHANGE, RabbitMQConfig.STUDENT_ROUTING_KEY, "");
        return "ok";
    }

    @GetMapping("/add")
    public Object add(@RequestParam String name, @RequestParam int age) {
//        if (null != name) {
//            Student result = studentService.getOne(new QueryWrapper<Student>().eq("name", name));
//            if (null == result) {
                studentService.save(new Student(name, age));
                return "ok";
//            }
//        }
//        return "fail";
    }
}
