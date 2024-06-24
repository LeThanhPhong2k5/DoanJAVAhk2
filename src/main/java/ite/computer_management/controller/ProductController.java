package ite.computer_management.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ite.computer_management.view.AddProductView;
import ite.computer_management.view.Dashboard;
import ite.computer_management.view.EditProductView;
import ite.computer_management.view.ProductView;


public class ProductController implements MouseListener , KeyListener{
	ProductView productView;
	Dashboard dashboard;
	public ProductController(ProductView pv) {
		productView = pv;
	}
	public ProductController(Dashboard dashboard) {
		this.dashboard = dashboard;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == productView.btnadd) {
			productView.clickAddLbl();
		}else if(e.getSource() == productView.btndelete) {
		    productView.clickDeleteLbl();
		}else if(e.getSource() == productView.btnUpdate) {
			productView.clickEditBtn();
		}else if(e.getSource() == productView.btnExcel) {
			productView.clickExportExcel();
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

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getSource() == productView.searchTxt) {
			productView.clickSearchBtn();
		}
	}
}
