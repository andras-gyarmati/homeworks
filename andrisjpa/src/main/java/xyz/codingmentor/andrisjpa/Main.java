package xyz.codingmentor.andrisjpa;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 *
 * @author brianelete
 */
public class Main {
    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        App application = container.instance().select(App.class).get();
        application.execute();
        weld.shutdown();
    }
}
