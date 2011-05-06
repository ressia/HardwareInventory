package hwinventory.ui.category;

import hwinventory.dao.HardwareInventoryDAO;
import hwinventory.ui.application.HardwareInventoryApplication;
import hwinventory.ui.inventoryItem.AddInventoryItem;
import hwinventory.ui.webpage.SecureWebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

public class AddCategory extends SecureWebPage {
	
    public AddCategory() {
    	CategoryDraft aCategoryDraft = new CategoryDraft();
    	CompoundPropertyModel aCategoryDraftModel = new CompoundPropertyModel(aCategoryDraft);
    	Form form = new AddCategoryForm("form", aCategoryDraftModel);
    	add(form);
    	TextField categoryName = new TextField("name");
    	categoryName.setRequired(true);
    	form.add(categoryName);
    }
    
    class AddCategoryForm extends Form {
    	// PropertyModel is an IModel implementation 
    	public AddCategoryForm (String id, IModel model) { 
    		super(id, model);
    	}
    	
    	@Override 
    	public void onSubmit() {
    		CategoryDraft aCategoryDraftModel = (CategoryDraft)getModelObject();
    		HardwareInventoryDAO aDAO = ((HardwareInventoryApplication)getApplication()).getSystem().getHardwareInventoryDAO();
    		try {
	    		aDAO.addCategory(aCategoryDraftModel.getName());
	    		CategoryView aCategoryView = new CategoryView();
	    		setResponsePage(aCategoryView);
	    	} catch(Exception e) {
    			String errMsg = getLocalizer().getString(
    					"login.errors.invalidCredentials ", AddCategory.this,"Unable to add an item.");
    			error(errMsg);
    		}
    	}
	}
    
}
