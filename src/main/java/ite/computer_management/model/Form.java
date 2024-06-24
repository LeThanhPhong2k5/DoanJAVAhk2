
package ite.computer_management.model;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Form {
	private String form_Code;
	private Timestamp time_Start;
	private String creator;
	private BigInteger total_Amount;
	private ArrayList<Details_Form> details_Form;
	
	public Form() {
		
	}

	public Form(String form_Code, Timestamp time_Start,ArrayList<Details_Form> Details_Form ,String creator, BigInteger total_Amount) {
		super();
		this.form_Code = form_Code;
		this.time_Start = time_Start;
		this.creator = creator;
		this.details_Form = Details_Form;
		this.total_Amount = total_Amount;
	}
	
	public Form(String form_Code, Timestamp time_Start, String creator, BigInteger total_Amount) {
		super();
		this.form_Code = form_Code;
		this.time_Start = time_Start;
		this.creator = creator;
		this.total_Amount = total_Amount;
	}

	public String getForm_Code() {
		return form_Code;
	}

	public void setForm_Code(String form_Code) {
		this.form_Code = form_Code;
	}

	public Timestamp getTime_Start() {
		return time_Start;
	}

	public void setTime_Start(Timestamp time_Start) {
		this.time_Start = time_Start;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public BigInteger getTotal_Amount() {
		return total_Amount;
	}

	public void setTotal_Amount(BigInteger  total_Amount) {
		this.total_Amount = total_Amount;
	}
	public int hashCode() {
	      int hash = 7;
	      return hash;
	   }


	@Override
	public String toString() {
		return "Form [form_Code=" + form_Code + ", time_Start=" + time_Start + ", creator=" + creator
				+ ", total_Amount=" + total_Amount + "]";
	}
	   
	   

}