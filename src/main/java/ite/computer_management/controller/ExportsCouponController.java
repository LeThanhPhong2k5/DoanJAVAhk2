package ite.computer_management.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ite.computer_management.view.ExportCouponView;
import ite.computer_management.view.ImportCouponView;

public class ExportsCouponController implements MouseListener, KeyListener{
	ExportCouponView ExporCouponView;
	
	public ExportsCouponController(ExportCouponView exportCouponView) {
		this.ExporCouponView = exportCouponView;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == ExporCouponView.btndelete) {
			ExporCouponView.clickDeleteLbl();
		}else if(e.getSource() == ExporCouponView.btnUpdate) {
			ExporCouponView.clickEditBtn();
		}else if(e.getSource() == ExporCouponView.btnExcel) {
			ExporCouponView.clickExportExcel();
		} else if(e.getSource() == ExporCouponView.btnRefresh) {
			ExporCouponView.displayTable();
		} else if(e.getSource() == ExporCouponView.btnshowdetail) {
			ExporCouponView.btndetail();
		}
	}

	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getSource() == ExporCouponView.searchTxt) {
			ExporCouponView.clickSearchBtn();
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
