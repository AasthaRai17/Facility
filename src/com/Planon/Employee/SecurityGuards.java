package com.Planon.Employee;

import java.util.logging.Logger;

import com.Planon.Client.FacilityConstants;
import com.Planon.Facilities.Security;
import com.Planon.Ticket.Ticket;

public class SecurityGuards implements StaffMembers, Security {
	public static  Logger logger = Logger.getLogger(SecurityGuards.class.getName());
	
	String scName;
	String scAddress;
	String scId;
	
	public SecurityGuards() {
		
	}
	
	public SecurityGuards(String scName, String scAddress, String scId) {
		super();
		this.scName = scName;
		this.scAddress = scAddress;
		this.scId = scId;
	}

	public String getScName() {
		return scName;
	}

	public String getScAddress() {
		return scAddress;
	}

	public String getScId() {
		return scId; 
	}

	@Override
	public void doTheAssignedTask(Ticket ticket) {
		logger.info("doing the needful for security.");
		
	}
	
	@Override
	public String getEmployeeDetails() {
		return "Security Guard " + this.scName;
	}
	
	@Override
	public void notifyTheTicketOwner(Ticket ticket) {
		logger.info("Hi " + this.scName + ". A ticket has been assigned to you.");
		logger.info(ticket.getTicketDetails(ticket));
		ticket.setTicketStatus(FacilityConstants.IN_PROGRESS_STATUS);
	}
}
