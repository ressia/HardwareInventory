package hwinventory.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class HardwareInventory implements Serializable {
	
	private Set items = new HashSet();
	
	public HardwareInventory () {
	}

	public Set getItems() {
		return items;
	}

	public void setItems(Set items) {
		this.items = items;
	}
}
