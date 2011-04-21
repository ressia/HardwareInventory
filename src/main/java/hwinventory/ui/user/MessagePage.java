package hwinventory.ui.user;

import hwinventory.ui.inventoryItem.InventoryItemView;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.repeater.data.DataView;

public class MessagePage extends WebPage {
	public MessagePage(){
		Form form = new Form("msgForm");
		form.add(new Label("message","User added"));
		form.add(new Button("backUser") {
			public void onSubmit() {
				UserView aUserView = new UserView();
				setResponsePage(aUserView);
			}
		});
		add(form);
	}
}