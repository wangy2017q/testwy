package com.example.wangy.demo.dao;

import com.example.wangy.demo.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person,String> {
    Person findByName(String name);
    @Query("{'age':?0}")
    List<Person> withQueryFindByAge(Integer age);
}