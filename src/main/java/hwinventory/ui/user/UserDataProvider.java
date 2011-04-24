package hwinventory.ui.user;

import hwinventory.dao.HardwareInventoryDAO;
import hwinventory.dao.InventoryAccess;
import hwinventory.domain.User;
import hwinventory.ui.application.HardwareInventoryApplication;

import java.util.Iterator;
import java.util.List;

import org.apache.wicket.Application;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

public class UserDataProvider implements IDataProvider {
	
	
	List listUser = ((HardwareInventoryApplication)Application.get()).getSystem().getHardwareInventoryDAO().getAllUsers();

	public Iterator iterator(final int first, final int count){
		return listUser.iterator();
	}

	public int size(){
		return listUser.size();
	}
	
	public IModel model(Object object){
		return new CompoundPropertyModel(object);
	}
		
	@Override
	public void detach() {		
	}
}
