package com.HUBOT.HUBOT;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@Configuration
@EnableMongoAuditing // Enable auditing for the entire application
public class MongoAuditConfig {
}
