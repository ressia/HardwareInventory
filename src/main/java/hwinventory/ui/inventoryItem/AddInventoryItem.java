package hwinventory.ui.inventoryItem;

import hwinventory.dao.HardwareInventoryDAO;
import hwinventory.domain.HardwareDevice;
import hwinventory.domain.LocationItemInventory;
import hwinventory.domain.User;
import hwinventory.ui.application.HardwareInventoryApplication;
import hwinventory.ui.webpage.SecureWebPage;

import org.apache.wicket.datetime.PatternDateConverter;
import org.apache.wicket.datetime.markup.html.form.DateTextField;
import org.apache.wicket.extensions.yui.calendar.DatePicker;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

public class AddInventoryItem extends SecureWebPage {
	
	HardwareInventoryDAO aDAO = ((HardwareInventoryApplication)getApplication()).getSystem().getHardwareInventoryDAO();
		  
    public AddInventoryItem() {
    	InventoryItemDraft aInventoryItemDraft = new InventoryItemDraft();
   	    CompoundPropertyModel aInventoryItemDraftModel = new CompoundPropertyModel(aInventoryItemDraft);
		FeedbackPanel feedback = new FeedbackPanel("feedback");
		add(feedback);
    	Form form = new AddInventoryItemForm("form", aInventoryItemDraftModel);
    	add(form);
    	IChoiceRenderer choiceRendererDevice = new IChoiceRenderer() {
    		public String getIdValue(Object object, int index) {
    				return object.toString();
    		}
    		public Object getDisplayValue(Object object) {
    				HardwareDevice device = (HardwareDevice) object;
    				return (device.getType().getNameType());
    		}
    	};
    	DropDownChoice aDeviceList = new DropDownChoice("hardwareDevice", aDAO.getAllDevices(), choiceRendererDevice);
    	aDeviceList.setRequired(true);
    	form.add(aDeviceList);
       	TextField aScgNumber = new TextField("scgNumber");
    	aScgNumber.setRequired(true);
    	form.add(aScgNumber);
     	TextField aNameItem = new TextField("nameItem");
    	form.add(aNameItem);
    	IChoiceRenderer choiceRendererUser = new IChoiceRenderer() {
    		public String getIdValue(Object object, int index) {
    				return object.toString();
    		}
    		public Object getDisplayValue(Object object) {
    				User aUser = (User) object;
    				return aUser.getNameUser();
    		}
    	};
    	DropDownChoice aUserList = new DropDownChoice("user", aDAO.getAllUsers(), choiceRendererUser);
    	aUserList.setRequired(true);
    	form.add(aUserList);
    	IChoiceRenderer choiceRendererLocation = new IChoiceRenderer() {
    		public String getIdValue(Object object, int index) {
    				return object.toString();
    		}
    		public Object getDisplayValue(Object object) {
    				LocationItemInventory aLocation = (LocationItemInventory) object;
    				return aLocation.getNameLocation();
    		}
    	};
    	DropDownChoice aLocationList = new DropDownChoice("location", aDAO.getAllLocations(), choiceRendererLocation);
    	aLocationList.setRequired(true);
    	form.add(aLocationList);
    	PropertyModel aInventoryDateModel = new PropertyModel(aInventoryItemDraft,"inventoryDate");
    	DateTextField aItemDate = new DateTextField("inventoryDate", aInventoryDateModel, new PatternDateConverter("MM/dd/yyyy",true));
    	aItemDate.setRequired(true);
    	DatePicker datePicker = new DatePicker();
        //datePicker.setShowOnFieldClick(true);
        aItemDate.add(datePicker);
    	form.add(aItemDate);
    	TextField aPrice = new TextField("price");
    	form.add(aPrice);
    	TextField aBudget = new TextField("budget");
    	form.add(aBudget);
    	TextField aGuarantee = new TextField("guarantee");
    	form.add(aGuarantee);
     	PropertyModel aGuaranteeDateModel = new PropertyModel(aInventoryItemDraft,"guaranteeDate");
    	DateTextField aGuaranteeDate = new DateTextField("guaranteeDate", aGuaranteeDateModel, new PatternDateConverter("MM/dd/yyyy",true));
    	DatePicker dateGuaranteePicker = new DatePicker();
        //dateGuaranteePicker.setShowOnFieldClick(true);
        aGuaranteeDate.add(dateGuaranteePicker);
    	form.add(aGuaranteeDate);    	
    	TextField aNote = new TextField("note");
    	form.add(aNote);
    }	
        
    class AddInventoryItemForm extends Form {
    	public AddInventoryItemForm (String id, IModel model) { 
    		super(id, model);
    	}
    	
    	@Override 
    	public void onSubmit() { 		
    		InventoryItemDraft anItemDraftModel = (InventoryItemDraft)getModelObject();
     		HardwareInventoryDAO aDAO = ((HardwareInventoryApplication)getApplication()).getSystem().getHardwareInventoryDAO();
     		try {
	     		aDAO.addInventoryItem(anItemDraftModel.getHardwareDevice()
	     				, anItemDraftModel.getScgNumber()
	     				, anItemDraftModel.getNameItem()
	     				, anItemDraftModel.getUser()
	     				, anItemDraftModel.getLocation()
	     				, anItemDraftModel.getInventoryDateCalendar()
	     				, anItemDraftModel.getPrice()
	     				, anItemDraftModel.getBudget()
	     				, anItemDraftModel.getGuarantee()
	     				, anItemDraftModel.getGuaranteeDateCalendar()
	     				, anItemDraftModel.getNote());
	     		InventoryItemView aInventoryItemView = new InventoryItemView();
	     		setResponsePage(aInventoryItemView);
	    	} catch(Exception e) {
    			String errMsg = getLocalizer().getString(
    					"login.errors.invalidCredentials ", AddInventoryItem.this,"Unable to add an item.");
    			error(errMsg);
    		}
    	}	
	}  
}