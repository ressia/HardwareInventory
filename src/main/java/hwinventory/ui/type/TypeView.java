package hwinventory.ui.type;


import hwinventory.ui.inventoryItem.InventoryItemView;
import hwinventory.ui.webpage.SecureWebPage;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.data.DataView;

public class TypeView extends SecureWebPage {

	public TypeView() {
		FeedbackPanel feedback = new FeedbackPanel("feedback");
		add(feedback);
		Form form = new Form("typeForm"); 
		TypeDataProvider dataProvider = new TypeDataProvider();
		final DataView types = new TypeDataView("types", dataProvider); 
		form.add(types); 
		form.add(new Button("addNewType") {
			public void onSubmit() { 
				AddType anAddType = new AddType();
				setResponsePage(anAddType);
			} 
		});
		form.add(new Button("backItem") {
			public void onSubmit() { 
				InventoryItemView anInventoryItemView = new InventoryItemView();
				setResponsePage(anInventoryItemView);
			}
		});	
		add(form);
	}
}	