package hwinventory.ui.inventoryItem;


import hwinventory.ui.user.UserView;
import hwinventory.ui.webpage.SecureWebPage;


import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.repeater.data.DataView;

public class InventoryItemView extends SecureWebPage {

	public InventoryItemView() {
		final Form form = new Form("itemForm"); 
		final InventoryItemDataProvider dataProvider = new InventoryItemDataProvider();

		final DataView items = new InventoryItemDataView("items", dataProvider); 
		form.add(items); 
		form.add(new Button("addNewItem") {
			public void onSubmit() { 
				System.out.println("Need to implement add new inventory item!!");
			} 
		});
		form.add(new Button("goUser") {
			public void onSubmit() {
				UserView aViewUserPage = new UserView();
				setResponsePage(aViewUserPage);
			}
		});
		add(form);
	}
}	