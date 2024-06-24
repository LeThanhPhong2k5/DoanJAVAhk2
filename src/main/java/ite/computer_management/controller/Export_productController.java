package ite.computer_management.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ite.computer_management.view.ExportProductView;
import ite.computer_management.view.ImportsProductView;

public class Export_productController implements MouseListener, KeyListener{
	ExportProductView exportProductView;
	

	public Export_productController(ExportProductView EXP) {
		exportProductView = EXP;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == exportProductView.btn_accept) {
			exportProductView.addProductActionPerformed();
		} else if(e.getSource() == exportProductView.btn_DeleteProduct) {
			exportProductView.delete_toTableExport();
		} else if(e.getSource() == exportProductView.btn_ExportsProduct) {
			exportProductView.btn_ExportProduct();
		} else if(e.getSource() == exportProductView.btn_Refresh) {
			exportProductView.displayTable();
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
		if(e.getSource() == exportProductView.TF_Sreach) {
			exportProductView.clicksearch();
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