package com.ryan.mqwritedatabase.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ryan.mqwritedatabase.entity.Student;
import com.ryan.mqwritedatabase.mapper.StudentMapper;
import com.ryan.mqwritedatabase.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
}
