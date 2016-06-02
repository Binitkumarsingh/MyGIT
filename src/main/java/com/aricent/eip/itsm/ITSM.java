package com.aricent.eip.itsm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="itsm")
public class ITSM {

  /*private long id;
  
  
  private String email;
    
  private String name;*/
	
	private String TicketID;
	private String TicketDetails;
	private String TicketDescription;
	
  public ITSM () { };
  
 /*public User(long id) { 
    this.id = id;
  }

  public User(String email, String name) {
    this.email = email;
    this.name = name;
  }
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long getId() {
    return id;
  }

  public void setId(long value) {
    this.id = value;
  }
  @NotNull
  @Size(min = 3, max = 80)
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String value) {
    this.email = value;
  }
  @NotNull
  @Size(min = 2, max = 80)
  public String getName() {
    return name;
  }

  public void setName(String value) {
    this.name = value;
  }*/
  
 /* ### Adding details of itsm table ### */
  
  
  public ITSM(String TicketID,String TicketDetails,String TicketDescription) { 
	    this.TicketID = TicketID;
	    this.TicketDetails = TicketDetails;
	    this.TicketDescription = TicketDescription;
	  }
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
public String getTicketID() {
	return TicketID;
}

public void setTicketID(String value) {
	this.TicketID = value;
}
@NotNull
@Size(min = 3, max = 80)
public String getTicketDetails() {
	return TicketDetails;
}

public void setTicketDetails(String value) {
	this.TicketDetails = value;
}
@NotNull
@Size(min = 3, max = 80)
public String getTicketDescription() {
	return TicketDescription;
}

public void setTicketDescription(String value) {
	this.TicketDescription = value;
} 

  
} // class itsm
