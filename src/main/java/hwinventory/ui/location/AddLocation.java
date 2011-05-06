package hwinventory.ui.location;

import hwinventory.dao.HardwareInventoryDAO;
import hwinventory.ui.application.HardwareInventoryApplication;
import hwinventory.ui.inventoryItem.AddInventoryItem;
import hwinventory.ui.webpage.SecureWebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

public class AddLocation extends SecureWebPage {
	
    public AddLocation() {
    	LocationDraft aLocationDraft = new LocationDraft();
    	CompoundPropertyModel aLocationDraftModel = new CompoundPropertyModel(aLocationDraft);
    	Form form = new AddLocationForm("form", aLocationDraftModel);
    	add(form);
    	TextField locationName = new TextField("name");
    	locationName.setRequired(true);
    	form.add(locationName);
    }
    
    class AddLocationForm extends Form {
    	// PropertyModel is an IModel implementation 
    	public AddLocationForm (String id, IModel model) { 
    		super(id, model);
    	}
    	
    	@Override 
    	public void onSubmit() {
    		LocationDraft aLocationDraftModel = (LocationDraft)getModelObject();
    		HardwareInventoryDAO aDAO = ((HardwareInventoryApplication)getApplication()).getSystem().getHardwareInventoryDAO();
    		try {
	    		aDAO.addLocation(aLocationDraftModel.getName());
	    		LocationView aLocationView = new LocationView();
	    		setResponsePage(aLocationView);
	    	} catch(Exception e) {
    			String errMsg = getLocalizer().getString(
    					"login.errors.invalidCredentials ", AddLocation.this,"Unable to add the location.");
    			error(errMsg);
    		}

    	}
	}
    
}
