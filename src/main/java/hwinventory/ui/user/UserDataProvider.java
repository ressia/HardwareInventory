package hwinventory.ui.user;

import hwinventory.domain.InventoryAccess;
import hwinventory.domain.User;

import java.util.Iterator;
import java.util.List;

import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

public class UserDataProvider implements IDataProvider {
	
	InventoryAccess anInventoryAccess = new InventoryAccess();
	List listUser = anInventoryAccess.getAllUsers();

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
