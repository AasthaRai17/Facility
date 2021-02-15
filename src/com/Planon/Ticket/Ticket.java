package com.Planon.Ticket;

import com.Planon.Employee.Employee;
import com.Planon.Employee.FacilityConsumer;
import com.Planon.Employee.FacilityManager;

public interface Ticket {
	public void setTicketOwner(Employee facilityManager);

	public void setTicketDescription(String string);

	public void setTicketType(String ticketType);

	public void setTicketLogger(Employee facilityConsumer);

	public void setTicketId(String string);
	
	public void setTicketWorker(Employee staffMember);
}
