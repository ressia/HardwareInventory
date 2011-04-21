package hwinventory.ui.inventoryItem;

import hwinventory.domain.InventoryItem;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;

public class InventoryItemDataView extends DataView {	
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