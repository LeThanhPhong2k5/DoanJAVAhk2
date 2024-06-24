package ite.computer_management.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ite.computer_management.view.DashboardForExportStaff;

public class DashboardForExportStaffController implements MouseListener {
	DashboardForExportStaff dashboardForExportStaff;
	public DashboardForExportStaffController(DashboardForExportStaff dashboardForExportStaff) {
		this.dashboardForExportStaff =	dashboardForExportStaff;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == dashboardForExportStaff.exportCouponNavLbl) {
			dashboardForExportStaff.clickExportCouponNav();
		}else if(e.getSource() == dashboardForExportStaff.exportProductNavLbl) {
			dashboardForExportStaff.clickExportProductNav();
		}else if(e.getSource() == dashboardForExportStaff.ChatNavLbl_1) {
			dashboardForExportStaff.clickChatNav();

		}else if(e.getSource() == dashboardForExportStaff.myInformationLbl) {
			dashboardForExportStaff.clickMyInformationNav();

		}else if(e.getSource() == dashboardForExportStaff.logOutNavLbl) {
			dashboardForExportStaff.clickLogoutNav();

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
