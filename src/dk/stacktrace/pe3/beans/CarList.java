package dk.stacktrace.pe3.beans;

import java.util.ArrayList;
import java.util.Iterator;

import dk.stacktrace.pe3.car_business.Car;
import dk.stacktrace.pe3.car_business.Controller;

public class CarList {
	
	private String carListTable;
	private Controller control;
	
	public CarList() {
		carListTable = new String();
		control = new Controller();
	}
	
	
	public String getCarListTable() {
		StringBuilder HTMLTableCarList = new StringBuilder();
		ArrayList<Car> allCars = control.getAllCars();
		Iterator<Car> it = allCars.iterator();
		Car car;
		
		
		HTMLTableCarList.append("<table border=1>\n");
		while(it.hasNext())
		{
			car = it.next();
			HTMLTableCarList.append("<tr>\n <td>");
			HTMLTableCarList.append("<a href=\"carDetails.jsp?carId=" + car.getCarId() + "\"> " + car.getMake() + " " + car.getType() + " " + car.getYear() + "</a>");
			HTMLTableCarList.append("</td>\n </td>");
		}
		HTMLTableCarList.append("</table>");
		carListTable = HTMLTableCarList.toString();
		return carListTable;
	}
}
