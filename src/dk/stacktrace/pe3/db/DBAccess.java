package dk.stacktrace.pe3.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


import dk.stacktrace.pe3.car_business.Car;


public class DBAccess {

		private Connection con;
		private Statement statement;
		
		public DBAccess() {
		
		}
		
		private boolean connectCarDB()
		{
			// Obtain our environment naming context
			Context initCtx;
			try {
				initCtx = new InitialContext();
				Context envCtx = (Context) initCtx.lookup("java:comp/env");
				// Look up our data source
				DataSource ds = (DataSource) envCtx.lookup("jdbc/MMM");
				// Allocate and use a connection from the pool
				con = ds.getConnection();
				
			} catch (NamingException e) {
				e.printStackTrace();
				return false;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}

		
		public Car getCarById(String carID) {
			String query = "SELECT * FROM MMM.cars WHERE carid = \'" + carID + "\';";
			Car car = null;
			String carId, modelNumber, year, price, scale, modelManufacture, make, model, type;
			
			connectCarDB();
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
			
			connectCarDB();
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
				
				connectCarDB();
				try {
					statement = con.createStatement();
					statement.executeUpdate(sql);
					con.close();
					return true;
				} catch (SQLException e) {
					return false;
				}
			}
		}
}