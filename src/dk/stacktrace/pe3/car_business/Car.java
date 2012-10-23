package dk.stacktrace.pe3.car_business;

public class Car {
	String modelNumber; //model manufactures snr
	String modelManufacturer;
	String make;  //could be "Volkswagen"
	String model;  // could be  "Beetle"
	String type; //could be "cabriolet" or "waggon"
	String year; //year of car
	String scale; // if this value is 43 it means that scale is 1:43
	String price;  //prices are always integers we hate this 9.99 stuff
	String carId;
	
	public Car(String carId, String modelNumber, String modelManufacturer, String make,
			String model, String type, String year, String scale, String price) {
		super();
		this.carId = carId;
		this.modelNumber = modelNumber;
		this.modelManufacturer = modelManufacturer;
		this.make = make;
		this.model = model;
		this.type = type;
		this.year = year;
		this.scale = scale;
		this.price = price;
	}

	
	public String getCarId() {
		return carId;
	}
	
	public String getModelNumber() {
		return modelNumber;
	}

	public String getModelManufacturer() {
		return modelManufacturer;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getType() {
		return type;
	}

	public String getYear() {
		return year;
	}

	public String getScale() {
		return scale;
	}

	public String getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Car [modelNumber=" + modelNumber + ", modelManufacturer="
				+ modelManufacturer + ", make=" + make + ", model=" + model
				+ ", type=" + type + ", year=" + year + ", scale=" + scale
				+ ", price=" + price + "]";
	}
}
