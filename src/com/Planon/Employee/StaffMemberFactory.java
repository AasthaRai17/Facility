package com.Planon.Employee;

import com.Planon.Client.FacilityConstants;

public class StaffMemberFactory {
	
	public StaffMembers getStaffMemberForAFacility(String facilityType) {
		switch(facilityType) {
			case FacilityConstants.CLEANING:
				return new MaidStaff();
			case FacilityConstants.CATERING:
				return new MaidStaff();
			case FacilityConstants.SECURITY:
				return new SecurityGuards();
			//case FacilityConstants.FOOD_REIMBURSMENT:
				//return new OfficeBoy();
			//case FacilityConstants.TRAVEL_REIMBURSMENT
				//return new OfficeBoy();
			case FacilityConstants.STATIONERY:
				return new OfficeBoy();
			case FacilityConstants.BOOK_A_ROOM:
				return new OfficeBoy();
			
		}
		return null;
	}
}
