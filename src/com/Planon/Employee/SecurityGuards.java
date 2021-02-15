package com.Planon.Employee;

import java.util.logging.Logger;

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
	public void doTheNeedful(Ticket ticket) {
		logger.info("doing the needful for security.");
		
	}
	
	
}
