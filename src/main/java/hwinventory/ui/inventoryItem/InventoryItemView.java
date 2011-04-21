package hwinventory.ui.inventoryItem;

import hwinventory.domain.InventoryItem;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;

public class InventoryItemView extends WebPage {

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
		add(form);
	}
	
	class InventoryItemDataView extends DataView{
	
		public InventoryItemDataView(String id, IDataProvider dataProvider) { 
			super(id, dataProvider);
		}
	
		protected void populateItem(final Item item) { 
			InventoryItem anInventoryItem = (InventoryItem) item.getModelObject(); 
			item.setModel(new CompoundPropertyModel(anInventoryItem));
			item.add(new Label("scgNumber")); 
			item.add(new Label("nameItem")); 
		}
	}
}
