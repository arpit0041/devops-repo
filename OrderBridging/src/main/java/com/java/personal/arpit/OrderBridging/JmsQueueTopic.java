package com.java.personal.arpit.OrderBridging;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;

import org.json.simple.JSONObject;


public class JmsQueueTopic {
	

	private static ConnectionFactory objConnectionFactory = null;
	private static javax.jms.Connection objConnection = null;
	private static javax.jms.Session objSession = null;
	private static MessageProducer objMessageProducer = null;
	private static javax.jms.Destination objDestination = null;
	private static TextMessage objTextMessage ;
	private static javax.jms.Message objMessage ;
	private static MessageConsumer objMessageConsumer = null;
	
	String st;
	
	
	public String publishMsgtoTopic(JSONObject obj)
	{
		try {
		objConnectionFactory = new com.tibco.tibjms.TibjmsConnectionFactory(Constants.url);
		objConnection = objConnectionFactory.createConnection("","");
		objSession = objConnection.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
		objDestination = objSession.createQueue(Constants.queue);
		objDestination = objSession.createTopic(Constants.Topic);
		objMessageProducer = objSession.createProducer(null);
		objTextMessage =  objSession.createTextMessage(obj.toString());
		objMessageProducer.send(objDestination, objTextMessage);
		
		
		objConnection.close();
		
		}
		catch(JMSException e)
		{
			System.out.println(e.toString());
			return "Message not sent successfully";
		}
		
	 return obj.toString();	
		
	}
	
	
	public String receiveMsgfromQueue()
	{
		try {
		objConnectionFactory = new com.tibco.tibjms.TibjmsConnectionFactory(Constants.url);
		objConnection = objConnectionFactory.createConnection("admin","password");
		objSession = objConnection.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
		//objDestination = objSession.createQueue(QueueName);
		objConnection.start();
		objDestination = objSession.createQueue(Constants.queue);
		objMessageConsumer = objSession.createConsumer(objDestination);
	//	objTextMessage =  objSession.createTextMessage("I am a techno functional");
		
		objMessage =  objMessageConsumer.receive();
		
	//	System.out.println(objMessage);
		
		st = (String)objMessage.toString();
		
		System.out.println("Received from queue under method --------------- "+objMessage);
		
		objConnection.close();
		
		}
		catch(JMSException e)
		{
			System.out.println(e.toString());
			return "Message not received successfully";
		}
		
	 return st;	
		
	}

}
