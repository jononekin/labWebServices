package client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import service.BLFacadeImplementation;
import service.BLFacadeInterface;
import domain.Flight;
import domain.ConcreteFlight;
import domain.ConcreteFlightContainer;

public class Main {
	public static void main(String[] args) throws Exception{
		URL url = new URL("http://localhost:9999/ws?wsdl");		
		QName qname = new QName("http://service/","BLFacadeImplementationService");
		Service service = Service.create(url, qname);
		BLFacadeInterface facade=service.getPort(BLFacadeInterface.class);
		System.out.println("FLIGHT-AK BILATU ETA INPRIMATU");
		List<Flight> listFlights=facade.getFlights();
		for (Flight f:listFlights)  {
			System.out.println("Flight: "+ f.toString()+" eta bere ConcreteFlights:");
			for (ConcreteFlight cf:f.getConcreteFlights())
				System.out.println(cf.toString()+" ");
		}
		System.out.println("CONCRETEFLIGHT-AK BILATU ETA INPRIMATU");
		List<ConcreteFlight> listConcreteFlight=facade.getConcreteFlights();
		for (ConcreteFlight cf:listConcreteFlight) 
			System.out.println("ConcreteFlight: "+cf.toString()+ " eta bere Flight "+cf.getFlight());	 
	
	
	System.out.println("CONCRETEFLIGHT-AK BILATU ETA INPRIMATU");
	 List<ConcreteFlightContainer> listConcreteFlightContainer=facade.getContainerConcreteFlights();
	  for(ConcreteFlightContainer concreteFlightContainer:listConcreteFlightContainer) 
		  System.out.println("ConcreteFlight: "+ concreteFlightContainer.getConcreteFlight()+ 
	                      " eta bere Flight: "+concreteFlightContainer.getFlight().toString());
	

	System.out.println("ConcreteFlights on "+newDate(2023,1,23).toString());
		List<ConcreteFlight> l=facade.getDateConcreteFlights(newDate(2023,1,23));
		for (ConcreteFlight cf:l)
			System.out.println(cf.toString());
	}
		
	
	private static Date newDate(int year,int month,int day) {

		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day,0,0,0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}
	
}

