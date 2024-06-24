package ite.computer_management.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ite.computer_management.view.EditAccountView;

public class EditAccountController implements MouseListener {
	EditAccountView editAccountView;
	public EditAccountController(EditAccountView ev) {
		editAccountView = ev;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == editAccountView.updateBtn) {
			editAccountView.clickUpdateBtn();
		}else if(e.getSource() == editAccountView.cancelBtn) {
			editAccountView.clickCancelBtn();
		}else if(e.getSource() == editAccountView.refreshBtn) {
			editAccountView.clickRefreshBtn();
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
