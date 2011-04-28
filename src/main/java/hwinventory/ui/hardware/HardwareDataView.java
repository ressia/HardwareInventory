package hwinventory.ui.hardware;

import hwinventory.dao.HardwareInventoryDAO;
import hwinventory.domain.HardwareDevice;
import hwinventory.domain.User;
import hwinventory.ui.application.HardwareInventoryApplication;
import hwinventory.ui.user.EditUser;
import hwinventory.ui.user.UserDataView;
import hwinventory.ui.user.UserView;

import org.apache.wicket.Application;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;


public class HardwareDataView extends DataView {	
	
	private HardwareInventoryDAO aDAO = ((HardwareInventoryApplication)Application.get()).getSystem().getHardwareInventoryDAO();

		public HardwareDataView(String id, IDataProvider dataProvider) { 
			super(id, dataProvider);
		}
	
		protected void populateItem(final Item item) { 
			HardwareDevice aHardware = (HardwareDevice) item.getModelObject();
			item.setModel(new CompoundPropertyModel(aHardware));
			item.add(new Label("type.nameType"));
			item.add(new Label("diskSize"));
			item.add(new Label("memorySize"));
			item.add(new Label("ianNumber"));
			item.add(new Label("macAddress"));
			item.add(new Label("serialNumber"));
			item.add(new Label("ipAddress"));
			item.add(new Link("linkToDelete") {
				public void onClick() {
		    		HardwareDevice aHardware = (HardwareDevice) item.getModelObject();
		    		try {
		    			aDAO.removeHardwareDevice(aHardware); 	
		    			HardwareView aHardwareView = new HardwareView();
		    			setResponsePage(aHardwareView);
		    		} catch(Exception e) {
		    			String errMsg = getLocalizer().getString(
		    					"login.errors.invalidCredentials ", HardwareDataView.this,"Unable to delete Hardware.");
		    			error(errMsg);
		    		}
				}
			});
			item.add(new Link("linkToEdit") {
				public void onClick() {
					HardwareDevice aHardware = (HardwareDevice) item.getModelObject();
					EditHardware anEditHardware = new EditHardware(aHardware);
					setResponsePage(anEditHardware);
				}
			});
		}
}