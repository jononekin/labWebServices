package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Flight implements Serializable{

	@XmlID	
	String flightCode;
	String departingCity;
	String arrivingCity;
	Collection<ConcreteFlight> concreteFlights;

	public Flight(String flightCode, String departingCity, String arrivingCity) {
		super();

		this.flightCode = flightCode;
		this.departingCity = departingCity;
		this.arrivingCity = arrivingCity;
		concreteFlights = new ArrayList<ConcreteFlight>();
	}
	
	public Flight() {
		super();
	}


	public String getFlightCode() {
		return flightCode;
	}
	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}
	public String getDepartingCity() {
		return departingCity;
	}
	public void setDepartingCity(String departingCity) {
		this.departingCity = departingCity;
	}
	public String getArrivingCity() {
		return arrivingCity;
	}
	public void setArrivingCity(String arrivingCity) {
		this.arrivingCity = arrivingCity;
	}

	public void addConcreteFlight(String concreteFlighCode, Date date, int businessNumber, int firstNumber, int touristNumber, String time){
		ConcreteFlight cf=new ConcreteFlight(concreteFlighCode,date, businessNumber,firstNumber,touristNumber,time, this);
		concreteFlights.add(cf);
	}

	public Collection<ConcreteFlight> getConcreteFlights() {
		return concreteFlights;
	}

	public void setConcreteFlights(Collection<ConcreteFlight> concreteFlights) {
		this.concreteFlights = concreteFlights;
	}
	public String toString() {return flightCode+"/"+departingCity+"/"+arrivingCity;}
}

