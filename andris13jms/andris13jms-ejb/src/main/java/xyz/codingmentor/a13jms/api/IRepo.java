package xyz.codingmentor.a13jms.api;

import java.util.List;
import xyz.codingmentor.a13jms.entity.Flight;
import xyz.codingmentor.a13jms.ex.RepoEx;

/**
 *
 * @author brianelete
 */
public interface IRepo {

    void create(Flight flight) throws RepoEx;

    Flight read(Long flightId) throws RepoEx;

    Flight update(Flight flight) throws RepoEx;

    void delete(Long flightId) throws RepoEx;

    List<Flight> getAll() throws RepoEx;
}
