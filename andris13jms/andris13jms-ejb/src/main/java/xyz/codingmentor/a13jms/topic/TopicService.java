package xyz.codingmentor.a13jms.topic;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;
import xyz.codingmentor.a13jms.api.ITopic;
import xyz.codingmentor.a13jms.entity.Flight;

/**
 *
 * @author brianelete
 */
public class TopicService implements ITopic {

    @Inject
    private JMSContext context;

    @Resource(lookup = "jms/flight_t")
    private Topic topic;

    @Override
    public void sendDelete(Flight flight) {
        context.createProducer().send(topic, "Flight deleted: " + flight.toString());
    }

    @Override
    public void sendUpdate(Flight flight) {
        context.createProducer().send(topic, "Flight updated: " + flight.toString());
    }

    @Override
    public void sendDepartsSoon(Flight flight) {
        context.createProducer().send(topic, "Flight departs in an hour: " + flight.toString());
    }
}
