package hwinventory.dao;

import hwinventory.domain.CategoryHardwareDevice;
import hwinventory.domain.HardwareDevice;
import hwinventory.domain.InventoryItem;
import hwinventory.domain.LocationItemInventory;
import hwinventory.domain.TypeHardwareDevice;
import hwinventory.domain.User;

import java.util.Date;
import java.util.List;

public abstract class HardwareInventoryDAO {
	
	public abstract TypeHardwareDevice addType(String aNameType, CategoryHardwareDevice aCategory);

	public abstract HardwareDevice addHardwareDevice(TypeHardwareDevice aType,
			String aDiskSize, String aMemorySize, int anIanNumber,
			String aMacAddress, String aSerialNumber, String anIpAddress);

	public abstract User addUser(String aNameUser);
	
	public abstract CategoryHardwareDevice addCategory(String aNameCategory);

	public abstract LocationItemInventory addLocation(String aNameLocation);

	public abstract void addInventoryItem(HardwareDevice aHardwareDevice,
			int aScgNumber, String aNameItem, User aUser,
			LocationItemInventory aLocation, Date anInventoryDate,
			float aPrice, String aBudget, String aGuarantee,
			Date aGuaranteeDate, String aNote);

	/*public abstract void saveCategory(CategoryHardwareDevice aCategory);

	public abstract void saveType(TypeHardwareDevice aType,
			CategoryHardwareDevice aCategory);

	public abstract void saveUser(User aUser);

	public abstract void saveLocation(LocationItemInventory aLocation);
	
	public abstract void saveHardwareDevice(HardwareDevice aHardwareDevice,
			TypeHardwareDevice aType);

	public abstract void saveInventoryItem(InventoryItem anInventoryItem);*/

	public abstract List listObject(String className);
	
	public abstract List getAllItems();
	
	public abstract List getAllUsers();
	
	public abstract List getAllCategories();
	
	public abstract List getAllLocations();
	
	public abstract List getAllTypes();

	public abstract List getAllDevices();

	// check this one
	/*public abstract Object accessAnObjectString(String className, String variableName,
			String variable) throws HibernateException;
	
	public abstract Object accessAnObjectLong(String className, String variableName,
			Long variable) throws HibernateException ;
	*/
	public abstract Object getAUser(Long anIdUser);

	public abstract void modifyCategory(CategoryHardwareDevice aCategory);
	
	public abstract void modifyUser(User aUser);
	
	public abstract void modifyLocation(LocationItemInventory aLocation);
	
	public abstract void modifyType(TypeHardwareDevice aType);
	
	public abstract void modifyHardwareDevice(HardwareDevice aHardware);
	
	public abstract void modifyInventoryItem(InventoryItem anInventoryItem);
	
	public abstract void removeInventoryItem(InventoryItem anInventoryItem);

	public abstract void removeUser(User aUser);	
	
	public abstract void removeCategory(CategoryHardwareDevice aCategory);
	
	public abstract void removeLocation(LocationItemInventory aLocation);

	public abstract void removeType(TypeHardwareDevice aType);

	public abstract void removeHardwareDevice(HardwareDevice aHardware);
}
