package hwinventory.ui.user;

import hwinventory.dao.HardwareInventoryDAO;
import hwinventory.ui.application.HardwareInventoryApplication;
import hwinventory.ui.inventoryItem.AddInventoryItem;
import hwinventory.ui.webpage.SecureWebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

public class AddUser extends SecureWebPage {
	
    public AddUser() {
    	UserDraft aUserDraft = new UserDraft();
    	CompoundPropertyModel aUserDraftModel = new CompoundPropertyModel(aUserDraft);
    	Form form = new AddUserForm("form", aUserDraftModel);
    	add(form);
    	TextField userName = new TextField("name");
    	userName.setRequired(true);
    	form.add(userName);
    }
    
    class AddUserForm extends Form {
    	// PropertyModel is an IModel implementation 
    	public AddUserForm (String id, IModel model) { 
    		super(id, model);
    	}
    	
    	@Override 
    	public void onSubmit() {
    		UserDraft aUserDraftModel = (UserDraft)getModelObject();
    		HardwareInventoryDAO aDAO = ((HardwareInventoryApplication)getApplication()).getSystem().getHardwareInventoryDAO();
    		try {
	    		aDAO.addUser(aUserDraftModel.getName());
	    		UserView aUserView = new UserView();
	    		setResponsePage(aUserView);
	    	} catch(Exception e) {
    			String errMsg = getLocalizer().getString(
    					"login.errors.invalidCredentials ", AddUser.this,"Unable to add the user.");
    			error(errMsg);
    		}	    		
    	}
	}
    
}
