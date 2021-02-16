package com.Planon.Employee;

import java.util.logging.Logger;

import com.Planon.Ticket.Ticket;

public class FacilityConsumer implements Associate {
	
	public static  Logger logger = Logger.getLogger(FacilityConsumer.class.getName());
	
	private String eName;
	private String eId;
	private String eEmailId;
	private String eProject;
	
	public FacilityConsumer(String eName, String eId, String eEmailId, String eProject) {
		super();
		this.eName = eName;
		this.eId = eId;
		this.eEmailId = eEmailId;
		this.eProject = eProject;
	}
	
	public FacilityConsumer() {
	}

	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String geteId() {
		return eId;
	}
	public void seteId(String eId) {
		this.eId = eId;
	}
	public String geteEmailId() {
		return eEmailId;
	}
	public void seteEmailId(String eEmailId) {
		this.eEmailId = eEmailId;
	}
	public String geteProject() {
		return eProject;
	}
	public void seteProject(String eProject) {
		this.eProject = eProject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eEmailId == null) ? 0 : eEmailId.hashCode());
		result = prime * result + ((eId == null) ? 0 : eId.hashCode());
		result = prime * result + ((eName == null) ? 0 : eName.hashCode());
		result = prime * result + ((eProject == null) ? 0 : eProject.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FacilityConsumer other = (FacilityConsumer) obj;
		if (eEmailId == null) {
			if (other.eEmailId != null)
				return false;
		} else if (!eEmailId.equals(other.eEmailId))
			return false;
		if (eId == null) {
			if (other.eId != null)
				return false;
		} else if (!eId.equals(other.eId))
			return false;
		if (eName == null) {
			if (other.eName != null)
				return false;
		} else if (!eName.equals(other.eName))
			return false;
		if (eProject == null) {
			if (other.eProject != null)
				return false;
		} else if (!eProject.equals(other.eProject))
			return false;
		return true;
	}

	@Override
	public String getEmployeeDetails() {
		return this.eName + "(" + this.eEmailId + ")";
	}

	@Override
	public void notifyTheTicketOwner(Ticket ticket) {
		logger.info("Hi " + this.eName + ". A ticket has been logged by you.");
		logger.info(ticket.getTicketDetails(ticket));
		
	}
	
}
