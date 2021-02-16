package com.planon.ticket;

import com.planon.client.FacilityConstants;

public class TicketFactory {
	
	public static Ticket getTicketType(String ticketType) {
		
		switch(ticketType) {
			case FacilityConstants.REQUEST_TICKET:
				return new TicketForRequest();
			case FacilityConstants.COMPLAIN_TICKET:
				return new TicketForComplain();
			case FacilityConstants.INCIDENT_TICKET:
				return new TicketForIncident();
			default:return null;
		}
		
	}
}
