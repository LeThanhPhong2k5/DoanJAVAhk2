package ite.computer_management.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.itextpdf.text.DocumentException;

import ite.computer_management.view.Details_ImportCouponView;

public class Details_ImportsCouponController implements MouseListener, KeyListener{
	Details_ImportCouponView details_ImportCouponView;
	
	public Details_ImportsCouponController(Details_ImportCouponView DTCV) {
		details_ImportCouponView = DTCV;
	}
	 
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == details_ImportCouponView.cancelBtn) {
			details_ImportCouponView.cancel();
		} else if(e.getSource() == details_ImportCouponView.exportPdfBtn) {
			try {
				details_ImportCouponView.export_PDF();
			} catch (DocumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
