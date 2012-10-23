package dk.stacktrace.pe3;

import java.util.ArrayList;
import java.util.Iterator;
import dk.stacktrace.pe3.car_business.Car;
import dk.stacktrace.pe3.car_business.Controller;

public class ShoppingCart {
	private ArrayList<Car> myShoppingCart;
	private String shoppingCartTable;
	private Controller control;
	
	public ShoppingCart() {
		System.out.println("shopping cart constructor");
		myShoppingCart = new ArrayList<Car>();
		shoppingCartTable = new String();
		control = new Controller();
		
	}

	private int calcPrice()
	{
		int price = 0; 
		Iterator<Car> car = myShoppingCart.iterator();
		while(car.hasNext())
		{
			price += Integer.parseInt(car.next().getPrice());
		}
		return price;
	}
	
	public void buyCar(String carId) {
		Car car = control.getCarById(carId);
		
		if (car != null)
		{
			System.out.println("ShoppingCart buy car " + carId + " has been added to your cart");
			myShoppingCart.add(car);
		}
	}
	
	public String getShoppingCartTable() 
	{
		StringBuilder HTMLShoppingCart = new StringBuilder(); 
		Iterator<Car> cart = myShoppingCart.iterator();
		Car currentCar = null;
		
		if (cart.hasNext())
		{
			System.out.println("adding an item to cart table!");
			
			HTMLShoppingCart.append("<table style=\"color:#000000;border:1px solid\">\n");
			HTMLShoppingCart.append("<thead>\n");
			HTMLShoppingCart.append("<tr>\n");
			HTMLShoppingCart.append("<th>Model</th>\n");
			HTMLShoppingCart.append("<th>Make</th>\n");
			HTMLShoppingCart.append("<th>Type</th>\n");
			HTMLShoppingCart.append("<th>Year</th>\n");
			HTMLShoppingCart.append("<th>Scale</th\n>");
			HTMLShoppingCart.append("<th>Serial number</th>\n");
			HTMLShoppingCart.append("<th>Price</th>\n");
			HTMLShoppingCart.append("</tr>\n");	
			HTMLShoppingCart.append("</thead>\n");
			while(cart.hasNext())
			{
				currentCar = cart.next();
				
				HTMLShoppingCart.append("<tbody>\n");
				HTMLShoppingCart.append("<tr>\n");
				HTMLShoppingCart.append("<td>"   + currentCar.getModel()      + "</td>\n");
				HTMLShoppingCart.append("<td>"   + currentCar.getMake()       + "</td>\n");
				HTMLShoppingCart.append("<td>"   + currentCar.getType()          + "</td>\n");
				HTMLShoppingCart.append("<td>"   + currentCar.getYear()          + "</td>\n");
				HTMLShoppingCart.append("<td>1:" + currentCar.getScale()         + "</td>\n");
				HTMLShoppingCart.append("<td>"   + currentCar.getModelNumber()  + "</td>\n");
				HTMLShoppingCart.append("<td>"   + currentCar.getPrice()         + "</td>\n");
				HTMLShoppingCart.append("</tr>\n");
				HTMLShoppingCart.append("</tbody>\n");
			}
			HTMLShoppingCart.append("<tr><td>Price </td><td></td><td></td><td></td><td></td><td></td><td>	" + calcPrice() +"</td></tr>");
			HTMLShoppingCart.append("<tr><td>VAT 25%</td><td></td><td></td><td></td><td></td><td></td><td>	" + calcPrice() * 0.25 +"</td></tr>");
			HTMLShoppingCart.append("<tr><td>Total Price</td><td></td><td></td><td></td><td></td><td></td><td>	" + (calcPrice() * 1.25) + "</td></tr>");
			
			HTMLShoppingCart.append("</table>");			
			
		}
		shoppingCartTable = HTMLShoppingCart.toString();
		return shoppingCartTable;
	}
}
