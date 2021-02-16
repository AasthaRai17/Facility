package com.Planon.Ticket;

import com.Planon.Client.FacilityConstants;
import com.Planon.Client.StaticInputData;
import com.Planon.Employee.Employee;

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
		this.ticketId = String.valueOf(StaticInputData.listOfTickets.size()+1);
		this.typeOfTicket = FacilityConstants.COMPLAIN_TICKET;
		this.ticketStatus = FacilityConstants.POOL_STATUS;
	}

	public TicketForComplain() {
		// TODO Auto-generated constructor stub
	}
	

}
