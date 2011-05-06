package hwinventory.ui.inventoryItem;

import java.util.Calendar;
import java.util.GregorianCalendar;

import hwinventory.dao.HardwareInventoryDAO;
import hwinventory.domain.HardwareDevice;
import hwinventory.domain.LocationItemInventory;
import hwinventory.domain.User;
import hwinventory.ui.application.HardwareInventoryApplication;
import hwinventory.ui.webpage.SecureWebPage;

import org.apache.wicket.extensions.yui.calendar.DatePicker;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.hibernate.type.CalendarType;

import sun.util.resources.CalendarData;

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
    	DropDownChoice aDeviceList = new DropDownChoice("hardwareDevice", aInventoryItemDraftModel, aDAO.getAllDevices(), choiceRendererDevice);
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
     	TextField aItemDate = new TextField("inventoryDate");
    	aItemDate.setRequired(true);
    	aItemDate.add(new DatePicker());
    	form.add(aItemDate);
    	TextField aPrice = new TextField("price");
    	form.add(aPrice);
    	TextField aBudget = new TextField("budget");
    	form.add(aBudget);
    	TextField aGuarantee = new TextField("guarantee");
    	form.add(aGuarantee);
    	TextField aGuaranteeDate = new TextField("guaranteeDate");
    	aGuaranteeDate.add(new DatePicker());
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
	     		aDAO.addInventoryItem(anItemDraftModel.getHardwareDevice(), anItemDraftModel.getScgNumber()
	     				, anItemDraftModel.getNameItem(), anItemDraftModel.getUser()
	     				, anItemDraftModel.getLocation(), anItemDraftModel.getInventoryDate()
	     				, anItemDraftModel.getPrice(), anItemDraftModel.getBudget()
	     				, anItemDraftModel.getGuarantee(), anItemDraftModel.getGuaranteeDate()
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