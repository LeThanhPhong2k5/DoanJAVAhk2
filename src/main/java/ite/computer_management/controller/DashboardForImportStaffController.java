package ite.computer_management.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ite.computer_management.view.DashboardForImportStaff;

public class DashboardForImportStaffController implements MouseListener {
	public DashboardForImportStaff dashboardForImportStaff;
	public DashboardForImportStaffController(DashboardForImportStaff dashboardForImportStaff) {
		this.dashboardForImportStaff = dashboardForImportStaff;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == dashboardForImportStaff.importCouponNavLbl){
			dashboardForImportStaff.clickImportCouponNav();
		}else if(e.getSource() == dashboardForImportStaff.importProductNavLbl) {
			dashboardForImportStaff.clickImportProductNav();

		}else if(e.getSource() == dashboardForImportStaff.myInformationLbl) {
			dashboardForImportStaff.clickMyInformationNav();

		}else if(e.getSource() == dashboardForImportStaff.chatNavLbl_1) {
			dashboardForImportStaff.clickChatNav();
		}else if(e.getSource() == dashboardForImportStaff.logOutNavLbl) {
			dashboardForImportStaff.clickLogoutNav();

		}
	}  

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
