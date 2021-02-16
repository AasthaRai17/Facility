package com.planon.genericFacilityUtilityFunctions;

import java.util.List;
import java.util.stream.Collectors;

import com.planon.client.StaticInputData;
import com.planon.employee.Employee;
import com.planon.ticket.Ticket;
import com.planon.ticket.TicketFactory;

public class GenericTicketFunctions {
	
	public List<Ticket> viewAllTicketsLoggedByAPerson(Employee loggedBy) {
		
		return  StaticInputData.listOfTickets
				.stream()
				.filter(oneTicket -> oneTicket.getTicketLoggedBy().equals(loggedBy))
				.collect(Collectors.toList());
		
	}

	public void printTicketDetais(List<Ticket> listOfTickets) {
		//print all tickets
		listOfTickets.forEach(ticket -> ticket.getTicketDetails(ticket));
	}
	
	public List<Ticket> viewAllTicketsAssignedToAPerson(Employee assignedTo) {
		
		return  StaticInputData.listOfTickets
				.stream()
				.filter(oneTicket -> oneTicket.getTicketAssignedToForWork().equals(assignedTo))
				.collect(Collectors.toList());
		
	}
	
	public Ticket createANewTicketWithDefaultOwnerAsFacilityMgr(String ticketFacilityType, String typeOfTicket, String ticketDescription, Employee loggedBy) {
		
		Ticket ticket = TicketFactory.getTicketType(typeOfTicket);
		
		ticket.setTicketId();
		ticket.setTicketDescription(ticketDescription);
		ticket.setTicketType();
		ticket.setTicketTypeBasedOnFacility(ticketFacilityType);
		ticket.setTicketLoggedBy(loggedBy);
		ticket.setTicketOwnerAndNotify(StaticInputData.facilityManager);
		return ticket;
	}
	
}
