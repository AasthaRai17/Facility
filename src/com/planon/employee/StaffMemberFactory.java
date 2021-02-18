package com.planon.employee;

import com.planon.client.FacilityConstants;
import com.planon.client.StaticInputData;

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
			case FacilityConstants.FOOD_REIMBURSMENT:
				return getAvailCafeteriaManager();
			default:return null;
		}
	}
	
	private static MaidStaff getAvailableMaid() {
		if(!StaticInputData.maidStaffMemberList.isEmpty()) {
			return StaticInputData.maidStaffMemberList.get(0);
		}
		return null;
	}
	
	private static OfficeBoy getAvailableOfficeBoy() {
		if(!StaticInputData.officeBoyMemberList.isEmpty()) {
			return StaticInputData.officeBoyMemberList.get(0);
		}
		return null;
	}
	
	private static SecurityGuards getAvailSecurityGuard() {
		if(!StaticInputData.securityGuardMemberList.isEmpty()) {
			return StaticInputData.securityGuardMemberList.get(0);
		}
		return null;
	}
	
	private static CafeteriaManager getAvailCafeteriaManager() {
		if(!StaticInputData.cafeteriaManagerList.isEmpty()) {
			return StaticInputData.cafeteriaManagerList.get(0);
		}
		return null;
	}
	
	private StaffMemberFactory() {
	}
}
