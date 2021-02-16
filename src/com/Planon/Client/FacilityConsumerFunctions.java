package com.Planon.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.Planon.Employee.FacilityConsumer;
import com.Planon.Ticket.Ticket;
import com.Planon.Ticket.TicketFactory;

public class FacilityConsumerFunctions {

	public static  Logger logger = Logger.getLogger(FacilityConsumerFunctions.class.getName());
	public List<FacilityConsumer> currentConsumer  = new ArrayList<>();
	
	public void facilityConsumerLogin() {
		//check id of consumer
		//if exist allow
		//else exit
		Scanner sc = new Scanner(System.in);
		logger.info("Enter your employee id: ");
		String empId = sc.nextLine();
		currentConsumer = StaticInputData.facilityConsumerList.stream().filter(person -> person.geteId().equals(empId)).collect(Collectors.toList());
		logger.info("Hello " + currentConsumer.get(0).geteName()+ ".");
		
		raiseANewTicketOption(sc);
		
		sc.close();
		
	}

	private void raiseANewTicketOption(Scanner sc) {
		logger.info("Press 1 to log a new ticket, press 2 to view your tickets and press 3 to go back to previous menu.");
		int option = Integer.parseInt(sc.nextLine());
		
		switch(option) {
			case 1: raiseANewTicketTypeOption(sc);
			break;
			case 2: viewAllTickets();
			break;
			case 3: goBackToMenu1();
			break;
			default: logger.info("wrong input!");
		}
	}

	private void goBackToMenu1() {
		
	}

	private void viewAllTickets() {
		// filter all tickets with the currentconsumer tagged as loggedby
		List<Ticket> currentConsumerTickets = StaticInputData.listOfTickets
				.stream()
				.filter(oneTicket -> oneTicket.getTicketLoggedBy().equals(currentConsumer.get(0)))
				.collect(Collectors.toList());
		
		//print all tickets
		currentConsumerTickets.forEach(ticket -> {
			logger.info("Ticket number " 
					+ ticket.getTicketId() 
					+ " ("
					+ ticket.getTicketDescription()
					+ ") has status " 
					+ ticket.getTicketStatus()
					+ ". Ticket attendee is "
					+ ticket.getTicketAssignedToForWork().getEmployeeDetails());
		});
		
	}

	private void raiseANewTicketTypeOption(Scanner sc) {
		try {
			
			logger.info("Press 1 for a Request, 2 to report an Incident, 3 to file a Complain and 4 to go back to previous menu.");
			int typeOfTicket = Integer.parseInt(sc.nextLine());
			
			if(typeOfTicket==4){
				raiseANewTicketOption(sc);
			}else if(!FacilityConstants.TICKET_TYPES.containsKey(typeOfTicket))
				logger.info("wrong input!");
			else{
				raiseANewTicketFacilityTypeOption(sc, typeOfTicket);
			}
			
		}catch(Exception e) {
			logger.info("Exception in raiseATicket: " + e);
			e.printStackTrace();
		}
		
	}

	private void raiseANewTicketFacilityTypeOption(Scanner sc, int typeOfTicket) {
		logger.info("Please press 1 for Cleaning, 2 for Catering, 3 for Stationery, 4 for Food reimbursment, 5 for Room booking, 6 for Travel reimbursment");
		int facilityTypeInput = Integer.parseInt(sc.nextLine());
		
		if(!FacilityConstants.FACILITY_TYPES.containsKey(facilityTypeInput))
			logger.info("wrong input!");
		else {
			Ticket ticket = createANewTicket(sc, facilityTypeInput, typeOfTicket);
		}
	}

	private Ticket createANewTicket(Scanner sc, int ticketFacilityTypeInput, int typeOfTicket) {
		logger.info("Please provide ticket description: ");
		String ticketDescription = sc.nextLine();
		String ticketFacilityType = FacilityConstants.FACILITY_TYPES.get(ticketFacilityTypeInput);
		
		Ticket ticket = TicketFactory.getTicketType(FacilityConstants.TICKET_TYPES.get(typeOfTicket));
		
		ticket.setTicketId();
		ticket.setTicketDescription(ticketDescription);
		ticket.setTicketType();
		ticket.setTicketTypeBasedOnFacility(ticketFacilityType);
		ticket.setTicketLoggedBy(currentConsumer.get(0));
		ticket.setTicketOwner(StaticInputData.facilityManager);
		return ticket;
	}

}
