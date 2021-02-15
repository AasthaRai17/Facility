package com.Planon.Client;

import java.util.ArrayList;
import java.util.List;

import com.Planon.Employee.Employee;
import com.Planon.Employee.FacilityConsumer;
import com.Planon.Employee.FacilityManager;
import com.Planon.Employee.MaidStaff;
import com.Planon.Employee.OfficeBoy;
import com.Planon.Employee.SecurityGuards;
import com.Planon.Ticket.Ticket;
import com.Planon.Ticket.TicketForComplain;
import com.Planon.Ticket.TicketForIncident;
import com.Planon.Ticket.TicketForRequest;

public class StaticInputData {

	public static Employee facilityManager = new FacilityManager();
	public static List<Employee> facilityConsumerList = new ArrayList<>();
	public static List<MaidStaff> maidStaffMemberList = new ArrayList<>();
	public static List<OfficeBoy> officeBoyMemberList = new ArrayList<>();
	public static List<SecurityGuards> securityGuardMemberList = new ArrayList<>();
	public static List<Ticket> listOfTickets = new ArrayList<>();
	
	
	public StaticInputData() {
		createStaffMemberList();
		createFacilityConsumerList();
		createFacilityManager();
		createTicketData();
	}
	
	private static void createStaffMemberList() {
		officeBoyMemberList.add(new OfficeBoy("Gopal", "H.N. 123/90, gopalpur, Hyderabad", "OB001"));
		maidStaffMemberList.add(new MaidStaff("Madhav", "H.N. 45, Madhav nagar, Hyderabad", "M001"));
		securityGuardMemberList.add(new SecurityGuards("Laxman", "H.N. 89, laxman nagar, Hyderabad", "SG001"));
		officeBoyMemberList.add(new OfficeBoy("Lucky", "H.N. 12/90, gopalpur, Hyderabad", "OB001"));
		maidStaffMemberList.add(new MaidStaff("Raju", "H.N. 67, Madhav nagar, Hyderabad", "M001"));
		securityGuardMemberList.add(new SecurityGuards("Shyaam", "H.N. 78, laxman nagar, Hyderabad", "SG001"));
		
	}

	private static void createFacilityConsumerList() {
		facilityConsumerList.add(new FacilityConsumer("Monica Geller", "1034645", "monica.geller@planonsoftware.com", "Framework Development"));
		facilityConsumerList.add(new FacilityConsumer("Joey Tribbiani", "1034646", "joey.tribbiani@planonsoftware.com", "Framework Development"));
		facilityConsumerList.add(new FacilityConsumer("Ross Geller", "1034647", "ross.geller@planonsoftware.com", "Framework Development"));
		facilityConsumerList.add(new FacilityConsumer("Pheobe Buffay", "1034648", "pheobe.buffay@planonsoftware.com", "Framework Development"));
		facilityConsumerList.add(new FacilityConsumer("Rachel Green", "1034649", "rachel.green@planonsoftware.com", "Framework Development"));
	}
	
	private static void createFacilityManager() {
		facilityManager = new FacilityManager("Chandler Bing", "1034644");
	}
	
	private static void createTicketData() {
		listOfTickets.add(new TicketForComplain(facilityManager, "Clean the washroom number 2 on 1st floor." , FacilityConstants.CLEANING, facilityConsumerList.get(0), maidStaffMemberList.get(0)));
		listOfTickets.add(new TicketForComplain(facilityManager, "Not enough plates in cafeteria." , FacilityConstants.CATERING, facilityConsumerList.get(1), maidStaffMemberList.get(1)));
		listOfTickets.add(new TicketForRequest(facilityManager, "Please book a meeting room 4." , FacilityConstants.BOOK_A_ROOM, facilityConsumerList.get(0), officeBoyMemberList.get(0)));
		listOfTickets.add(new TicketForRequest(facilityManager, "Please book a meeting room 5." , FacilityConstants.BOOK_A_ROOM, facilityConsumerList.get(1), officeBoyMemberList.get(1)));
		listOfTickets.add(new TicketForIncident(facilityManager, "xyz entered without biometric." , FacilityConstants.SECURITY, facilityConsumerList.get(0), securityGuardMemberList.get(0)));
		listOfTickets.add(new TicketForIncident(facilityManager, "abc took a picture of business data." , FacilityConstants.SECURITY, facilityConsumerList.get(1), securityGuardMemberList.get(1)));
	}
}
