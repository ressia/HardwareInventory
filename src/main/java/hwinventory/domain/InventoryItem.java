package hwinventory.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class InventoryItem implements Serializable {

	private Long idItem;
	private HardwareDevice hardwareDevice;
	private int scgNumber;
	private String nameItem;
	private User user;
	private LocationItemInventory location; 
	private Calendar inventoryDate;
	private float price;
	private String budget;
	private String guarantee;
	private Calendar guaranteeEnd;
	private String note;

	public InventoryItem() {
	}

	public InventoryItem(HardwareDevice aHardwareDevice, int aScgNumber, String aNameItem, User anUser
			, LocationItemInventory aLocation, Calendar anInventoryDate, float aPrice, String aBudget
			, String aGuarantee, Calendar aGuaranteeEnd, String aNote) {
		hardwareDevice = aHardwareDevice;
		scgNumber = aScgNumber;
		nameItem = aNameItem;
		user = anUser;
		location = aLocation;
		inventoryDate = anInventoryDate;
		price = aPrice;
		budget = aBudget;
		guarantee = aGuarantee;
		guaranteeEnd = aGuaranteeEnd;
		note = aNote;
	}

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

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

	public Calendar getInventoryDate() {
		return inventoryDate;
	}

	public void setInventoryDate(Calendar inventoryDate) {
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

	public Calendar getGuaranteeEnd() {
		return guaranteeEnd;
	}

	public void setGuaranteeEnd(Calendar guaranteeEnd) {
		this.guaranteeEnd = guaranteeEnd;
	}
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((budget == null) ? 0 : budget.hashCode());
		result = prime * result
				+ ((guarantee == null) ? 0 : guarantee.hashCode());
		result = prime * result
				+ ((guaranteeEnd == null) ? 0 : guaranteeEnd.hashCode());
		result = prime * result
				+ ((hardwareDevice == null) ? 0 : hardwareDevice.hashCode());
		result = prime * result
				+ ((inventoryDate == null) ? 0 : inventoryDate.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result
				+ ((nameItem == null) ? 0 : nameItem.hashCode());
		result = prime * result
				+ ((note == null) ? 0 : note.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + scgNumber;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InventoryItem other = (InventoryItem) obj;
		if (budget == null) {
			if (other.budget != null)
				return false;
		} else if (!budget.equals(other.budget))
			return false;
		if (guarantee == null) {
			if (other.guarantee != null)
				return false;
		} else if (!guarantee.equals(other.guarantee))
			return false;
		if (guaranteeEnd == null) {
			if (other.guaranteeEnd != null)
				return false;
		} else if (!guaranteeEnd.equals(other.guaranteeEnd))
			return false;
		if (hardwareDevice == null) {
			if (other.hardwareDevice != null)
				return false;
		} else if (!hardwareDevice.equals(other.hardwareDevice))
			return false;
		if (inventoryDate == null) {
			if (other.inventoryDate != null)
				return false;
		} else if (!inventoryDate.equals(other.inventoryDate))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (nameItem == null) {
			if (other.nameItem != null)
				return false;
		} else if (!nameItem.equals(other.nameItem))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (scgNumber != other.scgNumber)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}