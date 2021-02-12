package com.Planon.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.Planon.Employee.Employee;
import com.Planon.Employee.FacilityConsumer;
import com.Planon.Employee.FacilityManager;
import com.Planon.Ticket.Ticket;
import com.Planon.Ticket.TicketFactory;

public class Client {

	public static  Logger logger = Logger.getLogger(Client.class.getName());
	public static Employee facilityManager = new FacilityManager();
	public static Employee facilityConsumer = new FacilityConsumer();
	public static List<Employee> staffMemberList = new ArrayList<>();
	public static List<Ticket> listOfTickets = new ArrayList<>();
	public static FacilityConstants facilityConstants = new FacilityConstants();
	
	public static void main(String[] args) {
		
		try {
			Scanner sc = new Scanner(System.in);
			logger.info("Welcome to Facility Management Portal. Press 1 if you are a Facility Manager, press 2 if a Facility Consumer and press 3 if a Staff Member.");
			int loginType = sc.nextInt();
			
			switch(loginType) {
				case 1: facilityManagerProcess();
				break;
				case 2: facilityConsumerProcess();
				break;
				case 3: staffMemberProcess();
				break;
				default: logger.info("No No No, you are not allowed!");
			}
		}catch(Exception e) {
			logger.info("Exception in main: " + e);
			e.printStackTrace();
		}
	}

	private static void staffMemberProcess() {
		// TODO Auto-generated method stub
		
	}

	private static void facilityConsumerProcess() {
		//raise a ticket
		//create facikity consumer
		createFacilityConsumer();
		raiseATicket();
		
	}

	private static void createFacilityConsumer() {
		facilityConsumer = new FacilityConsumer("Monica Geller", "1034645", "monica.geller@planonsoftware.com", "Framework Development");
	}

	private static void raiseATicket() {
		try {
			Scanner sc = new Scanner(System.in);
			
			logger.info("Press 1 for a Request, 2 to report and Incident and 3 for Complain: ");
			int typeOfTicket = sc.nextInt();
			
			if(!FacilityConstants.TICKET_TYPES.containsKey(typeOfTicket))
				logger.info("No No No, you are not allowed!");
			else {
				logger.info("Please press 1 for Cleaning, 2 for Catering, 3 for Stationery, 4 for Food reimbursment, 5 for Room booking, 6 for Travel reimbursment");
				int input = sc.nextInt();
				
				if(!FacilityConstants.FACILITY_TYPES.containsKey(input))
					logger.info("No No No, you are not allowed!");
				else {
					String ticketType = FacilityConstants.FACILITY_TYPES.get(input);
					
					Ticket ticket = TicketFactory.getTicketType(FacilityConstants.TICKET_TYPES.get(typeOfTicket));
				}
				
			}
			
			sc.close();
		}catch(Exception e) {
			logger.info("Exception in raiseATicket: " + e);
			e.printStackTrace();
		}
	}

	
	private static void facilityManagerProcess() {
		//create static data for tickets
		//create static data for staff
		
	}
}
