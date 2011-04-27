package hwinventory.dao;

import hwinventory.domain.CategoryHardwareDevice;
import hwinventory.domain.HardwareDevice;
import hwinventory.domain.InventoryItem;
import hwinventory.domain.LocationItemInventory;
import hwinventory.domain.TypeHardwareDevice;
import hwinventory.domain.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
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
		return (CategoryHardwareDevice)categories.put(aNameCategory,new CategoryHardwareDevice(aNameCategory));
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
	public LocationItemInventory addAlocation(String aNameLocation) {
		LocationItemInventory aLocation = new LocationItemInventory(aNameLocation);
		users.add(aLocation);
		return aLocation;
	}

	@Override
	public void addInventoryItem(HardwareDevice aHardwareDevice,
			int aScgNumber, String aNameItem, User aUser,
			LocationItemInventory aLocation, Calendar anInventoryDate,
			float aPrice, String aBudget, String aGuarantee,
			Calendar aGuaranteeEnd, String aNote) {
		InventoryItem anItem = new InventoryItem(aHardwareDevice,
				 								aScgNumber,  
				 								aNameItem,  
				 								aUser,
				 								aLocation,  
				 								anInventoryDate,
				 								aPrice,  
				 								aBudget,  
				 								aGuarantee,
				 								aGuaranteeEnd,
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
	public Object getAUser(Long anIdUser) {
		return null;
	}

	@Override
	public void modifyCategory(String aNameCategory, String aNewNameCategory) {
		
	}

	@Override
	public void removeInventoryItem(int aScgNumber) {
		InventoryItem itemToRemove = null;
		for (Object anItem : items) {
			itemToRemove = (InventoryItem)anItem;
		    if (itemToRemove.getScgNumber() == aScgNumber) {
		    	break;
		    }
		}
		items.remove(itemToRemove);
	}


	@Override
	public void removeUser(String aNameUser) {
		User userToRemove = null;
		for (Object aUser : users) {
			userToRemove = (User)aUser;
		    if (userToRemove.getNameUser().equals(aNameUser)) {
		    	break;
		    }
		}
		users.remove(userToRemove);
	}

	@Override
	public void modifyUser(String aNameUser, String aNewNameUser) {	
	}

	@Override
	public void modifyInventoryItem(int aScgNumber, int anIanNumber,
			String aNameCategory, String aNameItem, String anIpAddress,
			String aMacAddress, String aNameType, String aDiskSize,
			String aMemorySize, String aNameLocation, String aNameUser,
			float aPrice, Calendar anInventoryDate, String aBudget,
			String aSerialNumber, String aGuarantee, Calendar aGuaranteeEnd,
			String aNote) {		
	}



}
