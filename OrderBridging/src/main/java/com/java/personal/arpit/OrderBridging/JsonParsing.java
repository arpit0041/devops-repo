package com.java.personal.arpit.OrderBridging;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParsing 

{
	long quantity,postal_code,Order_nbr;
	String Delivery_address,customer_order,item_name,Customer_name;
	
	public ArrayList<String> parsing(String objJsonObject) throws Exception
	{
		
		JSONParser objJsonParser = new JSONParser();
			
		System.out.println();
		System.out.println();System.out.println();
		
		
		
		System.out.println("Here we are parsing the string ------ "+objJsonObject);
		
		Object obj = objJsonParser.parse(objJsonObject);
		
		JSONObject objJSONObject = (JSONObject)obj;
		
		Long quantity = (Long)objJSONObject.get("quantity");
		String Delivery_address = (String) objJSONObject.get("Delivery_address");
		String customer_order = (String) objJSONObject.get("customer_order");
		String item_name = (String) objJSONObject.get("item_name");
		String Customer_name = (String) objJSONObject.get("Customer_name");
		Long postal_code = (Long) objJSONObject.get("postal_code");
		Long Order_nbr = (Long) objJSONObject.get("Order_nbr");
		System.out.println(quantity);
		System.out.println(Delivery_address);
		System.out.println(customer_order);
		System.out.println(item_name);
		System.out.println(Customer_name);
		System.out.println(postal_code);
		System.out.println(Order_nbr);
		
		ArrayList<String> objArrayList = new ArrayList();
		objArrayList.add(item_name);
		
		
		return objArrayList;
		
		
	}
}
