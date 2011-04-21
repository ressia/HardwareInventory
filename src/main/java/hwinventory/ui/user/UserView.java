package hwinventory.ui.user;

import java.util.List;

import hwinventory.domain.InventoryAccess;
import hwinventory.ui.inventoryItem.InventoryItemView;
import hwinventory.ui.login.Login;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;


public class UserView extends WebPage {
	
	public UserView() {
		FeedbackPanel feedback = new FeedbackPanel("feedback");
		add(feedback);
		Form form = new Form("userForm");
		UserDataProvider aUserDataProvider = new UserDataProvider();
		final DataView users = new UserDataView("users", aUserDataProvider);
		form.add(users);
		form.add(new Button("addUser") {
			public void onSubmit() {
				AddUserPage anAddUserPage = new AddUserPage();
				setResponsePage(anAddUserPage);
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
