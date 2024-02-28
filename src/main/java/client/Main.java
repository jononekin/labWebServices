package client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import service.BLFacadeImplementation;
import service.BLFacadeInterface;
import domain.Flight;
import domain.ConcreteFlight;

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
}}

