package hwinventory.ui.inventoryItem;

import hwinventory.domain.HardwareDevice;
import hwinventory.domain.LocationItemInventory;
import hwinventory.domain.User;

import java.util.Date;

public class InventoryItemDraft {

	private HardwareDevice hardwareDevice;
	private int scgNumber;
	private String nameItem;
	private User user;
	private LocationItemInventory location;
	private Date inventoryDate;
	private float price;
	private String budget;
	private String guarantee;
	private Date guaranteeDate;
	private String note;

	public HardwareDevice getHardwareDevice() {
		return hardwareDevice;
	}

	public void setHardwareDevice(HardwareDevice hardwareDevice) {
		this.hardwareDevice = hardwareDevice;
	}

	public int getScgNumber() {
		return scgNumber;
	}

	public void setScgNumber(int scgNumber) {
		this.scgNumber = scgNumber;
	}

	public String getNameItem() {
		return nameItem;
	}

	public void setNameItem(String nameItem) {
		this.nameItem = nameItem;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocationItemInventory getLocation() {
		return location;
	}

	public void setLocation(LocationItemInventory location) {
		this.location = location;
	}

	/**
	public Calendar getInventoryDateCalendar() {
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(inventoryDate);
		return aCalendar;
	}
	**/

	public Date getInventoryDate() {
		return inventoryDate;
	}

	public void setInventoryDate(Date inventoryDate) {
		this.inventoryDate = inventoryDate;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getGuarantee() {
		return guarantee;
	}

	public void setGuarantee(String guarantee) {
		this.guarantee = guarantee;
	}

	/**
	public Calendar getGuaranteeDateCalendar() {
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(guaranteeDate);
		return aCalendar;
	}
	**/

	public Date getGuaranteeDate() {
		return guaranteeDate;
	}

	public void setGuaranteeDate(Date guaranteeDate) {
		this.guaranteeDate = guaranteeDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}