package com.planon.facilities;


//package structuring for constant and static data can be done in 1?
//
public interface WorkstationManagement{
	/**
	 * in real time scenario such functions are not required
	 * there can be a single function to do work regarding any kind of workstation issue
	 * as there can be n number of workstation related functions
	 */
	public void fixTheWorkstationDrawerIssue();
	public void assetMovement();
}
