package dk.stacktrace.pe3.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dk.stacktrace.pe3.car_business.Car;


public class DBAccess {
	
		String dbUrl = "jdbc:mysql://127.0.0.1/MMM";
		String dbClass = "com.mysql.jdbc.Driver";
		Connection con;
		Statement statement;
		
		public DBAccess() {
		
		}

		public static void main(String[] args) {
	
			DBAccess db = new DBAccess();
			db.createCar("45656","VW" , "Transporter", "Sedan", "Donkey", 666, 43, "Brown", 666, "USA", "DK", 1964);
		}
		
		private boolean connect()
		{
		
		try {

		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(dbUrl, "root", "password");
		return true;
		} 

		catch(ClassNotFoundException e) {
		e.printStackTrace();
		return false;
		}

		catch(SQLException e) {
		e.printStackTrace();
		return false;
		}
		
		}	
		
		public Car getCarById(String carID) {
			String query = "SELECT * FROM MMM.cars WHERE carid = \'" + carID + "\';";
			Car car = null;
			String carId, modelNumber, year, price, scale, modelManufacture, make, model, type;
			
			connect();
			try {
				statement = con.createStatement();
				ResultSet rs = statement.executeQuery(query);
				rs.first();
				
				carId = rs.getString("carid");
				modelNumber =  rs.getString("model_number");
				modelManufacture = rs.getString("model_manufacture");
				make = rs.getString("make");
				model = rs.getString("model");
				type = rs.getString("type");
				year = Integer.toString(rs.getInt("production_year"));
				scale = Integer.toString(rs.getInt("scale"));
				price = Integer.toString(rs.getInt("price"));
				System.out.println(modelNumber + " " + modelManufacture + " " + make + " " + model + " " + type + " " + year + " " + scale);
				
				car = new Car(carId, modelNumber, modelManufacture, make, model, type, year, scale, price);
				con.close();
				return car;
			} catch (SQLException e) {
				return null;
			}
		}
		
		
		public ArrayList<Car> getAllCars()
		{
			String query = "SELECT * FROM MMM.cars;";
			ArrayList<Car> allCars = new ArrayList<Car>();
			String carId, modelNumber, year, price, scale, modelManufacture, make, model, type;
			
			connect();
			try {
				statement = con.createStatement();
				ResultSet rs = statement.executeQuery(query);
				
				while(rs.next())
				{
					carId = rs.getString("carid");
					modelNumber =  rs.getString("model_number");
					modelManufacture = rs.getString("model_manufacture");
					make = rs.getString("make");
					model = rs.getString("model");
					type = rs.getString("type");
					year = Integer.toString(rs.getInt("production_year"));
					scale = Integer.toString(rs.getInt("scale"));
					price = Integer.toString(rs.getInt("price"));

					allCars.add(new Car(carId, modelNumber, modelManufacture, make, model, type, year, scale, price));	
				}
				
				con.close();
				return allCars;
			} catch (SQLException e) {
				return null;
			}
		}
		
		public boolean carExists(String CarId)
		{
			return getCarById(CarId) != null;
		}
		
		public boolean createCar(String modelNumber, String make, String model, String type, String modelManufacture, int price, int scale, String color, int weight, String countryManufacture, String countryProduction, int productionYear)
		{
			String sql = "";
			
			if(carExists("" + modelNumber + modelManufacture))
			{
			return false;
			}
			else
			{

				sql = "INSERT INTO `MMM`.`cars` (`carid`, `model_number`, `make`, `model`, `type`, `model_manufacture`, `price`, `scale`, `color`, `weight`, `country_manufacture`, `country_production`, `production_year`) " + 
				"VALUES (\'" + modelNumber + modelManufacture + "\', \'" + modelNumber + "\', \'" + make + "\', \'" + model + "\', \'" + type + "\', \'" + modelManufacture + "\', \'" + price + "\', \'" + scale + "\', \'" + color + "\', \'" + weight + "\', \'" + countryManufacture + "\', \'" + countryProduction + "\' , \'" + productionYear + "\')";
				
				connect();
				try {
					statement = con.createStatement();
					statement.executeUpdate(sql);
					con.close();

					return true;
				} catch (SQLException e) {
					System.out.println("Damn");
					return false;
				}
			}
		}
}
 