package com.aricent.eip.itsm;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProcessThread implements Callable<String>{
	
	
	@Autowired
	ConsumeRestWebservice consumeRestWebservice;

	@Value("${uri}")
	private String uri;
	
	
	private String ticketId;
	
	public String getTicketids() {
		return ticketId;
	}
	public void setTicketids(String ticketId) {
		this.ticketId = ticketId;
	}

	public String call() throws Exception {
		
		// TODO Auto-generated method stub
//		System.out.println("URI is "+uri+ "Ticketids is "+ticketids);
		
//	ConsumeRestWebservice ws=new ConsumeRestWebservice();
//		consumeRestWebservice.setTicketid(ticketids);
		
		
		
		String TicketDetails= consumeRestWebservice.consumeRestws(uri+getTicketids());
		System.out.println("TicketDetails are "+TicketDetails);
		//System.out.println("URI is "+uri);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return TicketDetails;
	}
	
}
