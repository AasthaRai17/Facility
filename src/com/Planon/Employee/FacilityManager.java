package com.Planon.Employee;

import com.Planon.Ticket.Ticket;

public class FacilityManager implements Associate {
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
		StaffMembers staffToAssignTheTask = StaffMemberFactory.getAvailableStaffMemberForAFacility(ticket.getTicketFacilityType());
		ticket.setStaffToWork(staffToAssignTheTask);
	}
	
	public FacilityManager() {
		
	}
}
