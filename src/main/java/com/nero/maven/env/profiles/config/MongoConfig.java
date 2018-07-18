package com.nero.maven.env.profiles.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

/**
 * @author Nero
 * @since 2018-07-18 9:31
 */
@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${mongo.uri}")
    private String mongoUri;

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(new MongoClientURI(mongoUri));
    }

    @Override
    protected String getDatabaseName() {
        return "irs";
    }

    @Bean
    @Override
    public MongoDbFactory mongoDbFactory() {
        return new SimpleMongoDbFactory(mongoClient(), getDatabaseName());
    }

    @Bean
    @Override
    public MongoTemplate mongoTemplate(){
        MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory()), new MongoMappingContext());
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return new MongoTemplate(mongoDbFactory(), converter);
    }
}
