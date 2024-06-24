package ite.computer_management.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ite.computer_management.view.LogInView;

public class LogInController implements MouseListener {
	LogInView logInView;
	public LogInController(LogInView logInView) {
		this.logInView = logInView;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == logInView.logInBtn) {
			logInView.clickLogInBtn();
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
