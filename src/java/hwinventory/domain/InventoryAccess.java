package hwinventory.domain;

import hwinventory.util.HibernateUtil;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class InventoryAccess {
	
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

		CategoryHardwareDevice aCateg = (CategoryHardwareDevice) session.load(CategoryHardwareDevice.class,
				aCategory.getIdCategory());

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

	public void addItem() {
	}
	
	/*********** addDevice **********/

	public void addDevice() {
	}
	
	/*********** addInventory **********/

	public void addInventory() {
	}


	/*********** categoryNamed **********/

	public List categoryNamed(String aNameCategory) throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List result = null;
		try {
			result = session
					.createQuery(
							"from CategoryHardwareInventory c where c.nameCategory = :name")
					.setParameter("name", aNameCategory).list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
		}
		return result;
	}

	/*********** typeNamed **********/

	public List typeNamed(String aNameType) throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List result = null;
		try {
			result = session
					.createQuery("from TypeHardwareDevice t where t.nameType = :name")
					.setParameter("name", aNameType).list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
		}
		return result;
	}
	
	
	/*********** UserNamed **********/

	public List userNamed(String aNameUser) throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List result = null;
		try {
			result = session
					.createQuery("from User u where u.nameUser = :name")
					.setParameter("name", aNameUser).list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
		}
		return result;
	}
	
	
	/*********** locationNamed **********/

	public List locationNamed(String aNameLocation) throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List result = null;
		try {
			result = session
					.createQuery("from LocationItemInventory l where l.nameLocation = :name")
					.setParameter("name", aNameLocation).list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
		}
		return result;
	}


	/*********** AccessIventory **********/

	public void InventoryAccess() {
	}
	
	
/*********** end class **********/
}
