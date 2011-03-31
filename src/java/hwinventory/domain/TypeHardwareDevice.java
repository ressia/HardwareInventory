package hwinventory.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TypeHardwareDevice implements Serializable {

	private Long idType;
	private CategoryHardwareDevice category;
	private String nameType;
	private Set devices = new HashSet();
	
	public TypeHardwareDevice() {
	}
	
	public TypeHardwareDevice(CategoryHardwareDevice aCategory, String aNameType) {
		nameType = aNameType;
		category = aCategory;
	}

	public Long getIdType() {
		return idType;
	}

	public void setIdType(Long idType) {
		this.idType = idType;
	}

	public CategoryHardwareDevice getCategory() {
		return category;
	}

	public void setCategory(CategoryHardwareDevice category) {
		this.category = category;
	}

	public String getNameType() {
		return nameType;
	}

	public void setNameType(String nameType) {
		this.nameType = nameType;
	}
	
	public Set getDevices() {
		return devices;
	}

	public void setDevices(Set devices) {
		this.devices = devices;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((nameType == null) ? 0 : nameType.hashCode());
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
		TypeHardwareDevice other = (TypeHardwareDevice) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (nameType == null) {
			if (other.nameType != null)
				return false;
		} else if (!nameType.equals(other.nameType))
			return false;
		return true;
	}
	
	public void addDevices(HardwareDevice aHardwareDevice) {
		aHardwareDevice.setType(this);
		devices.add(aHardwareDevice);
	}

	public void removeDevices(HardwareDevice aHardwareDevice) {
		aHardwareDevice.setType(this);
		devices.remove(aHardwareDevice);
	}
}
