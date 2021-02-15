package com.Planon.Employee;

import com.Planon.Client.Client;
import com.Planon.Client.FacilityConstants;

public class StaffMemberFactory {
	
	public static StaffMembers getAvailableStaffMemberForAFacility(String facilityType) {
		switch(facilityType) {
			case FacilityConstants.CLEANING:
				return getAvailableMaid();
			case FacilityConstants.CATERING:
				return getAvailableMaid();
			case FacilityConstants.SECURITY:
				return getAvailSecurityGuard();
			case FacilityConstants.STATIONERY:
				return getAvailableOfficeBoy();
			case FacilityConstants.BOOK_A_ROOM:
				return getAvailableOfficeBoy();
			//case FacilityConstants.FOOD_REIMBURSMENT:
				//return new OfficeBoy();
			//case FacilityConstants.TRAVEL_REIMBURSMENT
				//return new OfficeBoy();
		}
		return null;
	}
	
	private static MaidStaff getAvailableMaid() {
		if(!Client.maidStaffMemberList.isEmpty()) {
			return Client.maidStaffMemberList.get(0);
			//remove that maid from the available list
		}
		return null;
	}
	
	private static OfficeBoy getAvailableOfficeBoy() {
		if(!Client.officeBoyMemberList.isEmpty()) {
			return Client.officeBoyMemberList.get(0);
			//remove that office boy from the available list
		}
		return null;
	}
	
	private static SecurityGuards getAvailSecurityGuard() {
		if(!Client.securityGuardMemberList.isEmpty()) {
			return Client.securityGuardMemberList.get(0);
			//remove that security guard from the available list
		}
		return null;
	}
}