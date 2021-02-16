package com.Planon.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.Planon.Employee.Employee;
import com.Planon.Employee.FacilityConsumer;
import com.Planon.Employee.FacilityManager;
import com.Planon.Employee.MaidStaff;
import com.Planon.Employee.OfficeBoy;
import com.Planon.Employee.SecurityGuards;
import com.Planon.Employee.StaffMemberFactory;
import com.Planon.Employee.StaffMembers;
import com.Planon.Ticket.Ticket;
import com.Planon.Ticket.TicketFactory;

public class Client {

	public static  Logger logger = Logger.getLogger(Client.class.getName());
	public static FacilityConstants facilityConstants = new FacilityConstants();
	
	public static void main(String[] args) {
		
		try {
			StaticInputData staticInputData = new StaticInputData();//loading the static input data
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
				default: logger.info("You are not allowed!");
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
		FacilityConsumerFunctions facilityConsumerFn = new FacilityConsumerFunctions();
		facilityConsumerFn.facilityConsumerLogin();
	}

	
	private static void facilityManagerProcess() {
		
	}
}
