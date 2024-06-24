package ite.computer_management.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ite.computer_management.view.EditProductView;

public class EditProductController implements MouseListener {
	EditProductView editProductView;
	public EditProductController(EditProductView editProductView) {
		this.editProductView = editProductView;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == editProductView.btnNewButton) {
			editProductView.clickUpdateBtn();
		}else if(e.getSource() == editProductView.btnCancel) {
			editProductView.clickCancelBtn();
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
