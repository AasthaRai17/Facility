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
import com.planon.employee.StaffMembers;
import com.planon.genericFacilityUtilityFunctions.GenericTicketFunctions;
import com.planon.ticket.Ticket;

/**
 * this class is with respect to staff member login
 * all the process and functions to be done or are done are available in the class
 * @author aarai
 *
 */
public class FacilityStaffFunctions {
	
	Logger logger = Logger.getLogger(FacilityStaffFunctions.class.getName());
	//holds the value for current logged in staff member on 0th location
	private List<StaffMembers> currentStaffMember = new ArrayList<>();
	//holds the ticket which is currently being accessed by the staff member on 0th location
	private List<Ticket> ticketToBeUpdated = new ArrayList<>();
	
	/**
	 * function takes user input for staff id to proceed further
	 * @param sc
	 */
	public void facilityStaffLogin(Scanner sc) {
		
		try {
			logger.info("Hi staff member! Please provide your id to proceed: ");
			String staffId = sc.nextLine();
			currentStaffMember = StaticInputData.staffMemberList.stream().filter(person -> person.getStaffId().equals(staffId)).collect(Collectors.toList());
			
			if(currentStaffMember.isEmpty())
				throw new UserNotFoundException(staffId);
			
			logger.info("Hello " + currentStaffMember.get(0).getStaffMemberName()+ ".");
			
			facilityStaffLoginOptions(sc);
		}catch(UserNotFoundException e) {
			e.getMessage();
			facilityStaffLogin(sc);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * function provide options for staff  member to proceed to check tickets assigned to him
	 * or to update a ticket  
	 * @param sc
	 */
	private void facilityStaffLoginOptions(Scanner sc) {
		logger.info("Please press 1 to check tickets assigned to you, 2 to mark a ticket fixed and press 0 to go back to previous menu");
		int option = Integer.parseInt(sc.nextLine());
		
		switch(option) {
			case 1: checkAllticketsAssigned();
			break;
			case 2: updateATicket(sc);
			break;
			case 0: Client.facilityManagementWelcomePortal();
			break;
			default: {
						logger.info(FacilityConstants.WRONG_INPUT);
						facilityStaffLoginOptions(sc);
					}
		}
	}

	/**
	 * function gives the ability to update status of an existing ticket
	 * only if the ticket belongs to the respective logged in staff member
	 * @param sc
	 */
	private void updateATicket(Scanner sc) {
		try {
			
			logger.info("Enter the ticket number you want to update the status for:");
			String ticketNumber = sc.nextLine();
			ticketToBeUpdated = StaticInputData.listOfTickets.stream().filter(ticket -> 
				ticket.getTicketId().equals(ticketNumber)
				&& ticket.getTicketAssignedToForWork().equals(currentStaffMember.get(0))
			).collect(Collectors.toList());
			
			if(ticketToBeUpdated.isEmpty())
				throw new TicketNotFoundException(ticketNumber);
			
			logger.info("Ticket to be updated is::");
			ticketToBeUpdated.get(0).getTicketDetails(ticketToBeUpdated.get(0));
			
			ticketStatusUpdateOptions(sc);
			
		}catch(TicketNotFoundException e) {
			e.getMessage();
			updateATicket(sc);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * function provides options to update the ticket status as on hold or fixed
	 * @param sc
	 */
	private void ticketStatusUpdateOptions(Scanner sc) {
		
		try {
			
			logger.info("Press 1 to set the status as Fixed, press 2 to set the status as On hold, press 0 to go back to previous menu");
			int statusOption = Integer.parseInt(sc.nextLine());
			
			switch(statusOption) {
				case 1: updateTicketStatusByStaff(FacilityConstants.FIXED_STATUS);
				break;
				case 2: updateTicketStatusByStaff(FacilityConstants.ON_HOLD_STATUS);
				break;
				case 0: facilityStaffLoginOptions(sc);
					break;
				default: {
						logger.info(FacilityConstants.WRONG_INPUT);
						ticketStatusUpdateOptions(sc);
					}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * function updates the status of the ticket 
	 * @param status is the value of status to be updated
	 */
	private void updateTicketStatusByStaff(String status) {
		FacilityConstants.TICKET_GENERIC_FUNCTIONS.updateTicketStatusAndSendNotifaction(ticketToBeUpdated.get(0), status);
	}

	/**
	 * function is simply getting all the tickets assigned to the current staff member and printing the ticket details
	 */
	private void checkAllticketsAssigned() {
		
		try {
			
			List<Ticket> ticketAssigned = FacilityConstants.TICKET_GENERIC_FUNCTIONS.viewAllTicketsAssignedToAPerson(currentStaffMember.get(0));
			FacilityConstants.TICKET_GENERIC_FUNCTIONS.printTicketDetais(ticketAssigned);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
