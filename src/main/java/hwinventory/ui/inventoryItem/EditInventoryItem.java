package hwinventory.ui.inventoryItem;

import org.apache.wicket.datetime.PatternDateConverter;
import org.apache.wicket.datetime.markup.html.form.DateTextField;
import org.apache.wicket.extensions.yui.calendar.DatePicker;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

import hwinventory.dao.HardwareInventoryDAO;
import hwinventory.domain.HardwareDevice;
import hwinventory.domain.InventoryItem;
import hwinventory.domain.LocationItemInventory;
import hwinventory.domain.User;
import hwinventory.ui.application.HardwareInventoryApplication;
import hwinventory.ui.webpage.SecureWebPage;

public final class EditInventoryItem extends SecureWebPage {
	
	public EditInventoryItem(final InventoryItem anItem) {
		final FeedbackPanel feedback = new FeedbackPanel("feedback");
		add(feedback);
		add(new EditItemForm("editItemForm", anItem));
	}

	public class EditItemForm extends Form {
		HardwareInventoryDAO aDAO = ((HardwareInventoryApplication) getApplication())
				.getSystem().getHardwareInventoryDAO();

		public EditItemForm(final String id, final InventoryItem anItem) {
			super(id, new CompoundPropertyModel(anItem));

			/**
			 * edited values
			 */
			IChoiceRenderer choiceRenderer = new IChoiceRenderer() {
				public String getIdValue(Object object, int index) {
					return object.toString();
				}

				public Object getDisplayValue(Object object) {
    				HardwareDevice device = (HardwareDevice) object;
    				return (device.getType().getNameType());
				}
			};
			DropDownChoice aDeviceList = new DropDownChoice("hardwareDevice", aDAO.getAllDevices(), choiceRenderer);
			add(aDeviceList);
			TextField aNameItem = new TextField("nameItem");
			add(aNameItem);
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
			add(aUserList);	
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
			add(aLocationList);	
					
	    	PropertyModel aInventoryDateModel = new PropertyModel(anItem,"inventoryDate");
	    	DateTextField aItemDate = new DateTextField("inventoryDate", aInventoryDateModel, new PatternDateConverter("MM/dd/yyyy",true));
	    	DatePicker datePicker = new DatePicker();
	        //datePicker.setShowOnFieldClick(true);
	    	aItemDate.add(datePicker);
	    	add(aItemDate);	 
	    
	    	TextField aPrice = new TextField("price");
			add(aPrice);		
	    	TextField aBudget = new TextField("budget");
			add(aBudget);			
	    	TextField aGuarantee = new TextField("guarantee");
			add(aGuarantee);
			
	    	PropertyModel aGuaranteeDateModel = new PropertyModel(anItem,"guaranteeDate");
	    	DateTextField aGuaranteeDate = new DateTextField("guaranteeDate", aGuaranteeDateModel, new PatternDateConverter("MM/dd/yyyy",true));
	    	DatePicker GuaranteeDatePicker = new DatePicker();
	        //datePicker.setShowOnFieldClick(true);
	        aGuaranteeDate.add(GuaranteeDatePicker);	
	    	add(aGuaranteeDate);	
	    	
	    	TextField aNote = new TextField("note");
	    	add(aNote);	 
		}

		@Override
		public void onSubmit() {
			InventoryItem anItemModel = (InventoryItem) getModelObject();
			HardwareInventoryDAO aDAO = ((HardwareInventoryApplication) getApplication())
					.getSystem().getHardwareInventoryDAO();
			try {
				aDAO.modifyInventoryItem(anItemModel);
				InventoryItemView anItemView = new InventoryItemView();
				setResponsePage(anItemView);
			} catch (Exception e) {
				String errMsg = getLocalizer().getString(
						"login.errors.invalidCredentials ", EditInventoryItem.this,
						"Unable to modify the inventory item.");
				error(errMsg);
			}
		}
	}
}
