package com.java.personal.arpit.OrderBridging;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ORDERPOSTING")
public class Orderposting 
{
	@Id
	@Column(name="Order_nbr")
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="ORDER_GENERATOR")
	@SequenceGenerator(name="ORDER_GENERATOR", sequenceName="ORDER_GENERATOR", allocationSize=1)
	
	
	long Order_nbr; 
	String item_name , Delivery_address , customer_order , Customer_name ;
	long quantity ;
	long postal_code;
	
	
	
	public Orderposting(long order_nbr, String item_name, String delivery_address, String customer_order,
			String customer_name, int quantity, long postal_code) {
		super();
		Order_nbr = order_nbr;
		this.item_name = item_name;
		Delivery_address = delivery_address;
		this.customer_order = customer_order;
		Customer_name = customer_name;
		this.quantity = quantity;
		this.postal_code = postal_code;
	}
	
	
	
	
	public Orderposting() {
		super();
		// TODO Auto-generated constructor stub
	}




	public String getCustomer_name() {
		return Customer_name;
	}
	public void setCustomer_name(String customer_name) {
		Customer_name = customer_name;
	}
	public long getOrder_nbr() {
		return Order_nbr;
	}
	public void setOrder_nbr(long order_nbr) {
		Order_nbr = order_nbr;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getDelivery_address() {
		return Delivery_address;
	}
	public void setDelivery_address(String delivery_address) {
		Delivery_address = delivery_address;
	}
	public String getCustomer_order() {
		return customer_order;
	}
	public void setCustomer_order(String customer_order) {
		this.customer_order = customer_order;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(long postal_code) {
		this.postal_code = postal_code;
	}
	
	

}
