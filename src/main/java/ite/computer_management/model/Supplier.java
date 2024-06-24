
package ite.computer_management.model;

public class Supplier {
	private String Supplier_Code;
	private String Supplier_Name;
	private String Phone_Number;
	private String Address;
	
	public Supplier() {
		
	}

	public Supplier(String supplier_Code, String supplier_Name, String phone_Number, String address) {
		super();
		Supplier_Code = supplier_Code;
		Supplier_Name = supplier_Name;
		Phone_Number = phone_Number;
		Address = address;
	}

	public Supplier(String supplier_Name, String phone_Number, String address) {
		this.Supplier_Name = supplier_Name;
		this.Phone_Number = phone_Number;
		this.Address = address;
	}

	public String getSupplier_Code() {
		return Supplier_Code;
	}

	public void setSupplier_Code(String supplier_Code) {
		Supplier_Code = supplier_Code;
	}

	public String getSupplier_Name() {
		return Supplier_Name;
	}

	public void setSupplier_Name(String supplier_Name) {
		Supplier_Name = supplier_Name;
	}

	public String getPhone_Number() {
		return Phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		Phone_Number = phone_Number;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		return "Supplier [Supplier_Code=" + Supplier_Code + ", Supplier_Name=" + Supplier_Name + ", Phone_Number="
				+ Phone_Number + ", Address=" + Address + "]";
	}
	
	
	
}

