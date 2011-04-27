package hwinventory.ui.location;

import hwinventory.ui.inventoryItem.InventoryItemView;
import hwinventory.ui.webpage.SecureWebPage;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.data.DataView;


public class LocationView extends SecureWebPage {
	
	public LocationView() {
		FeedbackPanel feedback = new FeedbackPanel("feedback");
		add(feedback);
		Form form = new Form("locationForm");
		LocationDataProvider aLocationDataProvider = new LocationDataProvider();
		final DataView locations = new LocationDataView("locations", aLocationDataProvider);
		form.add(locations);
		form.add(new Button("addLocation") {
			public void onSubmit() {
				AddLocation anAddLocation = new AddLocation();
				setResponsePage(anAddLocation);
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
