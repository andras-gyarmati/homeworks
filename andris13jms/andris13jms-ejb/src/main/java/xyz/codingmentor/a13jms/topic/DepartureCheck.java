package xyz.codingmentor.a13jms.topic;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import xyz.codingmentor.a13jms.api.IService;
import xyz.codingmentor.a13jms.api.ITopic;
import xyz.codingmentor.a13jms.entity.Flight;
import xyz.codingmentor.a13jms.ex.RepoEx;

/**
 *
 * @author brianelete
 */
@Singleton
@Startup
public class DepartureCheck {

    private ITopic iTopic;
    private IService iService;
    List<Flight> sent;

    public DepartureCheck() {
        //empty
    }

    @Inject
    public DepartureCheck(ITopic iTopic, IService iService) {
        this.iTopic = iTopic;
        this.iService = iService;
        sent = new ArrayList<>();
    }

    @Schedule(second = "*/10")
    public void checkIfFlightDepartsWithinAnHour() throws RepoEx {
        Date now = new Date();
        Date future = new Date(System.currentTimeMillis() + 3600 * 1000);
        List<Flight> flights = iService.getAll();
        for (Flight flight : flights) {
            Date departure = flight.getDepartureDate();
            if (departure.after(now) && departure.before(future) && !sent.contains(flight)) {
                iTopic.sendDepartsSoon(flight);
                sent.add(flight);
            }
        }
    }
}
