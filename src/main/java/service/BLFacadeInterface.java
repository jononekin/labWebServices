package service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import domain.Flight;
import domain.ConcreteFlight;

@WebService
public interface BLFacadeInterface {
	@WebMethod
	public Flight getFlight(String flightCode);
	@WebMethod
	public List<Flight> getFlights();
    @WebMethod
	public ConcreteFlight getConcreteFlight(String concreFlightCode);
	@WebMethod
	public List<ConcreteFlight> getConcreteFlights();
	
}

