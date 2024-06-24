package ite.computer_management.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Computer{
	private String computerCode;
	private String computerName;
	private int quantity;
	private String cpuName;
	private String ram;
	private String screenCard;
	private BigInteger price;
	private String sourceCapacity;
	private String machineType;
	private String rom;
	private double screenSize;
	private String batteryCapacity;
	private String origin;
	public String getComputerCode() {
		return computerCode;
	}
	public void setComputerCode(String computerCode) {
		this.computerCode = computerCode;
	}
	public String getComputerName() {
		return computerName;
	}
	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCpuName() {
		return cpuName;
	}
	public void setCpuName(String cpuName) {
		this.cpuName = cpuName;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getScreenCard() {
		return screenCard;
	}
	public void setScreenCard(String screenCard) {
		this.screenCard = screenCard;
	}
	public BigInteger getPrice() {
		return price;
	}
	public void setPrice(BigInteger price) {
		this.price = price;
	}
	public String getSourceCapacity() {
		return sourceCapacity;
	}
	public void setSourceCapacity(String sourceCapacity) {
		this.sourceCapacity = sourceCapacity;
	}
	public String getMachineType() {
		return machineType;
	}
	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}
	public String getRom() {
		return rom;
	}
	public void setRom(String rom) {
		this.rom = rom;
	}
	public double getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}
	public String getBatteryCapacity() {
		return batteryCapacity;
	}
	public void setBatteryCapacity(String batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Computer(String computerCode, String computerName, int quantity, String cpuName, String ram, String screenCard,
			BigInteger price, String sourceCapacity, String machineType, String rom, double screenSize,
			String batteryCapacity, String origin) {
		super();
		this.computerCode = computerCode;
		this.computerName = computerName;
		this.quantity = quantity;
		this.cpuName = cpuName;
		this.ram = ram;
		this.screenCard = screenCard;
		this.price = price;
		this.sourceCapacity = sourceCapacity;
		this.machineType = machineType;
		this.rom = rom;
		this.screenSize = screenSize;
		this.batteryCapacity = batteryCapacity;
		this.origin = origin;
	}
	public Computer() {}
	public Computer(String computer_Code, String computer_Name, int quantity, BigInteger price, String cpu_Name,
			String ram, String origin, String screen_Card, String rom) {
		super();
		this.computerCode = computer_Code;
		this.computerName = computer_Name;
		this.quantity = quantity;
		this.cpuName = cpu_Name;
		this.ram = ram;
		this.screenCard = screen_Card;
		this.price = price;
		this.rom = rom;
		this.origin = origin;
	}

	@Override
	public String toString() {
		return "Computer [computerCode=" + computerCode + ", computerName=" + computerName + ", quantity=" + quantity
				+ ", cpuName=" + cpuName + ", ram=" + ram + ", screenCard=" + screenCard + ", price=" + price
				+ ", sourceCapacity=" + sourceCapacity + ", machineType=" + machineType + ", rom=" + rom
				+ ", screenSize=" + screenSize + ", batteryCapacity=" + batteryCapacity + ", origin=" + origin + "]";
	};
	
	
	
	
}



