package com.planon.ticket;

import com.planon.client.FacilityConstants;
import com.planon.employee.Employee;

public class TicketForComplain extends Ticket {

	@Override
	public void setTicketType() {
		typeOfTicket = FacilityConstants.COMPLAIN_TICKET;
		
	}
	
	public TicketForComplain(Employee ticketOwner, String ticketDescription, String ticketTypeBasedOnFacility,
			Employee ticketLoggedBy, Employee ticketAssignedToForWork) {
		super();
		this.ticketOwner = ticketOwner;
		this.ticketDescription = ticketDescription;
		this.ticketTypeBasedOnFacility = ticketTypeBasedOnFacility;
		this.ticketLoggedBy = ticketLoggedBy;
		this.ticketAssignedToForWork = ticketAssignedToForWork;
		this.ticketStatus = FacilityConstants.POOL_STATUS;
		setTicketType();
		setTicketId();
	}

	public TicketForComplain() {
		// TODO Auto-generated constructor stub
	}
	

}
