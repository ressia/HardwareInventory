package hwinventory.ui.user;

import hwinventory.domain.InventoryAccess;
import hwinventory.domain.User;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

public class AddUserPage extends WebPage {
	
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
    		InventoryAccess anInventoryAccess = new InventoryAccess();
    		anInventoryAccess.addUser(aUserDraftModel.getName());
    		MessagePage messagePage = new MessagePage();
    		setResponsePage(messagePage);
    	}
	}
    
}
