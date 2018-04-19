package com.jjwtan.activemqDemo.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by Ran on 19/4/2018.
 */

@Component
public class EntryRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
//        from("file:D:/java-projects/testFolder/in")
        from("activemq:topic:testTopic?clientId=1&durableSubscriptionName=bar1")
            .log("going through")
            .to("file:D:/java-projects/testFolder/out");
//            .to("activemq:topic:testTopic");
    }
}
