package ite.computer_management.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ite.computer_management.view.AccountView;

public class AccountController implements MouseListener, KeyListener {
	AccountView accountView;
	public AccountController(AccountView av) {
		accountView = av;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()  == accountView.btnadd ) {
			accountView.clickAddLbl();
		}else if(e.getSource() == accountView.btndelete){
			accountView.clickDeleteLbl();
		}else if(e.getSource() == accountView.btnUpdate) {
			accountView.clickEditLbl();
		}else if(e.getSource() == accountView.btnExcel) {
			accountView.clickExportExcel();
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
		if(e.getSource() == accountView.searchAreaTxt) {
			accountView.enterSearch();
		}
		
	}

}
