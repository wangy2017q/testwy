package com.example.wangy.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.LinkedList;
import java.util.List;

@Document(value = "person1")
@Data
@ApiModel(value = "人员")
public class Person {
    @Id
    @ApiModelProperty(value = "ID")
    private String myid;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "年龄")
    private Integer age;
    @Field("locs")
    @ApiModelProperty(value = "地点集合")
    private List<Location> locations=new LinkedList<Location>();

    public Person(String name,Integer age){
        this.name=name;
        this.age=age;
    }

}
