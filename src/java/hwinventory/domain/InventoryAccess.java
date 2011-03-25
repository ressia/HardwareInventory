package hwinventory.domain;

import hwinventory.util.HibernateUtil;

import java.util.Calendar;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class InventoryAccess {

	/*********** AccessIventory **********/

	public void InventoryAccess(int aScgNumber, int anIanNumber,
			String aNameCategory, String aNameItem, String anIpAddress,
			String aMacAddress, String aNameType, String aDiskSize,
			String aMemorySize, String aNameLocation, String aNameUser,
			float aPrice, Calendar anInventoryDate, String aBudget,
			String aSerialNumber, String aGuarantee, Calendar aGuaranteeEnd,
			String aNote) {

		List item = namedInt("ItemOfInventory", "scgNumber", aScgNumber);

		if (item.isEmpty()) {

			CategoryHardwareDevice aCategory = new CategoryHardwareDevice(aNameCategory);
			TypeHardwareDevice aType = new TypeHardwareDevice(aCategory,aNameType);
			HardwareDevice aHardwareDevice = new HardwareDevice(aType, aDiskSize, aMemorySize, anIanNumber, aMacAddress, aSerialNumber, anIpAddress);
			List category = namedString("CategoryHardwareDevice","nameCategory", aNameCategory);

			if (category.isEmpty()) {
				addCategory(aCategory);
				addType(aType, aCategory);
				addHardwareDevice(aHardwareDevice, aType);
			} else {

				List type = namedString("TypeHardwareDevice", "nameType", aNameType);

				if (type.isEmpty()) {
					addType(aType, aCategory);
					addHardwareDevice(aHardwareDevice, aType);
				} else {
					
					boolean hwDevice = HardwareDevice.class.equals(aHardwareDevice);
					
					if (!hwDevice) {
						addHardwareDevice(aHardwareDevice, aType);
					}
				}
			}
			
			LocationItemInventory aLocation = new LocationItemInventory(aNameLocation);
			List location = namedString("LocationItemInventory", "nameLocation", aNameLocation);
			
			if (location.isEmpty()) {
				addLocation(aLocation);
			}
			
			User anUser = new User(aNameUser);
			List user = namedString("User", "nameUser", aNameUser);
			
			if (user.isEmpty()) {
				addUser(anUser);
			}
			
			ItemOfInventory anItem = new ItemOfInventory(aHardwareDevice, aScgNumber, aNameItem, anUser, aLocation, anInventoryDate, aPrice, aBudget, aGuarantee, aGuaranteeEnd, aNote);
			addItem(anItem);
		}
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

	public void addType(TypeHardwareDevice aType, CategoryHardwareDevice aCategory) {
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

	/*********** addItem **********/

	public void addItem(ItemOfInventory anItem) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
	
		anItem.setScgNumber(anItem.getScgNumber());
		anItem.setBudget(anItem.getBudget());
		anItem.setGuarantee(anItem.getGuarantee());
		anItem.setGuaranteeEnd(anItem.getGuaranteeEnd());
		anItem.setHardwareDevice(anItem.getHardwareDevice());
		anItem.setInventoryDate(anItem.getInventoryDate());
		anItem.setLocation(anItem.getLocation());
		anItem.setNameItem(anItem.getNameItem());
		anItem.setNote(anItem.getNote());
		anItem.setPrice(anItem.getPrice());
		anItem.setUser(anItem.getUser());
		
		session.save(anItem);

		session.getTransaction().commit();
	}

	/*********** addHardwareDevice **********/

	public void addHardwareDevice(HardwareDevice aHardwareDevice, TypeHardwareDevice aTypeHardwareDevice) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		TypeHardwareDevice aType = (TypeHardwareDevice) session.load(
				TypeHardwareDevice.class, aTypeHardwareDevice.getIdType());
		
		aType.addDevices(aHardwareDevice);	

		session.getTransaction().commit();
	}


	/*********** namedInt **********/

	public List namedInt(String className, String variableName, int variable)
			throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List result = null;
		try {
			result = session
					.createQuery(
							"from " + className + " c where c." + variableName
									+ "= :name").setParameter("name", variable)
					.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
		}
		return result;
	}

	/*********** namedString **********/

	public List namedString(String className, String variableName,
			String variable) throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List result = null;
		try {
			result = session
					.createQuery(
							"from " + className + " c where c." + variableName
									+ "= :name").setParameter("name", variable)
					.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
		}
		return result;
	}
	
	/*********** namedDevice **********/

	public List namedDevice(String className, String variableName,
			String variable) throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List result = null;
		try {
			result = session
					.createQuery(
							"from " + className + " c where c." + variableName
									+ "= :name").setParameter("name", variable)
					.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
		}
		return result;
	}

	/*********** end class **********/
}
