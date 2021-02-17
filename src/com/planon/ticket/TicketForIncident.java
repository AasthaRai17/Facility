package com.planon.ticket;

import com.planon.client.FacilityConstants;
import com.planon.client.StaticInputData;
import com.planon.employee.Employee;

public class TicketForIncident extends Ticket {
	
	@Override
	public void setTicketType() {
		typeOfTicket = FacilityConstants.INCIDENT_TICKET;
		
	}
	
	public TicketForIncident(Employee ticketOwner, String ticketDescription, String ticketTypeBasedOnFacility,
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

	public TicketForIncident() {
		// TODO Auto-generated constructor stub
	}
	
}
