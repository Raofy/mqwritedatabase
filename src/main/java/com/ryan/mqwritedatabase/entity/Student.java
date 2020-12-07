package com.ryan.mqwritedatabase.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import static com.baomidou.mybatisplus.annotation.IdType.AUTO;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    @TableId(type = AUTO)
    private Integer id;

    private String name;

    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
