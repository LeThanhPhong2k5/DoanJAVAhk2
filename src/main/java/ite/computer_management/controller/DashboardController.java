package ite.computer_management.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ite.computer_management.view.Dashboard;
import ite.computer_management.view.DashboardForImportStaff;

public class DashboardController implements MouseListener {
	Dashboard dashboard;
	public DashboardController(Dashboard db) {
		dashboard = db;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == dashboard.productNavLbl) {
			dashboard.clickProductNav();
		}else if(e.getSource() == dashboard.accountNavLbl) {
			dashboard.clickAccountNav();
		}else if(e.getSource() == dashboard.supplierNavLbl) {
			dashboard.clickSupplierNav();
		}else if(e.getSource() == dashboard.importProductNavLbl) {
			dashboard.clickImportProductNav();
		}else if(e.getSource() == dashboard.importCouponNavLbl) {
			dashboard.clickImportCouponNav();
		}else if(e.getSource() == dashboard.exportCouponNavLbl) {
			dashboard.clickExportCouponNav();
		}else if(e.getSource() == dashboard.exportProductNavLbl) {
			dashboard.clickExportProductNav();
		} else if(e.getSource() == dashboard.statisticalchart) {
			dashboard.clickStatisticalNav();
		}else if(e.getSource() == dashboard.myInformationLbl) {
			dashboard.clickMyInformation();
		}else if(e.getSource() == dashboard.logOutNavLbl) {
			dashboard.clickLogoutNav();
		}else if(e.getSource() == dashboard.Chatlb1) {
			dashboard.clickChatlb1();
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
