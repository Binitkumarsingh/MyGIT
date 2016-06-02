package com.aricent.eip.itsm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SimpleProcessor implements Processor {
	
	@Value("${uri}")
	private String uri;
	@Autowired	
	SessionFactory sessionfactory;
	@Value("${threads}")
	private String threads;
	
	@Value("${queue.ticketDetail}")
	String queueTicketId;
	
	@Autowired
	ProcessThread processThread;
	
	@Autowired
    private ProducerTemplate producer;
	
	public void process(Exchange exchange) throws Exception {
		System.out.println("Processing TicketID ");
		
		
		String ticketidStr = exchange.getIn().getBody(String.class);
		
		System.out.println("Processing TicketID "+ticketidStr);
		String[] ticketids = ticketidStr.split(",");
		int numberThreads = Integer.parseInt(threads);
		ExecutorService executor = Executors.newFixedThreadPool(numberThreads);

		for (int i = 0; i < ticketids.length; i++) {
			System.out.println("Processing TicketID " + ticketids[i]);
			
			processThread.setTicketids(ticketids[i]);
			
			processmessage();
			Future<String> result = executor.submit(processThread);
			
			System.out.println("Printing result"+result);
//			User us = new User();
//			us.setName("sss");
//			us.setId(1);
//			us.setEmail("Aricent");
			
			ITSM it = new ITSM();
			it.setTicketID("123");
			it.setTicketDetails("Aricent");
			it.setTicketDescription("Aricent123");
	//UserDao userDao = new UserDao();
		   System.out.println();
		   sessionfactory.openSession().save(it);
			System.out.println("I am in here in" + sessionfactory);
			
			System.out.println("I am in here in" + sessionfactory.openSession());
	//	producer.sendBody("hibernate:netgloo.models.User", us);
		
		}
		executor.shutdown();

	}

	private void processmessage() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
