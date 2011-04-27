package hwinventory.ui.location;

import hwinventory.dao.HardwareInventoryDAO;
import hwinventory.domain.LocationItemInventory;
import hwinventory.ui.application.HardwareInventoryApplication;

import org.apache.wicket.Application;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;

public class LocationDataView extends DataView{

	
	private HardwareInventoryDAO aDAO = ((HardwareInventoryApplication)Application.get()).getSystem().getHardwareInventoryDAO();
	
	public LocationDataView(String id, IDataProvider aLocationDataProvider) {
		super(id, aLocationDataProvider);
	}
	
	protected void populateItem(final Item item) {
		LocationItemInventory aLocation = (LocationItemInventory) item.getModelObject();
		item.setModel(new CompoundPropertyModel(aLocation));
		item.add(new Label("nameLocation"));
		item.add(new Link("linkToDelete") {
			public void onClick() {
	    		LocationItemInventory aLocation = (LocationItemInventory)item.getModelObject();
	    		try {
	    			aDAO.removeLocation(aLocation); 	
		    		LocationView aLocationView = new LocationView(); 
					setResponsePage(aLocationView);
	    		} catch(Exception e) {
	    			String errMsg = getLocalizer().getString(
	    					"login.errors.invalidCredentials ", LocationDataView.this,"Unable to delete Location.");
	    			error(errMsg);
	    		}
			}
		});
		item.add(new Link("linkToEdit") {
			public void onClick() {
				LocationItemInventory aLocation = (LocationItemInventory) item.getModelObject();
				EditLocation aEditLocation = new EditLocation(aLocation);
				setResponsePage(aEditLocation);
			}
		});
	}
}
