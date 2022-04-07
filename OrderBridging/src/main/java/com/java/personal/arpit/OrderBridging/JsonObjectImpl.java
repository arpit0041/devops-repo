package com.java.personal.arpit.OrderBridging;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class JsonObjectImpl
{

	JSONArray objjsonobject1;
	JSONObject objjsonobject = new JSONObject();
	
	public JSONObject createJson(Orderposting orderpost){
		
		
		
		objjsonobject.put("Order_nbr", orderpost.getOrder_nbr());
		objjsonobject.put("item_name", orderpost.getItem_name());
		objjsonobject.put("Delivery_address", orderpost.getDelivery_address());
		objjsonobject.put("customer_order", orderpost.getCustomer_order());
		objjsonobject.put("quantity", orderpost.getQuantity());
		objjsonobject.put("postal_code", orderpost.getPostal_code());
		objjsonobject.put("Customer_name", orderpost.getCustomer_name());
		
		
		//objjsonobject1 = new JSONArray();
		//objjsonobject1.put("Order");
		
		//objjsonobject1.add(objjsonobject);
		
		//objjsonobject.put("Order", objjsonobject1);
		
		//objjsonobject1(objjsonobject);
		
	//	objjsonobject1.add(objjsonobject);
		
		
		
		System.out.println();System.out.println();System.out.println();System.out.println();
		System.out.println("Most imp creating Json text ------------- "+objjsonobject.toString());
		System.out.println("Most imp creating Json text ------------- "+objjsonobject);
		System.out.println();System.out.println();System.out.println();System.out.println();
		
		
		//JSONArray objJSONArray = new JSONArray();
		//objJSONArray.put(objjsonobject1);
		
		
		FileWriter objfostream;
		try 
			{
				objfostream = new FileWriter("E://order.json");
			//	objfostream.write(objJSONArray.toString());
				
				objfostream.write(objjsonobject.toString());
				
				objfostream.close();
			} 
		catch (IOException e)
			{
			
			e.printStackTrace();
			
			}
		return objjsonobject;
	}
	
	
	
	
}
