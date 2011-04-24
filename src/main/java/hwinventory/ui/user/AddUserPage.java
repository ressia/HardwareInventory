package hwinventory.ui.user;

import hwinventory.dao.HardwareInventoryDAO;
import hwinventory.ui.application.HardwareInventoryApplication;
import hwinventory.ui.webpage.SecureWebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

public class AddUserPage extends SecureWebPage {
	
    public AddUserPage() {
    	UserDraft aUserDraft = new UserDraft();
    	CompoundPropertyModel aUserDraftModel = new CompoundPropertyModel(aUserDraft);
    	Form form = new AddUserForm("form",aUserDraftModel);
    	add(form);
    	TextField userName = new TextField("name");
    	form.add(userName);
    }
    
    class AddUserForm extends Form {
    	// PropertyModel is an IModel implementation 
    	public AddUserForm (String id,IModel model) {
    		super(id,model);
    	}
    	
    	@Override 
    	public void onSubmit() {
    		UserDraft aUserDraftModel = (UserDraft)getModelObject();
    		HardwareInventoryDAO aDAO = ((HardwareInventoryApplication)getApplication()).getSystem().getHardwareInventoryDAO();
    		aDAO.addUser(aUserDraftModel.getName());
    		MessagePage messagePage = new MessagePage();
    		setResponsePage(messagePage);
    	}
	}
    
}
