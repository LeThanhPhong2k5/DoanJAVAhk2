package ite.computer_management.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ite.computer_management.view.ImportCouponView;

public class ImportsCouponController implements MouseListener, KeyListener{
	ImportCouponView imporCouponView;
	
	public ImportsCouponController(ImportCouponView ICV) {
		imporCouponView = ICV;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == imporCouponView.btndelete) {
			imporCouponView.clickDeleteLbl();
		}else if(e.getSource() == imporCouponView.btnUpdate) {
			imporCouponView.clickEditBtn();
		}else if(e.getSource() == imporCouponView.btnExcel) {
			imporCouponView.clickExportExcel();
		} else if(e.getSource() == imporCouponView.btnRefresh) {
			imporCouponView.displayTable();
		} else if(e.getSource() == imporCouponView.btnshowdetail) {
			imporCouponView.btndetail();
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
		if(e.getSource() == imporCouponView.searchTxt) {
			imporCouponView.clickSearchBtn();
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
