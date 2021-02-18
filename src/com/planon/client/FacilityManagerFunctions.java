package com.planon.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.planon.customExceptions.TicketNotFoundException;
import com.planon.customExceptions.UserNotFoundException;
import com.planon.employee.FacilityManager;
import com.planon.ticket.Ticket;

public class FacilityManagerFunctions {
	
	private Logger logger = Logger.getLogger(FacilityManagerFunctions.class.getName());
	private List<Ticket> tickets = new ArrayList<>();
	/**
	 * function is called when the logged in user is a facility manager
	 * wrt the manager multiple options are provided to the person to take actions for tickets logged in
	 * @param sc
	 */
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

	/**
	 * once the facility manager has validated oneself, further options are made available to the manager to perform 
	 * required actions on the tickets
	 * @param sc
	 */
	private void facilityMgrLoginOptions(Scanner sc) {
		logger.info("Please press 1 to view all the tickets, 2 to update a ticket, 0 to go back to previous menu.");
		int options = Integer.parseInt(sc.nextLine());
		
		switch(options) {
			case 0: Client.facilityManagementWelcomePortal();
			break;
			case 1: viewAllTicketsByManager();
			break;
			case 2: updateStatusOfATicketByManager(sc);
			break;
			default:{
				logger.info(FacilityConstants.WRONG_INPUT);
				facilityMgrLoginOptions(sc);
			}
		}
	}

	
	/**
	 * the function is called when the manager chooses to update the status of a ticket
	 * in this user provides the ticket number he wants to update the ticket number is validated if ir exists or not
	 * @param sc
	 */
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
				
				updateTicketOptionsByManager(sc);
				
			}
			
			
			
		}catch(TicketNotFoundException e) {
			e.getMessage();
			updateStatusOfATicketByManager(sc);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * the function is called to provide options to facility manager to update the passed ticket after its validation
	 * depending upon the action chosen further functions are called to perform the respective actions of ticket update
	 * @param sc
	 * @param tickets
	 */
	private void updateTicketOptionsByManager(Scanner sc) {
		logger.info("Press 1 to set status as Closed, 2 to set status as Reopen, 3 to reassign the ticket to a staff member, 0 to go back to previous menu");
		int options = Integer.parseInt(sc.nextLine());
		
		switch(options) {
			case 1:	updateStatusOfTicketByManager(FacilityConstants.CLOSED_STATUS);
			break;
			case 2: updateStatusOfTicketByManager(FacilityConstants.REOPEN_STATUS);
			break;
			case 3: updateAssignedToOfATicketByManager();
			break;
			case 0: updateStatusOfATicketByManager(sc);
			break;
			default:{
				logger.info(FacilityConstants.WRONG_INPUT);
				updateTicketOptionsByManager(sc);
			}
			
			
		}
	}

	/**
	 * function updates the assigned to user of the ticket and sends an notification to all the stakeholders
	 * of the particular ticket
	 * @param tickets is list which by default has one single ticket and hence its 0th element is retrieved
	 */
	private void updateAssignedToOfATicketByManager() {
		((FacilityManager) StaticInputData.facilityManager).assignTicket(tickets.get(0));
		FacilityConstants.TICKET_GENERIC_FUNCTIONS.ticketUpdateNotificationToAllStakeholders(tickets);
	}

	/**
	 * function is called to update the status of ticket and send notification to all the stakeholders 
	 * of the particular ticket
	 * @param tickets is list which by default has one single ticket and hence its 0th element is retrieved
	 * @param status is the status which needs to be set to the ticket
	 */
	private void updateStatusOfTicketByManager(String status) {
		FacilityConstants.TICKET_GENERIC_FUNCTIONS.updateTicketStatusAndSendNotifaction(tickets.get(0), status);
		
	}

	/**
	 * function to view all the tickets irrespective of the logger or status.
	 * it will print brief details of all the tickets in the system.
	 * @param sc
	 */
	private void viewAllTicketsByManager() {
		FacilityConstants.TICKET_GENERIC_FUNCTIONS.printTicketDetais(StaticInputData.listOfTickets);
		
	}
}
