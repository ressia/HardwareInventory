package hwinventory.ui.user;

import java.util.List;

import hwinventory.domain.InventoryAccess;
import hwinventory.ui.UserDraft;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;


public class ViewUserPage extends WebPage {
	
	public ViewUserPage()
	    {
		Form form = new Form("userForm");
		UserDataProvider aUserDataProvider = new UserDataProvider();
		final DataView users = new UserDataView("users", aUserDataProvider);
		form.add(users);
		form.add(new Button("addUser") {
			public void onSubmit() {
				System.out.println("Need to implement add user");
			}
		});
		add(form);
	 }	
}
