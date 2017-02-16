package xyz.codingmentor.a13jms.listen;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author brianelete
 */
@MessageDriven(mappedName = "jms/flight_t")
public class Listener implements MessageListener {

    private static final Logger LOGGER = Logger.getLogger(Listener.class.getName());

    public Listener() {
        //empty
    }

    @Override
    public void onMessage(Message message) {
        try {
            LOGGER.log(Level.INFO, message.getBody(String.class));
        } catch (JMSException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }
}
