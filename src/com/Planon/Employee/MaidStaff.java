package com.Planon.Employee;

import java.util.logging.Logger;

import com.Planon.Client.FacilityConstants;
import com.Planon.Facilities.Cleaning;
import com.Planon.Ticket.Ticket;

public class MaidStaff implements StaffMembers, Cleaning {
	
	public static  Logger logger = Logger.getLogger(MaidStaff.class.getName());
	
	String maidName;
	String maidAddress;
	String staffId;
	
	public String getMaidName() {
		return maidName;
	}
	public String getMaidAddress() {
		return maidAddress;
	}
	
	public MaidStaff(String maidName, String maidAddress, String maidId) {
		super();
		this.maidName = maidName;
		this.maidAddress = maidAddress;
		this.staffId = maidId;
	}
	
	public MaidStaff() {
		
	}
	
	@Override
	public void cleanTheRoom() {
		logger.info("Cleaning the room.");
		
	}
	@Override
	public void cleanTheWashroom() {
		logger.info("Cleaning the washrooms.");
		
	}
	@Override
	public void doTheAssignedTask(Ticket ticket) {
		//depending on ticket description decide the task to be done
		cleanTheRoom();
		cleanTheWashroom();
	}
	
	@Override
	public String getEmployeeDetails() {
		return "Maid " + this.maidName;
	}
	
	@Override
	public void notifyTheTicketOwner(Ticket ticket) {
		logger.info("Hi " + this.maidName + ". A ticket has been assigned to you.");
		logger.info(ticket.getTicketDetails(ticket));
		ticket.setTicketStatus(FacilityConstants.IN_PROGRESS_STATUS);
		
	}
}
