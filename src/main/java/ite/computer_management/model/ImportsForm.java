
package ite.computer_management.model;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;



public class ImportsForm extends Form{
	private String supplier;
	
	public ImportsForm() {
		
	}

	public ImportsForm(String supplier) {
		super();
		this.supplier = supplier;
	}

	 public ImportsForm(String supplier, String form_Code, Timestamp time_start, String creator, ArrayList<Details_Form> Details_Form, BigInteger  total_Amount) {
	      super(form_Code, time_start, Details_Form, creator, total_Amount);
	      this.supplier = supplier;
	   }

	public ImportsForm(String supplier_Code, String form_Code, Timestamp sqlTimestamp, int selectedIndex,
			ArrayList<Details_Form> details_Form, BigInteger total_Amount) {
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	
}

