package dk.stacktrace.pe3.beans;

import dk.stacktrace.pe3.car_business.Car;
import dk.stacktrace.pe3.car_business.Controller;

public class CarDetails {

	private String carId;
	private String carDetailsTable;
	private Car car;
	private Controller control;
	
	public CarDetails() {
        car = null;
        carId = null;
        control = new Controller();
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}
	
	public String getCarDetailsTable() 
	{
		if(carId != null)
		{
		car = control.getCarById(carId);	
		
		carDetailsTable = 
				"<table style=\"color:#000000;border:1px solid\">" +
				"	<thead> " +
				"		<tr>" +
				"			<th>Model</th>" +
				"			<th>Make</th> " +
				"			<th>Type</th>" +
				"			<th>Year</th>" +
				"			<th>Scale</th>" +
				"			<th>Serial number</th>" +
				"			<th>Price</th> " +
				"		</tr>" +	
				"	</thead>" +
				"	<tbody> " +
				"		<tr>" +
				"			<td>"   + car.getModel()      + "</td>" +
				"			<td>"   + car.getMake()       + "</td>" +
				"			<td>"   + car.getType()          + "</td>" +
				"			<td>"   + car.getYear()          + "</td>" +
				"			<td>1:" + car.getScale()         + "</td>" +
				"			<td>"   + car.getModelNumber()  + "</td>" +
				"			<td>"   + car.getPrice()         + "</td>" +
				"		</tr>" +
				"	</tbody>" +
				"</table>" +
				"<br>" +
				"<a href=\"buy.jsp?carId="+ carId + "\">Add this car to your shopping cart</a>";
		}
	else
		{
			carDetailsTable = "<h1>Error: Car id not found</h1>";
		}
		return carDetailsTable;
	}
}
