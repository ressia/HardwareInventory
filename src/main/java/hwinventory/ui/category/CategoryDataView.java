package hwinventory.ui.category;

import hwinventory.dao.HardwareInventoryDAO;
import hwinventory.domain.CategoryHardwareDevice;
import hwinventory.ui.application.HardwareInventoryApplication;

import org.apache.wicket.Application;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;

public class CategoryDataView extends DataView{

	
	private HardwareInventoryDAO aDAO = ((HardwareInventoryApplication)Application.get()).getSystem().getHardwareInventoryDAO();
	
	public CategoryDataView(String id, IDataProvider aCategoryDataProvider) {
		super(id, aCategoryDataProvider);
	}
	
	protected void populateItem(final Item item) {
		CategoryHardwareDevice aCategory = (CategoryHardwareDevice) item.getModelObject();
		item.setModel(new CompoundPropertyModel(aCategory));
		item.add(new Label("nameCategory"));
		item.add(new Link("linkToDelete") {
			public void onClick() {
	    		CategoryHardwareDevice aCategory = (CategoryHardwareDevice)item.getModelObject();
	    		try {
	    			aDAO.removeCategory(aCategory); 	
		    		CategoryView aCategoryView = new CategoryView(); 
					setResponsePage(aCategoryView);
	    		} catch(Exception e) {
	    			String errMsg = getLocalizer().getString(
	    					"login.errors.invalidCredentials ", CategoryDataView.this,"Unable to delete category.");
	    			error(errMsg);
	    		}
			}
		});
		item.add(new Link("linkToEdit") {
			public void onClick() {
				CategoryHardwareDevice aCategory = (CategoryHardwareDevice) item.getModelObject();
				EditCategory aEditCategory = new EditCategory(aCategory);
				setResponsePage(aEditCategory);
			}
		});
	}
}
