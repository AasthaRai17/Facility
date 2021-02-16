package com.Planon.Employee;

import com.Planon.Ticket.Ticket;

public interface Employee {

	String getEmployeeDetails();

	void notifyTheTicketOwner(Ticket ticket);
}
