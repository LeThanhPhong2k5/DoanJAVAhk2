package ite.computer_management.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.itextpdf.text.DocumentException;

import ite.computer_management.view.Details_ExportCouponView;
import ite.computer_management.view.Details_ImportCouponView;

public class Details_ExportsCouponController implements MouseListener, KeyListener{
	Details_ExportCouponView Details_ExportCouponView;
	
	public Details_ExportsCouponController(Details_ExportCouponView Details_ExportCouponView) {
		this.Details_ExportCouponView = Details_ExportCouponView;
	}
	 
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == Details_ExportCouponView.cancelBtn) {
			Details_ExportCouponView.cancel();
		} else if(e.getSource() == Details_ExportCouponView.exportPdfBtn) {
			try {
				Details_ExportCouponView.export_PDF();
			} catch (DocumentException e1) {
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
