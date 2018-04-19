package com.jjwtan.activemqDemo.configuration;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.ConnectionFactory;

/**
 * Created by Ran on 19/4/2018.
 */
@Configuration
public class ActiveMQComponentConfig {
    @Bean(name = "activemq")
    public ActiveMQComponent createComponent(ConnectionFactory factory) {
        ActiveMQComponent activeMQComponent = new ActiveMQComponent();
        activeMQComponent.setConnectionFactory(factory);
        return activeMQComponent;
    }
}
