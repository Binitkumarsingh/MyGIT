package com.aricent.eip.itsm;

import java.io.IOException;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ITSMRouter extends RouteBuilder {

	
	@Value("${poller.from}")
	String pollerFrom;
	
	@Value("${poll.to}")
	String pollerTo;

	@Value("${route.from}")
	String routeFrom;
	
	@Value("${route.to}")
	String routeTo;
	
	@Value("${queue.ticketId}")
	String queueTicketId;
	
	@Value("${route.queueTicketDetails}")
	String queueTicketDetails;
	
	@Override
	public void configure() throws IOException {
		System.out.println("In Config Class"+pollerFrom+pollerTo);
		System.out.println("In Config Class"+routeFrom+routeTo);
		from(pollerFrom).bean(PollerProcessor.class,"poll").to(queueTicketId);
		from(queueTicketId).bean(SimpleProcessor.class);
		//.to(queueTicketDetails);		
//		from(queueTicketDetails).to("dozer:transformOrder?mappingFile=DozerFile.xml&targetModel=").
//		  to("targetsystem");
	}
		
}