package hwinventory.domain;

import hwinventory.db.HibernateUtil;

import java.util.Calendar;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class InventoryAccess {

	
	/**
	 * verifiedCategory 
	**/

	public CategoryHardwareDevice verifiedCategory(String aNameCategory) {
		CategoryHardwareDevice aCategory = getACategory(aNameCategory);
		if (aCategory == null) {
			aCategory = new CategoryHardwareDevice(aNameCategory);
			saveCategory(aCategory);
		}
		return aCategory;
	}

	/**  verifiedType **/

	public TypeHardwareDevice verifiedType(String aNameType,
			CategoryHardwareDevice aCategory) {
		TypeHardwareDevice aType = getAType(aNameType);
		if (aType == null) {
			aType = new TypeHardwareDevice(aCategory, aNameType);
			saveType(aType, aCategory);
		}
		return aType;
	}

	/**  verifiedHardwareDevice **/

	public HardwareDevice verifiedHardwareDevice(TypeHardwareDevice aType,
			String aDiskSize, String aMemorySize, int anIanNumber,
			String aMacAddress, String aSerialNumber, String anIpAddress) {
		HardwareDevice aHardwareDevice = getAHardwareDevice(aType, anIanNumber,
				anIpAddress, aSerialNumber);
		if (aHardwareDevice == null) {
			aHardwareDevice = new HardwareDevice(aType, aDiskSize, aMemorySize,
					anIanNumber, aMacAddress, aSerialNumber, anIpAddress);
			saveHardwareDevice(aHardwareDevice, aType);
		}
		return aHardwareDevice;
	}

	/**  verifiedUser **/

	public User verifiedAnUser(String aNameUser) {
		User anUser = getAnUser(aNameUser);
		if (anUser == null) {
			anUser = new User(aNameUser);
			saveUser(anUser);
		}
		return anUser;
	}

	/**  verifiedLocation **/

	public LocationItemInventory verifiedAlocation(String aNameLocation) {
		LocationItemInventory aLocation = getAlocation(aNameLocation);
		if (aLocation == null) {
			aLocation = new LocationItemInventory(aNameLocation);
			saveLocation(aLocation);
		}
		return aLocation;
	}

	/**  insertInventoryItem **/

	public void insertInventoryItem(HardwareDevice aHardwareDevice,
			int aScgNumber, String aNameItem, User anUser,
			LocationItemInventory aLocation, Calendar anInventoryDate,
			float aPrice, String aBudget, String aGuarantee,
			Calendar aGuaranteeEnd, String aNote) {
		InventoryItem anInventoryItem = getAnInventoryItem(aScgNumber);
		if (anInventoryItem == null) {
			anInventoryItem = new InventoryItem(aHardwareDevice, aScgNumber,
					aNameItem, anUser, aLocation, anInventoryDate, aPrice,
					aBudget, aGuarantee, aGuaranteeEnd, aNote);
			saveInventoryItem(anInventoryItem);
		}
	}

	/**  getACategory **/

	private CategoryHardwareDevice getACategory(String aNameCategory) {
		CategoryHardwareDevice aCategory = (CategoryHardwareDevice) accessAnObjectString(
				"CategoryHardwareDevice", "nameCategory", aNameCategory);
		return aCategory;
	}

	/**  getAType **/

	private TypeHardwareDevice getAType(String aNameType) {
		TypeHardwareDevice aType = (TypeHardwareDevice) accessAnObjectString(
				"TypeHardwareDevice", "nameType", aNameType);
		return aType;
	}

	/**  getAnUser **/

	private User getAnUser(String aNameUser) {
		User anUser = (User) accessAnObjectString("User", "nameUser", aNameUser);
		return anUser;
	}

	/**  getALocation **/

	private LocationItemInventory getAlocation(String aNameLocation) {
		LocationItemInventory aLocation = (LocationItemInventory) accessAnObjectString(
				"LocationItemInventory", "nameLocation", aNameLocation);
		return aLocation;
	}

	/**  getAHardwareDevice **/

	private HardwareDevice getAHardwareDevice(TypeHardwareDevice aType,
			int anIanNumber, String anIpAddress, String aSerialNumber) {
		HardwareDevice aHardwareDevice = (HardwareDevice) accessAHarwareDevice(
				aType, anIanNumber, anIpAddress, aSerialNumber);
		return aHardwareDevice;
	}

	/**  getInventoryItem **/

	private InventoryItem getAnInventoryItem(int aScgNumber) {
		InventoryItem anInventoryItem = (InventoryItem) accessAnObjectInt(
				"InventoryItem", "scgNumber", aScgNumber);
		return anInventoryItem;

	}

	/**  saveCategory **/

	public void saveCategory(CategoryHardwareDevice aCategory) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		aCategory.setNameCategory(aCategory.getNameCategory());
		session.save(aCategory);
		session.getTransaction().commit();
	}

	/**  saveType **/

	public void saveType(TypeHardwareDevice aType,
			CategoryHardwareDevice aCategory) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		CategoryHardwareDevice aCateg = (CategoryHardwareDevice) session.load(CategoryHardwareDevice.class, aCategory.getIdCategory());
		aCateg.addTypes(aType);
		aType.setNameType(aType.getNameType());
		aType.setCategory(aType.getCategory());
		session.save(aType);
		session.getTransaction().commit();
	}

	/**  saveUser **/

	public void saveUser(User anUser) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		anUser.setNameUser(anUser.getNameUser());
		session.save(anUser);
		session.getTransaction().commit();
	}

	/**  saveLocation **/

	public void saveLocation(LocationItemInventory aLocation) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		aLocation.setNameLocation(aLocation.getNameLocation());
		session.save(aLocation);
		session.getTransaction().commit();
	}

	/**  saveInventoryItem **/

	public void saveInventoryItem(InventoryItem anInventoryItem) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		anInventoryItem.setScgNumber(anInventoryItem.getScgNumber());
		anInventoryItem.setBudget(anInventoryItem.getBudget());
		anInventoryItem.setGuarantee(anInventoryItem.getGuarantee());
		anInventoryItem.setGuaranteeEnd(anInventoryItem.getGuaranteeEnd());
		anInventoryItem.setHardwareDevice(anInventoryItem.getHardwareDevice());
		anInventoryItem.setInventoryDate(anInventoryItem.getInventoryDate());
		anInventoryItem.setLocation(anInventoryItem.getLocation());
		anInventoryItem.setNameItem(anInventoryItem.getNameItem());
		anInventoryItem.setNote(anInventoryItem.getNote());
		anInventoryItem.setPrice(anInventoryItem.getPrice());
		anInventoryItem.setUser(anInventoryItem.getUser());
		anInventoryItem.setNote(anInventoryItem.getNote());
		session.save(anInventoryItem);
		session.getTransaction().commit();
	}

	/**  saveHardwareDevice **/

	public void saveHardwareDevice(HardwareDevice aHardwareDevice,
			TypeHardwareDevice aType) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		TypeHardwareDevice aTypeHw = (TypeHardwareDevice) session.load(TypeHardwareDevice.class, aType.getIdType());
		aTypeHw.addDevices(aHardwareDevice);
		aHardwareDevice.setDiskSize(aHardwareDevice.getDiskSize());
		aHardwareDevice.setIanNumber(aHardwareDevice.getIanNumber());
		aHardwareDevice.setIpAddress(aHardwareDevice.getIpAddress());
		aHardwareDevice.setMacAddress(aHardwareDevice.getMacAddress());
		aHardwareDevice.setMemorySize(aHardwareDevice.getMemorySize());
		aHardwareDevice.setSerialNumber(aHardwareDevice.getSerialNumber());
		aHardwareDevice.setType(aHardwareDevice.getType());
		session.save(aHardwareDevice);
		session.getTransaction().commit();
	}

	/**  accessAnObjectInt **/

	public Object accessAnObjectInt(String className, String variableName,
			int variable) throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Object result = null;
		try {
			result = session
					.createQuery(
							"from " + className + " c where c." + variableName
									+ "= :name").setParameter("name", variable)
					.uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
		}
		return result;
	}

	/**  accessAnObjectString **/

	public Object accessAnObjectString(String className, String variableName,
			String variable) throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Object result = null;
		try {
			result = session
					.createQuery(
							"from " + className + " c where c." + variableName
									+ "= :name").setParameter("name", variable)
					.uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
		}
		return result;
	}

	/**  accessAHardwareDevice **/

	private HardwareDevice accessAHarwareDevice(TypeHardwareDevice aType,
			int anIanNumber, String anIpAddress, String aSerialNumber) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		HardwareDevice result = null;
		if (anIanNumber == 0 && anIpAddress == null && aSerialNumber == null) {
			try {
				result = (HardwareDevice) session
						.createQuery(
								"from HardwareDevice h where h.type.idType =:type")
						.setParameter("type", aType.getIdType()).uniqueResult();
				session.getTransaction().commit();
			} catch (HibernateException e) {
				e.printStackTrace();
			} finally {
			}
		} else {
			try {
				result = (HardwareDevice) session
						.createQuery(
								"from HardwareDevice h where h.ianNumber =:ian and h.ipAddress =:ip and h.serialNumber =:serial")
						.setParameter("ian", anIanNumber)
						.setParameter("ip", anIpAddress)
						.setParameter("serial", aSerialNumber).uniqueResult();
				session.getTransaction().commit();
			} catch (HibernateException e) {
				e.printStackTrace();
			} finally {
			}
		}
		return result;
	}
	
	
	/**  modifyCategory **/

	public void modifyCategory(String aNameCategory, String aNewNameCategory) {
		CategoryHardwareDevice aCategory = getACategory(aNameCategory);
		if (aCategory != null) {
			updateCategory(aCategory, aNewNameCategory);
		}
	}
	
	/**  updateCategory **/

	private void updateCategory(CategoryHardwareDevice aCategory, String aNewNameCategory) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		aCategory.setNameCategory(aNewNameCategory);
		session.update(aCategory);
		session.getTransaction().commit();	
	}
	
	/**  modifyCategory **/

	public void modidyInventoryItem(int aScgNumber, int anIanNumber,
			String aNameCategory, String aNameItem, String anIpAddress,
			String aMacAddress, String aNameType, String aDiskSize,
			String aMemorySize, String aNameLocation, String aNameUser,
			float aPrice, Calendar anInventoryDate, String aBudget,
			String aSerialNumber, String aGuarantee, Calendar aGuaranteeEnd,
			String aNote) {
		InventoryItem anInventoryItem = getAnInventoryItem(aScgNumber);
		if (anInventoryItem != null) {
			User anUser = getAnUser(aNameUser);
			LocationItemInventory aLocation = getAlocation(aNameLocation);
			TypeHardwareDevice aType = getAType(aNameType);
			HardwareDevice aHarwareDevice = getAHardwareDevice(aType, anIanNumber, anIpAddress, aSerialNumber);
			updateInventoryItem(anInventoryItem, anUser, aLocation, aHarwareDevice, aNameItem
					,aPrice, anInventoryDate, aBudget, aGuarantee, aGuaranteeEnd
					,aNote);
		}
	}
	
	/**  updateInventoryItem **/

	private void updateInventoryItem(InventoryItem anInventoryItem,
			User anUser, LocationItemInventory aLocation,
			HardwareDevice aHarwareDevice, String aNameItem, float aPrice,
			Calendar anInventoryDate, String aBudget, String aGuarantee,
			Calendar aGuaranteeEnd, String aNote) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		anInventoryItem.setBudget(aBudget);
		anInventoryItem.setGuarantee(aGuarantee);
		anInventoryItem.setGuaranteeEnd(aGuaranteeEnd);
		anInventoryItem.setHardwareDevice(aHarwareDevice);
		anInventoryItem.setInventoryDate(anInventoryDate);
		anInventoryItem.setLocation(aLocation);
		anInventoryItem.setNameItem(aNameItem);
		anInventoryItem.setNote(aNote);
		anInventoryItem.setPrice(aPrice);
		anInventoryItem.setUser(anUser);
		session.update(anInventoryItem);
		session.getTransaction().commit();	
	}

	/**  removeCategory **/
	
	public void removeInventoryItem(int aScgNumber) {
		InventoryItem anInventoryItem = getAnInventoryItem(aScgNumber);
		if (anInventoryItem != null) {
			deleteInventoryItem(anInventoryItem);
		}
	}
	
	/**  deleteCategory **/
	
	public void deleteInventoryItem(InventoryItem anInventoryItem) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(anInventoryItem);
		session.getTransaction().commit();	
	}
}
