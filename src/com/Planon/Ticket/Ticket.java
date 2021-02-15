package com.Planon.Ticket;

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

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public Employee getTicketAssignedToForWork() {
		return ticketAssignedToForWork;
	}

	public void setTicketAssignedToForWork(Employee ticketAssignedToForWork) {
		this.ticketAssignedToForWork = ticketAssignedToForWork;
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

	abstract void setTicketType();
}
