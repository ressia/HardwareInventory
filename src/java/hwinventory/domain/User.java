package hwinventory.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class User implements Serializable {
	
	private Long idUser;
	private String nameUser;
	private Set items = new HashSet();
	
	public User() {
	}
	
	public User (String aNameUser) {
		nameUser = aNameUser;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	
	public Set getItems() {
		return items;
	}

	public void setItems(Set items) {
		this.items = items;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nameUser == null) ? 0 : nameUser.hashCode());
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
		User other = (User) obj;
		if (nameUser == null) {
			if (other.nameUser != null)
				return false;
		} else if (!nameUser.equals(other.nameUser))
			return false;
		return true;
	}
	
	public void addItems(InventoryItem anItem) {
		anItem.setUser(this);
		items.add(anItem);
	}

}
