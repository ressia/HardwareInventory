package hwinventory.ui.type;


import hwinventory.dao.HardwareInventoryDAO;
import hwinventory.domain.CategoryHardwareDevice;
import hwinventory.ui.application.HardwareInventoryApplication;
import hwinventory.ui.inventoryItem.AddInventoryItem;
import hwinventory.ui.webpage.SecureWebPage;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

public class AddType extends SecureWebPage {
	
	HardwareInventoryDAO aDAO = ((HardwareInventoryApplication)getApplication()).getSystem().getHardwareInventoryDAO();
		  
    public AddType() {
    	TypeDraft aTypeDraft = new TypeDraft();
   	    CompoundPropertyModel aTypeDraftModel = new CompoundPropertyModel(aTypeDraft);
    	Form form = new AddTypeForm("form", aTypeDraftModel);
    	add(form);
    	TextField typeName = new TextField("name");
    	typeName.setRequired(true);
    	IChoiceRenderer choiceRenderer = new IChoiceRenderer() {
    		public String getIdValue(Object object, int index) {
    				return object.toString();
    		}
    		public Object getDisplayValue(Object object) {
    				CategoryHardwareDevice category = (CategoryHardwareDevice) object;
    				return category.getNameCategory();
    		}
    	};
    	DropDownChoice categoryList = new DropDownChoice("category", aDAO.getAllCategories(), choiceRenderer);
    	categoryList.setRequired(true);
    	form.add(typeName);
    	form.add(categoryList);
    }	
    
    class AddTypeForm extends Form {
    	public AddTypeForm (String id, IModel model) { 
    		super(id, model);
    	}
    	
    	@Override 
    	public void onSubmit() { 		
    		TypeDraft aTypeDraftModel = (TypeDraft)getModelObject();
     		HardwareInventoryDAO aDAO = ((HardwareInventoryApplication)getApplication()).getSystem().getHardwareInventoryDAO();
     		try {
	     		aDAO.addType(aTypeDraftModel.getName(), aTypeDraftModel.getCategory());
	     		TypeView aTypeView = new TypeView();
	     		setResponsePage(aTypeView);
	    	} catch(Exception e) {
    			String errMsg = getLocalizer().getString(
    					"login.errors.invalidCredentials ", AddType.this,"Unable to add the type's hardware.");
    			error(errMsg);
    		}	
    	}
	}  
}