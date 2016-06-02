package com.aricent.eip.itsm;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PollerProcessor {

	@Autowired
    private ProducerTemplate producer;
    
    @Autowired
	private ConsumeRestWebservice consumeRestWebservice;
	
    @Value("${queue.ticketId}")
	String queueTicketId;
    
//	public void poll(String url) throws Exception 
    public String poll() throws Exception 
	{
    	String url = "http://10.206.218.54:8080/ticket";
		String ticketId = consumeRestWebservice.consumeRestws(url);
		System.out.println(ticketId);
		return ticketId;
//		producer.sendBody(queueTicketId, ticketId);
	}

}
