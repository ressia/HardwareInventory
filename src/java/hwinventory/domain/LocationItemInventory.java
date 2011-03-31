package hwinventory.domain;

import java.io.Serializable;

public class LocationItemInventory implements Serializable {
	
	private Long idLocation;
	private String nameLocation;
	
	public LocationItemInventory() {
	}
	
	public LocationItemInventory(String aNameLocation) {
		nameLocation = aNameLocation;
	}

	public Long getIdLocation() {
		return idLocation;
	}

	public void setIdLocation(Long idLocation) {
		this.idLocation = idLocation;
	}

	public String getNameLocation() {
		return nameLocation;
	}

	public void setNameLocation(String nameLocation) {
		this.nameLocation = nameLocation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nameLocation == null) ? 0 : nameLocation.hashCode());
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
		LocationItemInventory other = (LocationItemInventory) obj;
		if (nameLocation == null) {
			if (other.nameLocation != null)
				return false;
		} else if (!nameLocation.equals(other.nameLocation))
			return false;
		return true;
	}
}
