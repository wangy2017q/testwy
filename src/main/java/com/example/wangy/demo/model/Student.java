package com.example.wangy.demo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
@Data
public class Student {

    private Integer id;
    private String name;
    private String sex;
    private Integer gradeId;
//    @DBRef
//    private  Grade grade;
}