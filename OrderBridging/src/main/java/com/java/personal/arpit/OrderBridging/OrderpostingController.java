package com.java.personal.arpit.OrderBridging;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.personal.arpit.OrderBridging.OrderDao;

import javassist.bytecode.Descriptor.Iterator;



@Controller
@RequestMapping("/order")
public class OrderpostingController 
{
	
	//List<OrderBridgingApplication> objOrderBridgingApplication;
	
	@Autowired
	OrderDao orderDao;
	
	
	
	
	@Autowired
	JmsQueueTopic jmsqueuetopic;
	
	
	
	@Autowired
	JsonObjectImpl jsonobjectimpl;
	
	
	@Autowired
	JsonParsing objJsonParsing;
	
	
	// should be part of UI 
	
	
	@RequestMapping
	public String Orderpostingpage(){
		//System.out.println("I am here");
		
		return "Orderpostingpage.jsp";
	}
	
	
	@RequestMapping("add")	
	public String addorder(Orderposting objOrderposting)
				
	{
			
		ArrayList<Orderposting> obj1 = new ArrayList<Orderposting>();
		
		System.out.println(objOrderposting);
		orderDao.save(objOrderposting);
		obj1.add(objOrderposting);
		System.out.println(obj1.toString());
		
		// Creating Json from obj returned by Chrome
		JSONObject objJsonObjectImpl = jsonobjectimpl.createJson(objOrderposting);
		System.out.println("Jsonobject as Jsonobject ----- "+objJsonObjectImpl);
		System.out.println("Jsonobject as String     ----- "+objJsonObjectImpl.toString());
		
		// Publishing the message to queue
		String Strsent = jmsqueuetopic.publishMsgtoTopic(objJsonObjectImpl); 
		System.out.println("Message sent to queue ---------- "+Strsent);
		
		try 
		{
			// Receiving the message from Queue
			String Strreceive = jmsqueuetopic.receiveMsgfromQueue();
			System.out.println("Message received from queue ---------- "+Strreceive);
			
			
			// Parsing of message received from JMS Queue
			//ArrayList<String> objArrayItem = objJsonParsing.parsing(Strsent);
			
		//	System.out.println(objArrayItem);
			
			
		//	orderdetailcontroller.addorderdtl(objArrayItem);
			
		} 
		catch (Exception e)
		{
		
		e.printStackTrace();
		
		}
	
		finally {		
		
		// Printing the added page on chrome
		return "added.jsp";
		}
		
		
		
	}
	
	

	
}




//ArrayList<OrderBridgingApplication> obj1 = new ArrayList<OrderBridgingApplication>() ;

	//	System.out.println(" techno Functional "+objOrderBridgingApplication.indexOf(objOrderBridgingApplication));		
		//System.out.println(obj1.getClass());
		
	/*	Iterator itr =  (Iterator) obj1.iterator();
		
		while (itr.hasNext())
		{
			System.out.println(itr.next());
		}
	*/	
		// FileOutputStream objFileOutputStream = new FileOutputStream("C:\\ttt.txt");
		
		//objFileOutputStream.write;
		
		//System.out.println(objOrderBridgingApplication);
		
		//obj1.lastIndexOf(objOrderBridgingApplication);
		
		//System.out.println(obj1.indexOf(objOrderBridgingApplication));
		
		//System.out.println(obj1.lastIndexOf(objOrderBridgingApplication));
		
		//System.out.println(obj1.get(1));
		
		//System.out.println(obj1);
		
		//System.out.println(obj1 instanceof RandomAccess);
		
		/*Iterator itr = (Iterator) obj1.iterator();
		
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}*/
