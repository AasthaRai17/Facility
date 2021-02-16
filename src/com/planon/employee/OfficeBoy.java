package com.planon.employee;

import java.util.logging.Logger;

import com.planon.client.Client;
import com.planon.client.FacilityConstants;
import com.planon.facilities.RoomBookingManagement;
import com.planon.facilities.StationeryManagement;
import com.planon.facilities.WorkstationManagement;
import com.planon.ticket.Ticket;

public class OfficeBoy implements StaffMembers, StationeryManagement, WorkstationManagement, RoomBookingManagement {
	
	
	public static  Logger logger = Logger.getLogger(OfficeBoy.class.getName());
	
	String officeBoyName;
	String officeBoyAddress;
	String officeBoyId;
	
	public String getOfficeBoyAddress() {
		return officeBoyAddress;
	}

	public OfficeBoy(String officeBoyName, String officeBoyAddress, String officeBoyId) {
		super();
		this.officeBoyName = officeBoyName;
		this.officeBoyAddress = officeBoyAddress;
		this.officeBoyId = officeBoyId;
	}
	
	public OfficeBoy() {
		
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void bookTheRoom() {
		logger.info("Booking a room.");
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fixTheWorkstationDrawerIssue() {
		logger.info("Fixing the drawer issue");
		
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void assetMovement() {
		logger.info("Asset movement is in progress.");
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getStaffId() {
		return this.officeBoyId;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getStaffMemberName() {
		return this.officeBoyName;
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doTheAssignedTask(Ticket ticket) {
		//depending on theticket description decide the task of office boy and call the respective function
		assetMovement();
		fixTheWorkstationDrawerIssue();
		bookTheRoom();
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getEmployeeDetails() {
		return "Office boy " + this.officeBoyName;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void ticketNotification(Ticket ticket) {
		logger.info("Hi " + this.officeBoyName + ". A ticket has been assigned to you.");
		logger.info(ticket.getTicketDetails(ticket));
		ticket.setTicketStatus(FacilityConstants.IN_PROGRESS_STATUS);
		
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void ticketUpdateNotification(Ticket ticket) {
		logger.info("Hi " + this.officeBoyName +". Ticket number " + ticket.getTicketId() + " has been marked " + ticket.getTicketStatus());
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((officeBoyAddress == null) ? 0 : officeBoyAddress.hashCode());
		result = prime * result + ((officeBoyId == null) ? 0 : officeBoyId.hashCode());
		result = prime * result + ((officeBoyName == null) ? 0 : officeBoyName.hashCode());
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
		OfficeBoy other = (OfficeBoy) obj;
		if (officeBoyAddress == null) {
			if (other.officeBoyAddress != null)
				return false;
		} else if (!officeBoyAddress.equals(other.officeBoyAddress))
			return false;
		if (officeBoyId == null) {
			if (other.officeBoyId != null)
				return false;
		} else if (!officeBoyId.equals(other.officeBoyId))
			return false;
		if (officeBoyName == null) {
			if (other.officeBoyName != null)
				return false;
		} else if (!officeBoyName.equals(other.officeBoyName))
			return false;
		return true;
	}

}
