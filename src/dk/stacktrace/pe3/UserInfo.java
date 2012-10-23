package dk.stacktrace.pe3;

import java.util.HashMap;
/* this class is created with the sole purpose to support a user concept
 * in the exercises
 * 
 *  Author NG
 *  version 1.0*/
public class UserInfo {
	HashMap <String, String> userTable;
	Integer t;
	public  UserInfo(){
		userTable = new HashMap<String,String>();
		init();
	}
	/*  this method will add a user to the table */
	public void addUser(String name, String code){
		if(!userTable.containsKey(name))
		userTable.put(name,code);
		else
		{
			System.out.println("User: " + name + " exists in DB");
		}
		
	}
public String getUser(String name){
		
		if(userTable.containsKey(name))
		{
		return userTable.get(name);
		}
		else return null;
		
	}
public Boolean userExists(String name, String code){
	Boolean found = false;
	if(userTable.containsKey(name))
	{
		if (code.equals(userTable.get(name))){
			found = true;;
		}
	}
	 return found;
	
}
public void init(){
	addUser("Peter", "Pan");
	addUser("Hank", "Williams");
	addUser("Betty", "b4711");
	addUser("Lotte", "Lenya");
	addUser("Lilly", "hurra");

}
	
}
