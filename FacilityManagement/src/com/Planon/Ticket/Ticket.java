package com.Planon.Ticket;

import com.Planon.Employee.Employee;
import com.Planon.Employee.FacilityConsumer;
import com.Planon.Employee.FacilityManager;

public interface Ticket {
	Employee loggedBy = new FacilityConsumer();
	Employee ownedBy = new FacilityManager();
	
	
}
