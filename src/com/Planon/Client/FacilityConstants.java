package com.Planon.Client;

import java.util.HashMap;

import com.Planon.Facilities.Catering;

public class FacilityConstants {
	public static final HashMap<Integer, String>FACILITY_TYPES = new HashMap<>();
	public static final HashMap<Integer, String>TICKET_TYPES = new HashMap<>();
	public static final String CLEANING = "Cleaning";
	public static final String CATERING = "Catering";
	public static final String SECURITY = "Security";
	public static final String STATIONERY = "Stationery";
	public static final String FOOD_REIMBURSMENT = "Food Reimbursment";
	public static final String REQUEST_TICKET = "Request Ticket";
	public static final String COMPLAIN_TICKET = "Complain Ticket";
	public static final String INCIDENT_TICKET = "Incident Ticket";
	
	public FacilityConstants() {
		FACILITY_TYPES.put(1, CLEANING);
		FACILITY_TYPES.put(2, CATERING);
		FACILITY_TYPES.put(3, STATIONERY);
		FACILITY_TYPES.put(4, STATIONERY);
		FACILITY_TYPES.put(5, FOOD_REIMBURSMENT);
		TICKET_TYPES.put(1, REQUEST_TICKET);
		TICKET_TYPES.put(2, COMPLAIN_TICKET);
		TICKET_TYPES.put(3, INCIDENT_TICKET);
	}
}
