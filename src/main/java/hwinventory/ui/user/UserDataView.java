package hwinventory.ui.user;

import hwinventory.dao.HardwareInventoryDAO;
import hwinventory.dao.InventoryAccess;
import hwinventory.domain.User;
import hwinventory.ui.application.HardwareInventoryApplication;
import hwinventory.ui.inventoryItem.InventoryItemView;
import hwinventory.ui.login.Login;

import org.apache.wicket.Application;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;

public class UserDataView extends DataView{

	
	private HardwareInventoryDAO aDAO = ((HardwareInventoryApplication)Application.get()).getSystem().getHardwareInventoryDAO();
	
	public UserDataView(String id, IDataProvider aUserDataProvider) {
		super(id, aUserDataProvider);
	}
	
	protected void populateItem(final Item item) {
		User aUser = (User) item.getModelObject();
		item.setModel(new CompoundPropertyModel(aUser));
		item.add(new Label("nameUser"));
		item.add(new Link("linkToDelete") {
			public void onClick() {
	    		User aUser = (User)item.getModelObject();
	    		try {
	    			aDAO.removeUser(aUser); 	
		    		UserView aUserView = new UserView(); 
					setResponsePage(aUserView);
	    		} catch(Exception e) {
	    			String errMsg = getLocalizer().getString(
	    					"login.errors.invalidCredentials ", UserDataView.this,"Unable to delete user.");
	    			error(errMsg);
	    		}
			}
		});
		item.add(new Link("linkToEdit") {
			public void onClick() {
				User aUser = (User) item.getModelObject();
				EditUser anEditUser = new EditUser(aUser);
				setResponsePage(anEditUser);
			}
		});
	}
}
