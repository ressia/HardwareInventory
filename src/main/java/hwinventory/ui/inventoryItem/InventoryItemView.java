package hwinventory.ui.inventoryItem;


import hwinventory.ui.category.CategoryView;
import hwinventory.ui.hardware.HardwareView;
import hwinventory.ui.location.LocationView;
import hwinventory.ui.type.TypeView;
import hwinventory.ui.user.UserView;
import hwinventory.ui.webpage.SecureWebPage;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.data.DataView;

public class InventoryItemView extends SecureWebPage {

	public InventoryItemView() {
		FeedbackPanel feedback = new FeedbackPanel("feedback");
		add(feedback);
		final Form form = new Form("itemForm");
		final InventoryItemDataProvider dataProvider = new InventoryItemDataProvider();
		final DataView items = new InventoryItemDataView("items", dataProvider); 
		form.add(items); 
		form.add(new Button("addNewItem") {
			public void onSubmit() { 
				AddInventoryItem anAddItem = new AddInventoryItem();
				setResponsePage(anAddItem);
			} 
		});
		form.add(new Button("goUser") {
			public void onSubmit() {
				UserView aUserView = new UserView();
				setResponsePage(aUserView);
			}
		});
		form.add(new Button("goCategory") {
			public void onSubmit() {
				CategoryView aCategoryView = new CategoryView();
				setResponsePage(aCategoryView);
			}
		});
		form.add(new Button("goLocation") {
			public void onSubmit() {
				LocationView aLocationView = new LocationView();
				setResponsePage(aLocationView);
			}
		});	
		form.add(new Button("goType") {
			public void onSubmit() {
				TypeView aTypeView = new TypeView();
				setResponsePage(aTypeView);
			}
		});	
		form.add(new Button("goHardware") {
			public void onSubmit() {
				HardwareView aHardwareView = new HardwareView();
				setResponsePage(aHardwareView);
			}
		});	
		add(form);
	}
}	