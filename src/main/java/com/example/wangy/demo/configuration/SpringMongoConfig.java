package com.example.wangy.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
public class SpringMongoConfig {

    @Autowired
    private MongoDbFactory mongoFactory;

    @Autowired
    private MongoMappingContext mongoMappingContext;

    @Bean
    public MappingMongoConverter mongoConverter() throws Exception {

        DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoFactory);
        MappingMongoConverter mongoConverter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);
        //this is my customization
        mongoConverter.setMapKeyDotReplacement("_");
        mongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
        mongoConverter.afterPropertiesSet();
        return mongoConverter;
    }
}