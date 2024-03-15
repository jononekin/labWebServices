package service;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

import domain.ConcreteFlight;
import domain.ConcreteFlightContainer;
import domain.Flight;

@WebService(endpointInterface = "service.BLFacadeInterface")
public class BLFacadeImplementation implements BLFacadeInterface{
	List<Flight> listFlights=new LinkedList<Flight>();
	List<ConcreteFlight> listConcreteFlights=new LinkedList<ConcreteFlight>();

	public BLFacadeImplementation(){
		initialize(); 
	}
	@WebMethod
	public List<Flight> getFlights(){
		return listFlights;
	}
	@WebMethod
	public List<ConcreteFlight> getConcreteFlights(){
		return listConcreteFlights;	
	}
	@WebMethod
	public Flight getFlight(String flightCode){
		Iterator<Flight> it=listFlights.iterator();
		while (it.hasNext()) {
			Flight ev=it.next();
			if (ev.getFlightCode().equals(flightCode))
				return ev; }
		return null; 
	}
	@WebMethod
	public ConcreteFlight getConcreteFlight(String concreteFlightCode){
		Iterator<ConcreteFlight> it=listConcreteFlights.iterator();
		while (it.hasNext()) {
			ConcreteFlight q=it.next();
			if (q.getConcreteFlightCode().equals(concreteFlightCode))
				return q; }
		return null; 
	}
	

	public void initialize(){
		listFlights=new LinkedList<Flight>();
		listConcreteFlights=new LinkedList<ConcreteFlight>();


		Flight f1 = new Flight("F1","Donostia","Bilbo");
		f1.addConcreteFlight("CF1-1",newDate(2023,1,23),0,2,3,"12:00");
		f1.addConcreteFlight("CF1-2",newDate(2023,1,23),3,0,3,"12:30");
		f1.addConcreteFlight("CF1-3",newDate(2023,1,23),1,2,2,"13:00");
		f1.addConcreteFlight("CF1-4",newDate(2023,1,23),3,3,0,"14:00");
		f1.addConcreteFlight("CF1-5",newDate(2023,1,23),3,3,0,"15:00");
		f1.addConcreteFlight("CF1-6",newDate(2023,1,23),3,3,0,"16:00");
		f1.addConcreteFlight("CF1-7",newDate(2023,1,23),3,3,0,"17:00");

		Flight f2 = new Flight("F2","Donostia","Madrid");
		f2.addConcreteFlight("CF2-1",newDate(2023,1,23),1,2,3,"12:00");
		f2.addConcreteFlight("CF2-2",newDate(2023,1,23),3,0,3,"12:30");
		f2.addConcreteFlight("CF2-3",newDate(2023,1,23),1,2,2,"13:00");
		f2.addConcreteFlight("CF2-4",newDate(2023,1,23),3,3,0,"14:00");
		f2.addConcreteFlight("CF2-5",newDate(2023,1,23),3,3,0,"15:00");
		f2.addConcreteFlight("CF2-6",newDate(2023,1,23),3,3,0,"16:00");
		f2.addConcreteFlight("CF2-7",newDate(2023,1,23),3,3,0,"17:00");
		listFlights.add(f1);
		listFlights.add(f2);
		listConcreteFlights.addAll(f1.getConcreteFlights());
		listConcreteFlights.addAll(f2.getConcreteFlights());



	} 
	private Date newDate(int year,int month,int day) {

		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day,0,0,0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}	
	@WebMethod
	public List<ConcreteFlightContainer> getContainerConcreteFlights(){
	
	 List<ConcreteFlightContainer> listConcreteFlightContainer= new LinkedList<ConcreteFlightContainer>();
	 for (ConcreteFlight concreteFlight:listConcreteFlights)
		 listConcreteFlightContainer.add(new ConcreteFlightContainer(concreteFlight));		
	 return listConcreteFlightContainer;	
	}
	@WebMethod
	public List<ConcreteFlight> getDateConcreteFlights(Date d){
	
		List<ConcreteFlight> concreteFlights= new LinkedList<ConcreteFlight>();
		 for (ConcreteFlight concreteFlight:listConcreteFlights)
			 if (concreteFlight.getDate().equals(d))
					 concreteFlights.add(concreteFlight);
		 return concreteFlights;	
		}
	}
	

