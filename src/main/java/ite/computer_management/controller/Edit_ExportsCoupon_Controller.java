package ite.computer_management.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ite.computer_management.view.Edit_ExportCouponView;
import ite.computer_management.view.Edit_ImportsCouponView;
import ite.computer_management.view.ImportCouponView;

public class Edit_ExportsCoupon_Controller implements MouseListener, KeyListener{

	Edit_ExportCouponView edit_exportsCouponView;
	
	public Edit_ExportsCoupon_Controller() {
		
	}
	public Edit_ExportsCoupon_Controller(Edit_ExportCouponView EECV) {
		edit_exportsCouponView = EECV;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == edit_exportsCouponView.btn_back) {
			edit_exportsCouponView.back();
		}else if(e.getSource() == edit_exportsCouponView.btn_accept) {
			edit_exportsCouponView.addProductActionPerformed();
		}else if(e.getSource() == edit_exportsCouponView.btn_save) {
			edit_exportsCouponView.btn_UpdateCoupon();
		}else if(e.getSource() == edit_exportsCouponView.btn_DeleteProduct) {
			edit_exportsCouponView.delete_toTableExport();;
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
		// TODO Auto-generated method stub
		
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
