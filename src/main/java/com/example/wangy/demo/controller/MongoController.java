package com.example.wangy.demo.controller;

import com.example.wangy.demo.dao.PersonRepository;
import com.example.wangy.demo.model.Grade;
import com.example.wangy.demo.model.Location;
import com.example.wangy.demo.model.Person;
import com.example.wangy.demo.model.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;


@RestController
@RequestMapping("/mongo")
@Slf4j
@Api(tags = "mongodb操作")
public class MongoController {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    @ApiOperation(value = "保存用户详细信息", notes = "")
    public Person save(@RequestParam(name = "name",required = true,defaultValue = "1") String name) {
        Person person = new Person("wangy", 29);
        LinkedList<Location> locations = new LinkedList<>();

        locations.add(new Location("1", "北京"));

        person.setLocations(locations);
        person.setMyid(name);
        log.info("开始~");
        Person save = personRepository.save(person);
////        log.info(JSONUtils.toJSONString(save));
        return person;
    }
    @RequestMapping("/saveGrade")
    public Grade saveGrader(int id,String gradeName){
        Grade grade = new Grade();
        grade.setId(id);
        grade.setGradeName(gradeName);
        Grade insert = mongoTemplate.insert(grade);
        return insert;
    }
    @RequestMapping("/saveStudent")
    public Student saveStudent(int id,String name,int gradeId){
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setGradeId(gradeId);
        Student insert = mongoTemplate.insert(student);
        return insert;
    }
}
