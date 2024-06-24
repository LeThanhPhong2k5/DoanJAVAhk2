package ite.computer_management.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ite.computer_management.view.DashboardForManager;

public class DashboardForManagerController implements MouseListener {
	DashboardForManager dashboardForManager;
	public DashboardForManagerController(DashboardForManager dashboardForManager) {
		this.dashboardForManager = dashboardForManager;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == dashboardForManager.productNavLbl) {
			dashboardForManager.clickProductNav();
		}else if(e.getSource() == dashboardForManager.supplierNavLbl) {
			dashboardForManager.clickSupplierNav();
		}else if(e.getSource() == dashboardForManager.importCouponNavLbl) {
			dashboardForManager.clickImportCouponNav();
		}else if(e.getSource() == dashboardForManager.importProductNavLbl) {
			dashboardForManager.clickImportProductNav();
		}else if(e.getSource() == dashboardForManager.exportProductNavLbl) {
			dashboardForManager.clickExportProductNav();
		}else if(e.getSource() == dashboardForManager.exportCouponNavLbl) {
			dashboardForManager.clickExportCouponNav();
		}else if(e.getSource() == dashboardForManager.statisticalNavLbl) {
			dashboardForManager.clickStatisticalNav();
		}else if(e.getSource() == dashboardForManager.ChatNavLbl_1) {
			dashboardForManager.clickChatNav();
		}else if(e.getSource() == dashboardForManager.myInformationLbl) {
			dashboardForManager.clickMyInformationNav();
		}else if(e.getSource() == dashboardForManager.logOutNavLbl) {
			dashboardForManager.clickLogoutNav();

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
