
package ite.computer_management.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ite.computer_management.view.EditSupplierView;

public class EditSupplierController implements MouseListener {
	EditSupplierView editSupplierView;
	public EditSupplierController(EditSupplierView ESV) {
		this.editSupplierView = ESV;
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == editSupplierView.btnSave) {
			editSupplierView.clickUpdateBtn();
		}else if(e.getSource() == editSupplierView.btnCancel) {
			editSupplierView.clickCancelBtn();
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

