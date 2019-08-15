package com.example.wangy.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
@Data
public class User {
    private String name;
    @JsonIgnore
    private String sex;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int age;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date birthday;
}