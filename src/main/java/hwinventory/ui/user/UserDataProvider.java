package hwinventory.ui.user;

import hwinventory.domain.InventoryAccess;
import hwinventory.domain.User;

import java.util.Iterator;
import java.util.List;

import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;

public class UserDataProvider implements IDataProvider {
	
	InventoryAccess anInventoryAccess = new InventoryAccess();
	List listUser = anInventoryAccess.listObject("User");

	// The data for the "current" page
	public Iterator iterator(final int first, final int count){
		return listUser.iterator();
	}

	// This is required to determine the total number of
	// Pages the DataView or an equivalent "repeater"
	// component is working with.
	public int size(){
		return listUser.size();
	}
	
	public IModel model(Object object){
		return new DetachableUserModel((User) object);
	}
		
	@Override
	public void detach() {		
	}
}
