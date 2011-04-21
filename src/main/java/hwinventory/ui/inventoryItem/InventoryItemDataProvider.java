package hwinventory.ui.inventoryItem;

import hwinventory.domain.InventoryAccess;

import java.util.Iterator;

import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

public class InventoryItemDataProvider implements IDataProvider {
		
		public InventoryItemDataProvider(){
		}
		
		public Iterator iterator(final int first, final int count){ 
			return (new InventoryAccess()).getAllItems().iterator();
		}
		 
		public int size(){
			return (new InventoryAccess()).getAllItems().size();
		}
		
		public IModel model(Object object){
			return new CompoundPropertyModel(object);
		}

		@Override
		public void detach() {			
		}
	
}
