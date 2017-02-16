package xyz.codingmentor.a13jms.service;

import java.util.List;
import javax.inject.Inject;
import xyz.codingmentor.a13jms.api.IRepo;
import xyz.codingmentor.a13jms.api.IService;
import xyz.codingmentor.a13jms.entity.Flight;
import xyz.codingmentor.a13jms.ex.RepoEx;

/**
 *
 * @author brianelete
 */
public class FlightService implements IService {

    @Inject
    private IRepo repo;
    
    @Override
    public void create(Flight flight) throws RepoEx {
        repo.create(flight);
    }

    @Override
    public Flight read(Long flightId) throws RepoEx {
        return repo.read(flightId);
    }

    @Override
    public Flight update(Flight flight) throws RepoEx {
        return repo.update(flight);
    }

    @Override
    public void delete(Long flightId) throws RepoEx {
        repo.delete(flightId);
    }

    @Override
    public List<Flight> getAll() throws RepoEx {
        return repo.getAll();
    }
    
}
