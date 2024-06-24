package ite.computer_management.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ite.computer_management.view.AddAccountView;

public class AddAccountController implements MouseListener {
	AddAccountView addAccountView;
	public AddAccountController(AddAccountView av) {
		addAccountView = av;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == addAccountView.addBtn) {
			addAccountView.clickAddBtn();
		}else if(e.getSource() == addAccountView.cancelBtn) {
			addAccountView.clickCancelBtn();
		}else if(e.getSource() == addAccountView.refreshBtn) {
			addAccountView.clickRefreshBtn();
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
