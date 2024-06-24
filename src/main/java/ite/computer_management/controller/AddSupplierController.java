
package ite.computer_management.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ite.computer_management.view.AddProductView;
import ite.computer_management.view.AddSupplierView;


public class AddSupplierController implements MouseListener {
	AddSupplierView addSupplierView;
	
	public AddSupplierController(AddSupplierView ASV) {
		addSupplierView = ASV;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == addSupplierView.addBtn) {
			addSupplierView.clickAddLbl();
		}else if(e.getSource() == addSupplierView.cancelBtn) {
			addSupplierView.clickCancelLbl();
		}else if(e.getSource() == addSupplierView.refreshBtn) {
			addSupplierView.clickRefreshLbl();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {		
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}

