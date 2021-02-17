package com.planon.employee;

import java.util.logging.Logger;

import com.planon.client.FacilityConstants;
import com.planon.facilities.Security;
import com.planon.ticket.Ticket;

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


	@Override
	public void doTheAssignedTask(Ticket ticket) {
		logger.info("doing the needful for security.");
		
	}
	
	@Override
	public String getEmployeeDetails() {
		return "Security Guard " + this.scName;
	}
	
	@Override
	public String getStaffId() {
		return this.scId;
	}
	
	@Override
	public String getStaffMemberName() {
		return this.scName;
	}
	
	@Override
	public void ticketNotification(Ticket ticket) {
		logger.info("Hi " + this.scName + ". A ticket has been assigned to you.");
		logger.info(ticket.getTicketDetails(ticket));
		ticket.setTicketStatus(FacilityConstants.IN_PROGRESS_STATUS);
	}

	@Override
	public void ticketUpdateNotification(Ticket ticket) {
		logger.info("Hi " + this.scName +". Ticket number " + ticket.getTicketId() + " has been marked " + ticket.getTicketStatus());
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((scAddress == null) ? 0 : scAddress.hashCode());
		result = prime * result + ((scId == null) ? 0 : scId.hashCode());
		result = prime * result + ((scName == null) ? 0 : scName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SecurityGuards other = (SecurityGuards) obj;
		if (scAddress == null) {
			if (other.scAddress != null)
				return false;
		} else if (!scAddress.equals(other.scAddress))
			return false;
		if (scId == null) {
			if (other.scId != null)
				return false;
		} else if (!scId.equals(other.scId))
			return false;
		if (scName == null) {
			if (other.scName != null)
				return false;
		} else if (!scName.equals(other.scName))
			return false;
		return true;
	}
	
}
