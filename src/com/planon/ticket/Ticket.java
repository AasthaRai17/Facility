package com.planon.ticket;

import com.planon.client.StaticInputData;
import com.planon.employee.Employee;

public abstract class Ticket {

	Employee ticketOwner;
	String ticketDescription;
	String ticketTypeBasedOnFacility;
	Employee ticketLoggedBy;
	String ticketId;
	Employee ticketAssignedToForWork;
	String typeOfTicket;
	String ticketStatus;


	public void setTicketOwnerAndNotify(Employee ticketOwner) {
		this.ticketOwner = ticketOwner;
		//notify the owner that ticket has been tagged to you
		ticketOwner.ticketNotification(this);
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

	public void setTicketAssignedToForWorkAndNotify(Employee ticketAssignedToForWork) {
		this.ticketAssignedToForWork = ticketAssignedToForWork;
		ticketAssignedToForWork.ticketNotification(this);
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public String getTicketDetails(Ticket ticket) {
		return "Ticket number: " + ticket.ticketId + "(" + ticket.ticketDescription + ").";
	}
	
	public abstract void setTicketType();

}
