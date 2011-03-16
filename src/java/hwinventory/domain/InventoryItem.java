package hwinventory.domain;

import hwinventory.util.HibernateUtil;

import java.io.Serializable;
import java.util.*;

public class InventoryItem implements Serializable {

	/*********** Variables **********/

	private Long idInventory;
	private String note;
	private Set items = new HashSet();
	

	/*********** Constructors **********/

	public InventoryItem() {
	}

	public InventoryItem(String aNote) {
		note = aNote;
	}

	/*********** Getters and Setters **********/

	public Long getIdInventory() {
		return idInventory;
	}

	public void setIdInventory(Long idInventory) {
		this.idInventory = idInventory;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Set getItems() {
		return items;
	}

	public void setItems(Set items) {
		this.items = items;
	}
	

	/*********** adds **********/



	/*********** HashCodes and Equals **********/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
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
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		return true;
	}
}
