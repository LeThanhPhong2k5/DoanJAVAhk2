
package ite.computer_management.model;

import java.math.BigInteger;
import java.util.Objects;

public class Details_Form {
	private String form_Code;
	private String computer_Code;
	private int quantity;
	private BigInteger unit_Price;
	
	public Details_Form() {
		
	}

	public Details_Form(String form_Code, String computer_Code, int quantity, BigInteger unit_Price) {
		super();
		this.form_Code = form_Code;
		this.computer_Code = computer_Code;
		this.quantity = quantity;
		this.unit_Price = unit_Price;
	}

	public String getForm_Code() {
		return form_Code;
	}

	public void setForm_Code(String form_Code) {
		this.form_Code = form_Code;
	}

	public String getComputer_Code() {
		return computer_Code;
	}

	public void setComputer_Code(String computer_Code) {
		this.computer_Code = computer_Code;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigInteger getUnit_Price() {
		return unit_Price;
	}

	public void setUnit_Price(BigInteger unit_Price) {
		this.unit_Price = unit_Price;
	}
	
	   @Override
	    public int hashCode() {
	        int hash = 3;
	        return hash;
	    }

	   @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        final Details_Form other = (Details_Form) obj;
	        if (this.quantity != other.quantity) {
	            return false;
	        }
	        if (!Objects.equals(this.unit_Price, other.unit_Price)) {
	            return false;
	        }
	        if (!Objects.equals(this.form_Code, other.form_Code)) {
	            return false;
	        }
	        return Objects.equals(this.computer_Code, other.computer_Code);
	    } 
	@Override
	public String toString() {
		return "Details_Form [form_Code=" + form_Code + ", computer_Code=" + computer_Code + ", quantity=" + quantity
				+ ", unit_Price=" + unit_Price + "]";
	}
	
}

