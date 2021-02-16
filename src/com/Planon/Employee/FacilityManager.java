package com.Planon.Employee;

import java.util.logging.Logger;

import com.Planon.Client.FacilityConstants;
import com.Planon.Ticket.Ticket;

public class FacilityManager implements Associate {
	
	public static  Logger logger = Logger.getLogger(FacilityManager.class.getName());
	String fmName;
	String fmId;
	Ticket fmTicket;
	
	public FacilityManager(String fMName, String fMId) {
		super();
		fmName = fMName;
		fmId = fMId;
	}
	
	public Ticket getFMticket() {
		return fmTicket;
	}

	public void setFMticket(Ticket fMticket) {
		fmTicket = fMticket;
	}

	private void assignTicket(Ticket ticket) {
		//depending on ticket decide which staff member to allocate the ticket
		StaffMembers staffToAssignTheTask = StaffMemberFactory.getAvailableStaffMemberForAFacility(ticket.getTicketTypeBasedOnFacility());
		ticket.setTicketAssignedToForWork(staffToAssignTheTask);
		ticket.setTicketStatus(FacilityConstants.ASSIGNED_STATUS);
	}
	
	public FacilityManager() {
		
	}
	
	@Override
	public String getEmployeeDetails() {
		return this.fmName + "(" + this.fmId + ")";
	}

	@Override
	public void notifyTheTicketOwner(Ticket ticket) {
		logger.info("Hi " + this.fmName +". A ticket has been logged by " + ticket.getTicketLoggedBy().getEmployeeDetails() + " for " + ticket.getTicketTypeBasedOnFacility() + ".");
		//assign the ticket
		assignTicket(ticket);
	}
}
