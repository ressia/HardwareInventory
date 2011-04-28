package hwinventory.ui.hardware;


import hwinventory.ui.inventoryItem.InventoryItemView;
import hwinventory.ui.webpage.SecureWebPage;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.data.DataView;

public class HardwareView extends SecureWebPage {

	public HardwareView() {
		FeedbackPanel feedback = new FeedbackPanel("feedback");
		add(feedback);
		Form form = new Form("hardwareForm"); 
		HardwareDataProvider dataProvider = new HardwareDataProvider();
		final DataView Devices = new HardwareDataView("devices", dataProvider); 
		form.add(Devices); 
		form.add(new Button("addNewHardware") {
			public void onSubmit() { 
				AddHardware anAddHardware = new AddHardware();
				setResponsePage(anAddHardware);
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