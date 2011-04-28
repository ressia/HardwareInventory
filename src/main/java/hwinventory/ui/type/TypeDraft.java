package hwinventory.ui.type;

import hwinventory.domain.CategoryHardwareDevice;

public class TypeDraft {
	private String name;
	private CategoryHardwareDevice category;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CategoryHardwareDevice getCategory() {
		return category;
	}
	public void setCategory(CategoryHardwareDevice category) {
		this.category = category;
	}
}
