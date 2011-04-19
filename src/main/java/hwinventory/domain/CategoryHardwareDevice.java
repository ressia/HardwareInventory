package hwinventory.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CategoryHardwareDevice implements Serializable {

	private Long idCategory;
	private String nameCategory;
	private Set types = new HashSet();

	public CategoryHardwareDevice() {
	}

	public CategoryHardwareDevice(String aNameCategory) {
		nameCategory = aNameCategory;
	}

	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	
	public Set getTypes() {
		return types;
	}

	public void setTypes(Set types) {
		this.types = types;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nameCategory == null) ? 0 : nameCategory.hashCode());
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
		CategoryHardwareDevice other = (CategoryHardwareDevice) obj;
		if (nameCategory == null) {
			if (other.nameCategory != null)
				return false;
		} else if (!nameCategory.equals(other.nameCategory))
			return false;
		return true;
	}

	public void addTypes(TypeHardwareDevice aType) {
		aType.setCategory(this);
		types.add(aType);
	}

	public void removeTypes(TypeHardwareDevice aType) {
		aType.setCategory(this);
		types.remove(aType);
	}
}
