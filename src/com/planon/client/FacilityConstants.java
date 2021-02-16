package com.planon.client;

import java.util.HashMap;

import com.planon.facilities.Catering;

public class FacilityConstants {
	public static final HashMap<Integer, String>FACILITY_TYPES = new HashMap<>();
	public static final HashMap<Integer, String>FACILITY_TYPES_ISSUES = new HashMap<>();
	public static final HashMap<Integer, String>TICKET_TYPES = new HashMap<>();
	public static final String CLEANING = "Cleaning";
	public static final String CATERING = "Catering";
	public static final String SECURITY = "Security";
	public static final String STATIONERY = "Stationery";
	public static final String BOOK_A_ROOM = "Book a Room";
	public static final String FOOD_REIMBURSMENT = "Food Reimbursment";
	public static final String TRAVEL_REIMBURSMENT = "Travel Reimbursment";
	public static final String REQUEST_TICKET = "Request Ticket";
	public static final String COMPLAIN_TICKET = "Complain Ticket";
	public static final String INCIDENT_TICKET = "Incident Ticket";
	public static final String POOL_STATUS = "In pool";
	public static final String IN_PROGRESS_STATUS = "In Progress";
	public static final String ON_HOLD_STATUS = "On hold";
	public static final String CLOSED_STATUS = "Closed";
	public static final String ASSIGNED_STATUS = "Assigned";
	public static final String FIXED_STATUS = "Fixed";
	public static final String WRONG_INPUT = "Wrong input!";
	
	public FacilityConstants() {
		FACILITY_TYPES.put(1, CLEANING);
		FACILITY_TYPES.put(2, CATERING);
		FACILITY_TYPES.put(3, STATIONERY);
		FACILITY_TYPES.put(4, SECURITY);
		FACILITY_TYPES.put(5, FOOD_REIMBURSMENT);
		
		FACILITY_TYPES_ISSUES.put(1, "Girls washrooms on 1st floor are not clean.");
		FACILITY_TYPES_ISSUES.put(2, "There are not enough plates in the cafeteria");
		FACILITY_TYPES_ISSUES.put(3, "Please get me a board marker in meeting room 2.");
		FACILITY_TYPES_ISSUES.put(4, "There is a person without ID card please check.");
		FACILITY_TYPES_ISSUES.put(5, "I got late yesterday because of work and had to have dinner here in office. Kindly reimburse my money.");
		
		TICKET_TYPES.put(1, REQUEST_TICKET);
		TICKET_TYPES.put(2, COMPLAIN_TICKET);
		TICKET_TYPES.put(3, INCIDENT_TICKET);
	}
}
