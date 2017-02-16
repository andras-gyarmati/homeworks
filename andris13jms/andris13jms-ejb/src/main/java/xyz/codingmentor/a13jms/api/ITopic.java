package xyz.codingmentor.a13jms.api;

import xyz.codingmentor.a13jms.entity.Flight;

/**
 *
 * @author brianelete
 */
public interface ITopic {

    void sendDelete(Flight flight);

    void sendUpdate(Flight flight);

    void sendDepartsSoon(Flight flight);
}
