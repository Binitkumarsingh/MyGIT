package com.aricent.eip.itsm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class ConsumeRestWebservice {

	@Autowired
	RestTemplate restTemplate;

	private String ticketid; 
	
	
	public String getTicketid() {
		return ticketid;
	}


	public void setTicketid(String ticketid) {
		this.ticketid = ticketid;
	}


	public String consumeRestws(String uri)
	{
		
//		String url=uri+ticketid;
		System.out.println("URL is "+uri);
		String TicketDetails=restTemplate.getForObject(uri, String.class);
		return TicketDetails;
	}
	
}
