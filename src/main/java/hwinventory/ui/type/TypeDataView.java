package hwinventory.ui.type;

import hwinventory.dao.HardwareInventoryDAO;
import hwinventory.domain.TypeHardwareDevice;
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


public class TypeDataView extends DataView {	
	
	private HardwareInventoryDAO aDAO = ((HardwareInventoryApplication)Application.get()).getSystem().getHardwareInventoryDAO();

		public TypeDataView(String id, IDataProvider dataProvider) { 
			super(id, dataProvider);
		}
	
		protected void populateItem(final Item item) { 
			TypeHardwareDevice aType = (TypeHardwareDevice) item.getModelObject();
			item.setModel(new CompoundPropertyModel(aType));
			item.add(new Label("nameType"));
			item.add(new Label("category.nameCategory"));
			item.add(new Link("linkToDelete") {
				public void onClick() {
		    		TypeHardwareDevice aType = (TypeHardwareDevice) item.getModelObject();
		    		try {
		    			aDAO.removeType(aType); 	
		    			TypeView aTypeView = new TypeView();
		    			setResponsePage(aTypeView);
		    		} catch(Exception e) {
		    			String errMsg = getLocalizer().getString(
		    					"login.errors.invalidCredentials ", TypeDataView.this,"Unable to delete type.");
		    			error(errMsg);
		    		}
				}
			});
			item.add(new Link("linkToEdit") {
				public void onClick() {
					TypeHardwareDevice aType = (TypeHardwareDevice) item.getModelObject();
					EditType anEditType = new EditType(aType);
					setResponsePage(anEditType);
				}
			});
		}
}