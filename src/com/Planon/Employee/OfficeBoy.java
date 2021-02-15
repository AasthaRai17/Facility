package com.Planon.Employee;

import java.util.logging.Logger;

import com.Planon.Client.Client;
import com.Planon.Facilities.RoomBookingManagement;
import com.Planon.Facilities.StationeryManagement;
import com.Planon.Facilities.WorkstationManagement;
import com.Planon.Ticket.Ticket;

public class OfficeBoy implements StaffMembers, StationeryManagement, WorkstationManagement, RoomBookingManagement {
	
	
	public static  Logger logger = Logger.getLogger(OfficeBoy.class.getName());
	
	String officeBoyName;
	String officeBoyAddress;
	String officeBoyId;
	
	public String getOfficeBoyName() {
		return officeBoyName;
	}

	public String getOfficeBoyAddress() {
		return officeBoyAddress;
	}

	public String getOfficeBoyId() {
		return officeBoyId;
	}

	public OfficeBoy(String officeBoyName, String officeBoyAddress, String officeBoyId) {
		super();
		this.officeBoyName = officeBoyName;
		this.officeBoyAddress = officeBoyAddress;
		this.officeBoyId = officeBoyId;
	}
	
	public OfficeBoy() {
		
	}


	@Override
	public void bookTheRoom() {
		logger.info("Booking a room.");
	}

	@Override
	public void fixTheWorkstationDrawerIssue() {
		logger.info("Fixing the drawer issue");
		
	}

	@Override
	public void assetMovement() {
		logger.info("Asset movement is in progress.");
	}

	@Override
	public void doTheNeedful(Ticket ticket) {
		//depending on theticket description decide the task of office boy and call the respective function
		assetMovement();
		fixTheWorkstationDrawerIssue();
		bookTheRoom();
	}

}
