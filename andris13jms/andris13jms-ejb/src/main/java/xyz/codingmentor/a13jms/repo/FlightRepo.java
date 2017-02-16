package xyz.codingmentor.a13jms.repo;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.a13jms.api.IRepo;
import xyz.codingmentor.a13jms.entity.Flight;
import xyz.codingmentor.a13jms.ex.RepoEx;

/**
 *
 * @author brianelete
 */
@Stateless
public class FlightRepo implements IRepo {
    
    @PersistenceContext(unitName = "flightjmsPU")
    private EntityManager em;
    
    @Override
    public void create(Flight flight) throws RepoEx {
        em.persist(flight);
    }
    
    @Override
    public Flight read(Long flightId) throws RepoEx {
        return em.find(Flight.class, flightId);
    }
    
    @Override
    public Flight update(Flight flight) throws RepoEx {
        Flight dbFlight = em.find(Flight.class, flight.getId());
        if (null == dbFlight) {
            return em.merge(flight);
        }
        dbFlight.setDepartureDate(flight.getDepartureDate());
        dbFlight.setArrivalDate(flight.getArrivalDate());
        dbFlight.setDestination(flight.getDestination());
        dbFlight.setDepartureLocation(flight.getDepartureLocation());
        return em.merge(dbFlight);
    }
    
    @Override
    public void delete(Long flightId) throws RepoEx {
        em.remove(em.find(Flight.class, flightId));
    }
    
    @Override
    public List<Flight> getAll() throws RepoEx {
        return em.createQuery("SELECT f FROM Flight f", Flight.class).getResultList();
    }
    
}
