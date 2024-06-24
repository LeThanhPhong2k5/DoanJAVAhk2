
package ite.computer_management.model;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ExportForm extends Form{
	private String supplier;
	 public ExportForm(String form_Code, Timestamp time_start, String creator, ArrayList<Details_Form> Details_Form, BigInteger total_Amount) {
	      super(form_Code, time_start, Details_Form, creator, total_Amount);
	      this.supplier = supplier;
	   }
	public ExportForm(String formCode, Timestamp sqlTimestamp, int selectedIndex, ArrayList<Details_Form> details_Form,
			BigInteger  total_Amount) {
		// TODO Auto-generated constructor stub
	}
}

