package com.example.wangy.demo;

import com.example.wangy.demo.dao.PersonRepository;
import com.example.wangy.demo.mapper.UserTabMapper;
import com.example.wangy.demo.model.Location;
import com.example.wangy.demo.pojo.UserTab;
import com.example.wangy.demo.property.MyMessage;
import com.example.wangy.demo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j

public class DemoApplicationTests {
    @Autowired
    private MyMessage myMessage;
    @Autowired
    private UserTabMapper userTabMapper;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private PersonRepository personRepository;
    @Resource
    private UserService userService;

    @Test
    public void contextLoads() {
        log.info("输出结果{}", myMessage.getName());
    }

    @Test
    public void testMapper() {
        UserTab userTab1 = new UserTab();
        userTab1.setUsername("wangy");
        userTab1.setPassword("123456");

        int i = userTabMapper.insertSelective(userTab1);
        System.out.println("插入结果：" + (i > 0));
        UserTab userTab = userTabMapper.selectByPrimaryKey(1);
        System.out.println("获取结果：" + userTab);
    }

    @Test
    public void testTransaction() {
        UserTab userTab = new UserTab();
        userTab.setId(1);
        userTab.setUsername("wangyNew");
        userTab.setPassword("123456");
        UserTab userTab1 = new UserTab();
        userTab1.setUsername("zzx");
        userTab1.setPassword("123456");
        boolean b = userService.updateAndInsertUser(userTab, userTab1);
        System.out.println("执行结果：" + b);
    }

    @Test
    public void testMongo() throws JsonProcessingException {
        //      --------------------------查询
        //        Criteria queryCriteria = Criteria.where("name").is("wangy");
        //        Query query = Query.query(queryCriteria);
        //        List<Person> people = mongoTemplate.find(query, Person.class, "person1");
        //        System.out.println("姓名 ：" + people.size());

        //-----------------------------修改
//        Criteria criteria = Criteria.where("_id").is("1").and("name").is("wangy");
//        Query query1 = Query.query(criteria);
//        Update update = Update.update("name", "newWangy");
//        UpdateResult person1 = mongoTemplate.updateFirst(query1, update, Person.class, "person1");
//        System.out.println("修改结果：" + JsonUtil.objecdtToJson(person1));

//        -----------------------------删除
//        Criteria criteria = Criteria.where("_id").is("2").and("name").is("wangy");
//        Query query = Query.query(criteria);
//        DeleteResult person1 = mongoTemplate.remove(query, "person1");
//        System.out.println("删除结果："+ JsonUtil.objecdtToJson(person1));


//        连表查询
//        LookupOperation lookupOperation=LookupOperation.newLookup().
//                from("grade").  //关联从表名
//                localField("gradeId").     //主表关联字段
//                foreignField("_id").//从表关联的字段
//                as("GradeAndStu");   //查询结果名
////带条件查询可以选择添加下面的条件
////       Criteria criteria=Criteria.where("studenAndgrade").not().size(0);   //只查询有结果的学生
////        Criteria qqq=Criteria.where("name").regex("文");//只查询名字中带有文的
//        //       AggregationOperation match1= Aggregation.match(qqq);
////        AggregationOperation match = Aggregation.match(criteria);
////        Aggregation counts = Aggregation.newAggregation(match1,lookupOperation,match).;
//        Aggregation aggregation=Aggregation.newAggregation(lookupOperation);
//        List<Map> results = mongoTemplate.aggregate(aggregation,"student", Map.class).getMappedResults();
//        //上面的student必须是查询的主表名
//        System.out.println("查询结果："+JsonUtil.objecdtToJson(results));




        //limit和skip

    }

    @Test
    public void testJson() throws JsonProcessingException {
        Location wangy = new Location("1", "北京");
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(wangy);
        System.out.println("处理结果：" + s);
    }
}