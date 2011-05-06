package hwinventory.ui.hardware;


import hwinventory.dao.HardwareInventoryDAO;
import hwinventory.domain.TypeHardwareDevice;
import hwinventory.ui.application.HardwareInventoryApplication;
import hwinventory.ui.inventoryItem.AddInventoryItem;
import hwinventory.ui.webpage.SecureWebPage;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

public class AddHardware extends SecureWebPage {
	
	HardwareInventoryDAO aDAO = ((HardwareInventoryApplication)getApplication()).getSystem().getHardwareInventoryDAO();
		  
    public AddHardware() {
    	HardwareDraft aHardwareDraft = new HardwareDraft();
   	    CompoundPropertyModel aHardwareDraftModel = new CompoundPropertyModel(aHardwareDraft);
    	Form form = new AddHardwareForm("form", aHardwareDraftModel);
    	add(form);
    	IChoiceRenderer choiceRenderer = new IChoiceRenderer() {
    		public String getIdValue(Object object, int index) {
    				return object.toString();
    		}
    		public Object getDisplayValue(Object object) {
    				TypeHardwareDevice type = (TypeHardwareDevice) object;
					return type.getNameType();
    		}
    	};
    	DropDownChoice typeList = new DropDownChoice("type", aDAO.getAllTypes(), choiceRenderer);
    	typeList.setRequired(true);
      	form.add(typeList);
     	TextField aDisk = new TextField("diskSize");
       	aDisk.setRequired(true);
    	form.add(aDisk);
     	TextField aMemory = new TextField("memorySize");
       	aMemory.setRequired(true);
       	form.add(aMemory);
     	TextField anIam = new TextField("ianNumber");
    	anIam.setRequired(true);   
       	form.add(anIam);
     	TextField aMac = new TextField("macAddress");
    	aMac.setRequired(true);
    	form.add(aMac);
     	TextField aSerial = new TextField("serialNumber");
    	aSerial.setRequired(true);
       	form.add(aSerial);
     	TextField anIp = new TextField("ipAddress");     	
    	anIp.setRequired(true);
    	form.add(anIp);
    }	
    
    class AddHardwareForm extends Form {
    	public AddHardwareForm (String id, IModel model) { 
    		super(id, model);
    	}
    	
    	@Override 
    	public void onSubmit() { 		
    		HardwareDraft aHardwareDraftModel = (HardwareDraft)getModelObject();
     		HardwareInventoryDAO aDAO = ((HardwareInventoryApplication)getApplication()).getSystem().getHardwareInventoryDAO();
     		try {
	     		aDAO.addHardwareDevice(aHardwareDraftModel.getType(), aHardwareDraftModel.getDiskSize(), aHardwareDraftModel.getMemorySize()
	     				,aHardwareDraftModel.getIanNumber(), aHardwareDraftModel.getMacAddress(), aHardwareDraftModel.getSerialNumber()
	     				,aHardwareDraftModel.getIpAddress());
	     		HardwareView aHardwareView = new HardwareView();
	     		setResponsePage(aHardwareView);
	    	} catch(Exception e) {
    			String errMsg = getLocalizer().getString(
    					"login.errors.invalidCredentials ", AddHardware.this,"Unable to add the hardware device.");
    			error(errMsg);
    		}	
    	}
	}  
}