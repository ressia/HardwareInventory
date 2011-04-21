package hwinventory.ui.user;

import hwinventory.domain.InventoryAccess;
import hwinventory.domain.User;
import hwinventory.ui.inventoryItem.InventoryItemView;
import hwinventory.ui.login.Login;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;

public class UserDataView extends DataView{

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
	    		InventoryAccess anInventoryAccess = new InventoryAccess();
	    		try {
		    		anInventoryAccess.removeUser(aUser.getNameUser()); 	
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
			}
		});
	}
}
