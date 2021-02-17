package com.planon.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.planon.customExceptions.TicketNotFoundException;
import com.planon.customExceptions.UserNotFoundException;
import com.planon.employee.Employee;
import com.planon.employee.FacilityManager;
import com.planon.genericFacilityUtilityFunctions.GenericTicketFunctions;
import com.planon.ticket.Ticket;

public class FacilityManagerFunctions {
	
	Logger logger = Logger.getLogger(FacilityManagerFunctions.class.getName());
	private GenericTicketFunctions ticketFn = new GenericTicketFunctions();
	List<Ticket> tickets = new ArrayList<>();
	
	public void facilitManagerLogin(Scanner sc) {
		//view all the tickets
		//mark tickets to resolved
		//update ticket assigned to
		try {
			
			logger.info("Please enter your employee id to proceed: ");
			String empid = sc.nextLine();
			
			if(!((FacilityManager) StaticInputData.facilityManager).getFmId().equals(empid))
				throw new UserNotFoundException(empid);
			
			facilityMgrLoginOptions(sc);
		}catch(UserNotFoundException e) {
			e.getMessage();
			facilitManagerLogin(sc);
		}catch(Exception e) {
			logger.info("Exception in facilityConsumerLogin: " + e);
		}
		
		
	}

	private void facilityMgrLoginOptions(Scanner sc) {
		logger.info("Please press 1 to view all the tickets, 2 to update a ticket, 0 to go back to previous menu.");
		int options = Integer.parseInt(sc.nextLine());
		
		switch(options) {
			case 0: Client.facilityManagementWelcomePortal();
			break;
			case 1: viewAllTicketsByManager(sc);
			break;
			case 2: updateStatusOfATicketByManager(sc);
			break;
			default:{
				logger.info(FacilityConstants.WRONG_INPUT);
				facilityMgrLoginOptions(sc);
			}
		}
	}

	private void updateStatusOfATicketByManager(Scanner sc) {
		
		try {
			
			logger.info("Please enter ticket number to update status or press 0 to go back to previous menu");
			String ticketNo = sc.nextLine();
			
			if(ticketNo=="0") 
				facilityMgrLoginOptions(sc);
			else {
				
				tickets = StaticInputData.listOfTickets.stream().filter(ticket -> ticket.getTicketId().equals(ticketNo)).collect(Collectors.toList());
				if(tickets.isEmpty())
					throw new TicketNotFoundException(ticketNo);
				
				updateTicketOptionsByManager(sc, tickets);
				
			}
			
			
			
		}catch(TicketNotFoundException e) {
			e.getMessage();
			updateStatusOfATicketByManager(sc);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private void updateTicketOptionsByManager(Scanner sc, List<Ticket> tickets) {
		logger.info("Press 1 to set status as Closed, 2 to set status as Reopen, 3 to reassign the ticket to a staff member, 0 to go back to previous menu");
		int options = Integer.parseInt(sc.nextLine());
		
		switch(options) {
			case 1:	updateStatusOfTicketByManager(tickets, FacilityConstants.CLOSED_STATUS);
			break;
			case 2: updateStatusOfTicketByManager(tickets, FacilityConstants.REOPEN_STATUS);
			break;
			case 3: updateAssignedToOfATicketByManager(tickets);
			break;
			case 0: updateStatusOfATicketByManager(sc);
			break;
			default:{
				logger.info(FacilityConstants.WRONG_INPUT);
				updateTicketOptionsByManager(sc, tickets);
			}
			
			
		}
	}

	private void updateAssignedToOfATicketByManager(List<Ticket> tickets) {
		((FacilityManager) StaticInputData.facilityManager).assignTicket(tickets.get(0));
		ticketFn.ticketUpdateNotificationToAllStakeholders(tickets);
	}

	private void updateStatusOfTicketByManager(List<Ticket> tickets, String status) {
		ticketFn.updateTicketStatusAndSendNotifaction(tickets.get(0), status);
		
	}

	/**
	 * function to view all the tickets irrespective of the logger or status.
	 * it will print brief details of all the tickets in the system.
	 * @param sc
	 */
	private void viewAllTicketsByManager(Scanner sc) {
		ticketFn.printTicketDetais(StaticInputData.listOfTickets);
		
	}
}
