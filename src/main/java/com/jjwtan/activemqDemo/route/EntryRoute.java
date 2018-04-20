package com.jjwtan.activemqDemo.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by Jeremy on 19/4/2018.
 */

@Component
public class EntryRoute extends RouteBuilder {

    private static String MQ_DURABLE_SUBSCRIBER = "activemq:topic:testTopic?clientId=1&durableSubscriptionName=bar1";
    private static String MQ_OUTBOUND = "activemq:topic:testTopic";
    private static String FILE_INBOUND = "file:/Users/jeremy/IdeaProjects/testFolder/in";
    private static String FILE_OUTBOUND = "file:/Users/jeremy/IdeaProjects/testFolder/out";

    @Override
    public void configure() throws Exception {

        from(MQ_DURABLE_SUBSCRIBER).routeId("RouteFromMQ")
            .log("receiving file from topic")
            .to(FILE_OUTBOUND);

        from(FILE_INBOUND).routeId("RouteToMQ")
            .log("sending file to topic")
            .to(MQ_OUTBOUND);


    }
}
