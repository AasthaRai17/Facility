package com.Planon.Ticket;

import com.Planon.Client.FacilityConstants;
import com.Planon.Client.StaticInputData;
import com.Planon.Employee.Employee;

public class TicketForRequest extends Ticket {
	@Override
	void setTicketType() {
		typeOfTicket = FacilityConstants.REQUEST_TICKET;
		
	}

	public TicketForRequest(Employee ticketOwner, String ticketDescription, String ticketTypeBasedOnFacility,
			Employee ticketLoggedBy, Employee ticketAssignedToForWork) {
		super();
		this.ticketOwner = ticketOwner;
		this.ticketDescription = ticketDescription;
		this.ticketTypeBasedOnFacility = ticketTypeBasedOnFacility;
		this.ticketLoggedBy = ticketLoggedBy;
		this.ticketAssignedToForWork = ticketAssignedToForWork;
		this.ticketId = String.valueOf(StaticInputData.listOfTickets.size()+1);
		this.typeOfTicket = FacilityConstants.REQUEST_TICKET;
	}

	public TicketForRequest() {
		// TODO Auto-generated constructor stub
	}
}
