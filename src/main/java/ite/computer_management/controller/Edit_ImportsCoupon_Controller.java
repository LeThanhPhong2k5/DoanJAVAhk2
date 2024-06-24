package ite.computer_management.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ite.computer_management.view.Edit_ImportsCouponView;
import ite.computer_management.view.ImportCouponView;

public class Edit_ImportsCoupon_Controller implements MouseListener, KeyListener{

	Edit_ImportsCouponView edit_ImportsCouponView;
	
	public Edit_ImportsCoupon_Controller() {
		
	}
	public Edit_ImportsCoupon_Controller(Edit_ImportsCouponView EICV) {
		edit_ImportsCouponView = EICV;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == edit_ImportsCouponView.btn_back) {
			edit_ImportsCouponView.back();
		}else if(e.getSource() == edit_ImportsCouponView.btn_accept) {
			edit_ImportsCouponView.addProductActionPerformed();
		}else if(e.getSource() == edit_ImportsCouponView.btn_save) {
			edit_ImportsCouponView.btn_UpdateCoupon();
		}else if(e.getSource() == edit_ImportsCouponView.btn_DeleteProduct) {
			edit_ImportsCouponView.delete_toTableImport();
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
