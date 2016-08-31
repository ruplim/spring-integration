package com.samples;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.integration.annotation.Aggregator;
import org.springframework.integration.annotation.CorrelationStrategy;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import com.samples.jaxb.ObjectFactory;
import com.samples.jaxb.Order;
import com.samples.jaxb.OrderItemType;

public class OrderAggregator {
	
	private static final Logger LOGGER = Logger.getLogger(OrderAggregator.class);
	private ObjectFactory orderFactory;
	
	
	public void setOrderFactory(ObjectFactory orderFactory) {
		this.orderFactory = orderFactory;
	}
	
	public ObjectFactory getOrderFactory() {
		return orderFactory;
	}
	
	/*  logic to create a single message from many  */
	public List<Order> createOrders(List<OrderItemType> orderItemTypeList) {
		
		Order order = null;		
		List<Order> orderList = new ArrayList<Order>(orderItemTypeList.size());
		
		/* Individual  'OrderItemType' should be inside the bucket 'Order' */
		for( OrderItemType oit : orderItemTypeList) {
			order = getOrderFactory().createOrder();
			order.getOrderItem().add(oit);
			orderList.add(order);
			
            order = null;
		}
		LOGGER.info(" #### Returning list of order size:" + orderList.size());
		return   orderList;
	}
	
	/*  logic to determine how messages are grouped for aggregation */
	@CorrelationStrategy
	public String groupOrders( Message<OrderItemType> message) {
		//Use any value to Group the messages as there is no specific grouping requirement for this use case
		//If grouping requirements are present, we can use the payload to group
		LOGGER.info(" #### Assigning data for aggregation of order item (ISBN):" + message.getPayload().getIsbn());		
		return "orderitems006";
	}
}
