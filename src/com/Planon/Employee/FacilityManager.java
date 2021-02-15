package com.Planon.Employee;

import com.Planon.Ticket.Ticket;

public class FacilityManager implements Associate {
	String FMName;
	String FMId;
	String FMTicketType;
	Ticket FMticket;
	
	public FacilityManager(String fMName, String fMId, String fMTicketType, Ticket ticket) {
		super();
		FMName = fMName;
		FMId = fMId;
		FMTicketType = fMTicketType;
		FMticket = ticket;
		assignTicket(ticket);
	}
	
	private void assignTicket(Ticket ticket) {
		//depending on ticket decide which staff member to allocate the ticket
		
	}
	
	public FacilityManager() {
		
	}
}
