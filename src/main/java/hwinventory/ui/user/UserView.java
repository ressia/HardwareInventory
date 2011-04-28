package hwinventory.ui.user;

import hwinventory.ui.inventoryItem.InventoryItemView;
import hwinventory.ui.webpage.SecureWebPage;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.data.DataView;


public class UserView extends SecureWebPage {
	
	public UserView() {
		FeedbackPanel feedback = new FeedbackPanel("feedback");
		add(feedback);
		Form form = new Form("userForm");
		UserDataProvider aUserDataProvider = new UserDataProvider();
		final DataView users = new UserDataView("users", aUserDataProvider);
		form.add(users);
		form.add(new Button("addUser") {
			public void onSubmit() {
				AddUser anAddUser = new AddUser();
				setResponsePage(anAddUser);
			}
		});
		form.add(new Button("backItem") {
			public void onSubmit() {
				InventoryItemView aInventoryItemView = new InventoryItemView();  
				setResponsePage(aInventoryItemView);
				}
		});
		add(form);
	 }	
}
