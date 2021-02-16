package com.Planon.Ticket;

import com.Planon.Client.StaticInputData;
import com.Planon.Employee.Employee;
import com.Planon.Employee.FacilityConsumer;
import com.Planon.Employee.FacilityManager;
import com.Planon.Employee.StaffMembers;
import com.Planon.Facilities.Facility;

public abstract class Ticket {

	Employee ticketOwner;
	String ticketDescription;
	String ticketTypeBasedOnFacility;
	Employee ticketLoggedBy;
	String ticketId;
	Employee ticketAssignedToForWork;
	String typeOfTicket;
	String ticketStatus;

	public Employee getTicketOwner() {
		return ticketOwner;
	}

	public void setTicketOwner(Employee ticketOwner) {
		this.ticketOwner = ticketOwner;
		//notify the owner that ticket has been tagged to you
		ticketOwner.notifyTheTicketOwner(this);
	}

	public String getTicketDescription() {
		return ticketDescription;
	}

	public void setTicketDescription(String ticketDescription) {
		this.ticketDescription = ticketDescription;
	}

	public String getTicketTypeBasedOnFacility() {
		return ticketTypeBasedOnFacility;
	}

	public void setTicketTypeBasedOnFacility(String ticketTypeBasedOnFacility) {
		this.ticketTypeBasedOnFacility = ticketTypeBasedOnFacility;
	}

	public Employee getTicketLoggedBy() {
		return ticketLoggedBy;
	}

	public void setTicketLoggedBy(Employee ticketLoggedBy) {
		this.ticketLoggedBy = ticketLoggedBy;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId() {
		this.ticketId = String.valueOf(StaticInputData.listOfTickets.size()+1);
	}

	public Employee getTicketAssignedToForWork() {
		return ticketAssignedToForWork;
	}

	public void setTicketAssignedToForWork(Employee ticketAssignedToForWork) {
		this.ticketAssignedToForWork = ticketAssignedToForWork;
		ticketAssignedToForWork.notifyTheTicketOwner(this);
	}

	public String getTypeOfTicket() {
		return typeOfTicket;
	}

	public void setTypeOfTicket(String typeOfTicket) {
		this.typeOfTicket = typeOfTicket;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public abstract void setTicketType();
	
	public String getTicketDetails(Ticket ticket) {
		return "Ticket number: " + ticket.ticketId + "(" + ticket.ticketDescription + ").";
	}
}
