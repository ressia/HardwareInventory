package hwinventory.dao;

import hwinventory.db.HibernateUtil;
import hwinventory.domain.CategoryHardwareDevice;
import hwinventory.domain.HardwareDevice;
import hwinventory.domain.InventoryItem;
import hwinventory.domain.LocationItemInventory;
import hwinventory.domain.TypeHardwareDevice;
import hwinventory.domain.User;

import java.util.Calendar;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public abstract class HardwareInventoryDAO {


	public abstract CategoryHardwareDevice addCategory(String aNameCategory);
	
	public abstract TypeHardwareDevice addType(String aNameType, CategoryHardwareDevice aCategory);

	public abstract HardwareDevice addHardwareDevice(TypeHardwareDevice aType,
			String aDiskSize, String aMemorySize, int anIanNumber,
			String aMacAddress, String aSerialNumber, String anIpAddress);

	public abstract User addUser(String aNameUser);

	public abstract LocationItemInventory addAlocation(String aNameLocation);

	public abstract void addInventoryItem(HardwareDevice aHardwareDevice,
			int aScgNumber, String aNameItem, User aUser,
			LocationItemInventory aLocation, Calendar anInventoryDate,
			float aPrice, String aBudget, String aGuarantee,
			Calendar aGuaranteeEnd, String aNote);

	public abstract void saveCategory(CategoryHardwareDevice aCategory);


	public abstract void saveType(TypeHardwareDevice aType,
			CategoryHardwareDevice aCategory);

	public abstract void saveUser(User aUser);

	public abstract void saveLocation(LocationItemInventory aLocation);
	
	public abstract void saveHardwareDevice(HardwareDevice aHardwareDevice,
			TypeHardwareDevice aType);

	public abstract void saveInventoryItem(InventoryItem anInventoryItem);

	public abstract List listObject(String className) throws HibernateException;
	
	public abstract List getAllItems();
	
	public abstract List getAllUsers();
	
	public abstract Object accessAnObjectInt(String className, String variableName,
			int variable) throws HibernateException;

	// check this one
	/*public abstract Object accessAnObjectString(String className, String variableName,
			String variable) throws HibernateException;
	
	public abstract Object accessAnObjectLong(String className, String variableName,
			Long variable) throws HibernateException ;
	*/
	public abstract Object getAUser(Long anIdUser);

	public abstract void modifyCategory(String aNameCategory, String aNewNameCategory);
	
	public abstract void modidyInventoryItem(int aScgNumber, int anIanNumber,
			String aNameCategory, String aNameItem, String anIpAddress,
			String aMacAddress, String aNameType, String aDiskSize,
			String aMemorySize, String aNameLocation, String aNameUser,
			float aPrice, Calendar anInventoryDate, String aBudget,
			String aSerialNumber, String aGuarantee, Calendar aGuaranteeEnd,
			String aNote);
	
	public abstract void removeInventoryItem(int aScgNumber);

	public abstract void deleteInventoryItem(InventoryItem anInventoryItem);
	
	public abstract void removeUser(String aNameUser);
	
	public abstract void deleteUser(User aUser);
	
	
}
