package com.Planon.Employee;

public class FacilityConsumer implements Associate {
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
	
	
}
