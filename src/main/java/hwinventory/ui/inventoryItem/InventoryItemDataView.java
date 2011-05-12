package hwinventory.ui.inventoryItem;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
			SimpleDateFormat aDateFormat = new SimpleDateFormat("MM-dd-yyyy");
			item.setModel(new CompoundPropertyModel(anInventoryItem));
			item.add(new Label("hardwareDevice.type.nameType"));
			item.add(new Label("hardwareDevice.diskSize"));
			item.add(new Label("hardwareDevice.memorySize"));
			item.add(new Label("hardwareDevice.ianNumber"));
			item.add(new Label("hardwareDevice.macAddress"));
			item.add(new Label("hardwareDevice.serialNumber"));
			item.add(new Label("hardwareDevice.ipAddress"));
			item.add(new Label("scgNumber"));
			item.add(new Label("nameItem"));
			item.add(new Label("user.nameUser"));
			item.add(new Label("location.nameLocation"));
			String aDate = null;
			if (anInventoryItem.getInventoryDate() != null) { 
				aDate = aDateFormat.format(anInventoryItem.getInventoryDate().getTime()); 
			} else {
				aDate = "";
			}
			item.add(new Label("inventoryDate", aDate ));			
			item.add(new Label("price"));
			item.add(new Label("budget"));
			aDate = null;
			if (anInventoryItem.getGuaranteeEnd() != null) { 
				aDate = aDateFormat.format(anInventoryItem.getGuaranteeEnd().getTime()); 
			} else {
				aDate = "";
			}
			item.add(new Label("guaranteeEnd", aDate ));
			item.add(new Label("guarantee"));
			item.add(new Label("note"));
		}
}