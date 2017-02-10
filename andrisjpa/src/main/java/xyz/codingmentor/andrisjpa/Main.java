package xyz.codingmentor.andrisjpa;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import xyz.codingmentor.andrisjpa.api.RepositoryException;

/**
 *
 * @author brianelete
 */
public class Main {

    private Main() {
        //empty
    }

    public static void main(String[] args) throws RepositoryException {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        App application = container.instance().select(App.class).get();
        application.execute();
        weld.shutdown();
    }
}
