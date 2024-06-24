
package ite.computer_management.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ite.computer_management.view.Dashboard;
import ite.computer_management.view.ProductView;
import ite.computer_management.view.SupplierView;

public class SupplierController implements MouseListener, KeyListener{
	SupplierView supplierView;
	Dashboard dashboard;
	public SupplierController(SupplierView SV) {
		supplierView = SV;
	}
	public SupplierController(Dashboard dashboard) {
		this.dashboard = dashboard;
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == supplierView.btnadd) {
			supplierView.clickAddLbl();
		}else if(e.getSource() == supplierView.btndelete) {
			supplierView.clickDeleteLbl();
		}else if(e.getSource() == supplierView.btnUpdate) {
			supplierView.clickEditBtn();
		}else if(e.getSource() == supplierView.btnExcel) {
			supplierView.clickExportExcel();
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		 if(e.getSource() == supplierView.searchTxt) {
			supplierView.clickSearchBtn();
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

