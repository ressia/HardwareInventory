package hwinventory.dao;

import hwinventory.domain.CategoryHardwareDevice;
import hwinventory.domain.HardwareDevice;
import hwinventory.domain.InventoryItem;
import hwinventory.domain.LocationItemInventory;
import hwinventory.domain.TypeHardwareDevice;
import hwinventory.domain.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.HibernateException;

public class NotPersistentDAO extends HardwareInventoryDAO {

	private HashMap categories = new HashMap();
	private HashMap types = new HashMap();
	private Collection devices = new ArrayList();
	private Collection users = new ArrayList();
	private HashMap locations = new HashMap();
	private Collection items = new ArrayList();
	
	@Override
	public CategoryHardwareDevice addCategory(String aNameCategory) {
		CategoryHardwareDevice aCategory = new CategoryHardwareDevice(aNameCategory);
		categories.put(aNameCategory, aCategory);
		return aCategory;
	}

	@Override
	public TypeHardwareDevice addType(String aNameType, CategoryHardwareDevice aCategory) {
		return aCategory.addType(new TypeHardwareDevice(aCategory,aNameType));
	}

	@Override
	public HardwareDevice addHardwareDevice(TypeHardwareDevice aType,
			String aDiskSize, String aMemorySize, int anIanNumber,
			String aMacAddress, String aSerialNumber, String anIpAddress) {
		HardwareDevice aDevice = new HardwareDevice(aType,
													aDiskSize, 
													aMemorySize, 
													anIanNumber,
													aMacAddress, 
													aSerialNumber, 
													anIpAddress);
		devices.add(aDevice);
		return aDevice;
	}

	@Override
	public User addUser(String aNameUser) {
		User aUser = new User(aNameUser);
		users.add(aUser);
		return aUser;
	}

	@Override
	public LocationItemInventory addLocation(String aNameLocation) {
		LocationItemInventory aLocation = new LocationItemInventory(aNameLocation);
		users.add(aLocation);
		return aLocation;
	}

	@Override
	public void addInventoryItem(HardwareDevice aHardwareDevice,
			int aScgNumber, String aNameItem, User aUser,
			LocationItemInventory aLocation, Date anInventoryDate,
			float aPrice, String aBudget, String aGuarantee,
			Date aguaranteeDate, String aNote) {
		InventoryItem anItem = new InventoryItem(aHardwareDevice,
				 								aScgNumber,  
				 								aNameItem,  
				 								aUser,
				 								aLocation,  
				 								anInventoryDate,
				 								aPrice,  
				 								aBudget,  
				 								aGuarantee,
				 								aguaranteeDate,
				 								aNote);
		items.add(anItem);
	}

	@Override
	public List listObject(String className) throws HibernateException {
		return new ArrayList();
	}

	@Override
	public List getAllItems() {
		return (List)items;
	}

	@Override
	public List getAllUsers() {
		return (List)users;
	}
	
	@Override
	public List getAllCategories() {
		return (List)categories;
	}
	
	@Override
	public List getAllLocations() {
		return (List)locations;
	}

	@Override
	public List getAllTypes() {
		return (List)types;
	}

	@Override
	public List getAllDevices() {
		return (List)devices;
	}

	@Override
	public Object getAUser(Long anIdUser) {
		return null;
	}

	@Override
	public void modifyCategory(CategoryHardwareDevice aCategory) {
		
	}

	@Override
	public void removeInventoryItem(InventoryItem anInventoryItem) {
		InventoryItem itemToRemove = null;
		for (Object anItem : items) {
			itemToRemove = (InventoryItem)anItem;
		    if (itemToRemove.getScgNumber() == anInventoryItem.getScgNumber()) {
		    	break;
		    }
		}
		items.remove(itemToRemove);
	}


	@Override
	public void removeUser(User aUser) {
		User userToRemove = null;
		for (Object aUserObject : users) {
			userToRemove = (User)aUserObject;
		    if (userToRemove.getNameUser().equals(aUser.getNameUser())) {
		    	break;
		    }
		}
		users.remove(userToRemove);
	}
	
	@Override
	public void removeCategory(CategoryHardwareDevice aCategory) {
	}

	@Override
	public void removeLocation(LocationItemInventory aLocation) {
	}
	
	@Override
	public void removeType(TypeHardwareDevice aType) {
	}
	
	@Override
	public void removeHardwareDevice(HardwareDevice aHardware) {
	}

	@Override
	public void modifyUser(User aUser) {	
	}
	
	@Override
	public void modifyLocation(LocationItemInventory aLocation) {		
	}

	@Override
	public void modifyInventoryItem(InventoryItem anInventoryItem) {		
	}

	@Override
	public void modifyType(TypeHardwareDevice aType) {
	}

	@Override
	public void modifyHardwareDevice(HardwareDevice aHardware) {
	}
}
