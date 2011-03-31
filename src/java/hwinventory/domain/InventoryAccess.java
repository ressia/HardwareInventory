package hwinventory.domain;

import hwinventory.util.HibernateUtil;

import java.util.Calendar;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class InventoryAccess {

	/*********** insertInventoryItem **********/

	public void insertInventoryItem(int aScgNumber, int anIanNumber,
			String aNameCategory, String aNameItem, String anIpAddress,
			String aMacAddress, String aNameType, String aDiskSize,
			String aMemorySize, String aNameLocation, String aNameUser,
			float aPrice, Calendar anInventoryDate, String aBudget,
			String aSerialNumber, String aGuarantee, Calendar aGuaranteeEnd,
			String aNote) {
		CategoryHardwareDevice aCategory = verifiedCategory(aNameCategory);
		TypeHardwareDevice aType = verifiedType(aNameType, aCategory);
		HardwareDevice aHardwareDevice = verifiedHardwareDevice(aType,
				aDiskSize, aMemorySize, anIanNumber, aMacAddress,
				aSerialNumber, anIpAddress);
		User anUser = verifiedAnUser(aNameUser);
		LocationItemInventory aLocation = verifiedAlocation(aNameLocation);
		verifiedInventoryItem(aHardwareDevice, aScgNumber, aNameItem, anUser,
				aLocation, anInventoryDate, aPrice, aBudget, aGuarantee,
				aGuaranteeEnd, aNote);
	}

	/*********** verifiedCategory **********/

	private CategoryHardwareDevice verifiedCategory(String aNameCategory) {
		CategoryHardwareDevice aCategory = getACategory(aNameCategory);
		if (aCategory == null) {
			aCategory = new CategoryHardwareDevice(aNameCategory);
			addCategory(aCategory);
		}
		return aCategory;
	}

	/*********** verifiedType **********/

	private TypeHardwareDevice verifiedType(String aNameType,
			CategoryHardwareDevice aCategory) {
		TypeHardwareDevice aType = getAType(aNameType);
		if (aType == null) {
			aType = new TypeHardwareDevice(aCategory, aNameType);
			addType(aType, aCategory);
		}
		return aType;
	}

	/*********** verifiedHardwareDevice **********/

	private HardwareDevice verifiedHardwareDevice(TypeHardwareDevice aType,
			String aDiskSize, String aMemorySize, int anIanNumber,
			String aMacAddress, String aSerialNumber, String anIpAddress) {
		HardwareDevice aHardwareDevice = getAHardwareDevice(aType, anIanNumber,
				anIpAddress, aSerialNumber);
		if (aHardwareDevice == null) {
			aHardwareDevice = new HardwareDevice(aType, aDiskSize, aMemorySize,
					anIanNumber, aMacAddress, aSerialNumber, anIpAddress);
			addHardwareDevice(aHardwareDevice, aType);
		}
		return aHardwareDevice;
	}

	/*********** verifiedUser **********/

	private User verifiedAnUser(String aNameUser) {
		User anUser = getAnUser(aNameUser);
		if (anUser == null) {
			anUser = new User(aNameUser);
			addUser(anUser);
		}
		return anUser;
	}

	/*********** verifiedLocation **********/

	private LocationItemInventory verifiedAlocation(String aNameLocation) {
		LocationItemInventory aLocation = getAlocation(aNameLocation);
		if (aLocation == null) {
			aLocation = new LocationItemInventory(aNameLocation);
			addLocation(aLocation);
		}
		return aLocation;
	}

	/*********** verifiedInventoryItem **********/

	private void verifiedInventoryItem(HardwareDevice aHardwareDevice,
			int aScgNumber, String aNameItem, User anUser,
			LocationItemInventory aLocation, Calendar anInventoryDate,
			float aPrice, String aBudget, String aGuarantee,
			Calendar aGuaranteeEnd, String aNote) {
		InventoryItem anInventoryItem = getAnInventoryItem(aScgNumber);
		if (anInventoryItem == null) {
			anInventoryItem = new InventoryItem(aHardwareDevice, aScgNumber,
					aNameItem, anUser, aLocation, anInventoryDate, aPrice,
					aBudget, aGuarantee, aGuaranteeEnd, aNote);
			addInventoryItem(anInventoryItem);
		}
	}

	/*********** getACategory **********/

	private CategoryHardwareDevice getACategory(String aNameCategory) {
		CategoryHardwareDevice aCategory = (CategoryHardwareDevice) accessAnObjectString(
				"CategoryHardwareDevice", "nameCategory", aNameCategory);
		return aCategory;
	}

	/*********** getAType **********/

	private TypeHardwareDevice getAType(String aNameType) {
		TypeHardwareDevice aType = (TypeHardwareDevice) accessAnObjectString(
				"TypeHardwareDevice", "nameType", aNameType);
		return aType;
	}

	/*********** getAnUser **********/

	private User getAnUser(String aNameUser) {
		User anUser = (User) accessAnObjectString("User", "nameUser", aNameUser);
		return anUser;
	}

	/*********** getALocation **********/

	private LocationItemInventory getAlocation(String aNameLocation) {
		LocationItemInventory aLocation = (LocationItemInventory) accessAnObjectString(
				"LocationItemInventory", "nameLocation", aNameLocation);
		return aLocation;
	}

	/*********** getAHardwareDevice **********/

	private HardwareDevice getAHardwareDevice(TypeHardwareDevice aType,
			int anIanNumber, String anIpAddress, String aSerialNumber) {
		HardwareDevice aHardwareDevice = (HardwareDevice) accessAHarwareDevice(
				aType, anIanNumber, anIpAddress, aSerialNumber);
		return aHardwareDevice;
	}

	/*********** getInventoryItem **********/

	private InventoryItem getAnInventoryItem(int aScgNumber) {
		InventoryItem anInventoryItem = (InventoryItem) accessAnObjectInt(
				"InventoryItem", "scgNumber", aScgNumber);
		return anInventoryItem;

	}

	/*********** addCategory **********/

	public void addCategory(CategoryHardwareDevice aCategory) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		aCategory.setNameCategory(aCategory.getNameCategory());
		session.save(aCategory);
		session.getTransaction().commit();
	}

	/*********** addType **********/

	public void addType(TypeHardwareDevice aType,
			CategoryHardwareDevice aCategory) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		CategoryHardwareDevice aCateg = (CategoryHardwareDevice) session.load(
				CategoryHardwareDevice.class, aCategory.getIdCategory());
		aCateg.addTypes(aType);
		session.getTransaction().commit();
	}

	/*********** addUser **********/

	public void addUser(User anUser) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		anUser.setNameUser(anUser.getNameUser());
		session.save(anUser);
		session.getTransaction().commit();
	}

	/*********** addLocation **********/

	public void addLocation(LocationItemInventory aLocation) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		aLocation.setNameLocation(aLocation.getNameLocation());
		session.save(aLocation);
		session.getTransaction().commit();
	}

	/*********** addInventoryItem **********/

	public void addInventoryItem(InventoryItem anInventoryItem) {
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
		session.save(anInventoryItem);
		session.getTransaction().commit();
	}

	/*********** addHardwareDevice **********/

	public void addHardwareDevice(HardwareDevice aHardwareDevice,
			TypeHardwareDevice aType) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		TypeHardwareDevice aTypeHw = (TypeHardwareDevice) session.load(
				TypeHardwareDevice.class, aType.getIdType());
		aTypeHw.addDevices(aHardwareDevice);
		session.getTransaction().commit();
	}

	/*********** accessAnObjectInt **********/

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

	/*********** accessAnObjectString **********/

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

	/*********** accessAHardwareDevice **********/

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
}
