package dk.stacktrace.pe3.car_business;

import java.util.ArrayList;

import dk.stacktrace.pe3.db.DBAccess;

public class Controller {

	private DBAccess db;
	
	public Controller() {
		db = new DBAccess();
	}
	
	
	public Car getCarById(String carId)
	{
		return db.getCarById(carId);
	}
	
	public ArrayList<Car> getAllCars()
	{
		return db.getAllCars();
	}
}
