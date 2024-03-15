package domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
@XmlAccessorType(XmlAccessType.FIELD) 
public class ConcreteFlightContainer {
	private ConcreteFlight concreteFlight; 
	private Flight flight; 
	public ConcreteFlightContainer(ConcreteFlight cf) {
		this.concreteFlight = cf; 
		this.flight=cf.getFlight(); }
	public ConcreteFlightContainer() {
		concreteFlight = null; 
		flight = null;  }
	public ConcreteFlight getConcreteFlight(){
		return concreteFlight; }
	public Flight getFlight(){
		return flight; }
	public String toString(){
		return concreteFlight+"/"+flight; 
	}
}

