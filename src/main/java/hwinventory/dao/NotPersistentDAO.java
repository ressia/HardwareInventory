package hwinventory.dao;

import hwinventory.domain.CategoryHardwareDevice;
import hwinventory.domain.HardwareDevice;
import hwinventory.domain.InventoryItem;
import hwinventory.domain.LocationItemInventory;
import hwinventory.domain.TypeHardwareDevice;
import hwinventory.domain.User;

import java.util.Calendar;
import java.util.List;

import org.hibernate.HibernateException;

public class NotPersistentDAO extends HardwareInventoryDAO {

	@Override
	public CategoryHardwareDevice addCategory(String aNameCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeHardwareDevice addType(String aNameType,
			CategoryHardwareDevice aCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HardwareDevice addHardwareDevice(TypeHardwareDevice aType,
			String aDiskSize, String aMemorySize, int anIanNumber,
			String aMacAddress, String aSerialNumber, String anIpAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addUser(String aNameUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocationItemInventory addAlocation(String aNameLocation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addInventoryItem(HardwareDevice aHardwareDevice,
			int aScgNumber, String aNameItem, User aUser,
			LocationItemInventory aLocation, Calendar anInventoryDate,
			float aPrice, String aBudget, String aGuarantee,
			Calendar aGuaranteeEnd, String aNote) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveCategory(CategoryHardwareDevice aCategory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveType(TypeHardwareDevice aType,
			CategoryHardwareDevice aCategory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveUser(User aUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveLocation(LocationItemInventory aLocation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveHardwareDevice(HardwareDevice aHardwareDevice,
			TypeHardwareDevice aType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveInventoryItem(InventoryItem anInventoryItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List listObject(String className) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object accessAnObjectInt(String className, String variableName,
			int variable) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getAUser(Long anIdUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyCategory(String aNameCategory, String aNewNameCategory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modidyInventoryItem(int aScgNumber, int anIanNumber,
			String aNameCategory, String aNameItem, String anIpAddress,
			String aMacAddress, String aNameType, String aDiskSize,
			String aMemorySize, String aNameLocation, String aNameUser,
			float aPrice, Calendar anInventoryDate, String aBudget,
			String aSerialNumber, String aGuarantee, Calendar aGuaranteeEnd,
			String aNote) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeInventoryItem(int aScgNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInventoryItem(InventoryItem anInventoryItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUser(String aNameUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User aUser) {
		// TODO Auto-generated method stub
		
	}

}
