package xyz.codingmentor.a13jms.topic;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.a13jms.api.IService;
import xyz.codingmentor.a13jms.api.ITopic;
import xyz.codingmentor.a13jms.entity.Flight;
import xyz.codingmentor.a13jms.ex.RepoEx;

/**
 *
 * @author brianelete
 */
@Stateless
public class DepartureCheck {

    private ITopic iTopic;
    private IService iService;
    Map<Long, Flight> sent;

    public DepartureCheck() {
        //empty
    }

    @Inject
    public DepartureCheck(ITopic iTopic, IService iService) {
        this.iTopic = iTopic;
        this.iService = iService;
        sent = new HashMap<>();
    }

    @Schedule(hour = "*", minute = "*", second = "*/10", persistent = false)
    public void checkIfFlightDepartsWithinAnHour() throws RepoEx {
        Date now = new Date();
        Date future = new Date(System.currentTimeMillis() + 3600 * 1000);
        List<Flight> flights = iService.getAll();
        for (Flight flight : flights) {
            Date departure = flight.getDepartureDate();
            if (!sent.containsKey(flight.getId()) && departure.after(now) && departure.before(future)) {
                iTopic.sendDepartsSoon(flight);
                sent.put(flight.getId(), flight);
            }
        }
    }
}
