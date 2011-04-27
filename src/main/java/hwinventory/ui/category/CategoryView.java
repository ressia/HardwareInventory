package hwinventory.ui.category;

import hwinventory.ui.inventoryItem.InventoryItemView;
import hwinventory.ui.webpage.SecureWebPage;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.data.DataView;


public class CategoryView extends SecureWebPage {
	
	public CategoryView() {
		FeedbackPanel feedback = new FeedbackPanel("feedback");
		add(feedback);
		Form form = new Form("categoryForm");
		CategoryDataProvider aCategoryDataProvider = new CategoryDataProvider();
		final DataView categories = new CategoryDataView("categories", aCategoryDataProvider);
		form.add(categories);
		form.add(new Button("addCategory") {
			public void onSubmit() {
				AddCategory anAddCategory = new AddCategory();
				setResponsePage(anAddCategory);
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
