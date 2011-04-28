package hwinventory.ui.type;

import hwinventory.ui.application.HardwareInventoryApplication;

import java.util.Iterator;

import org.apache.wicket.Application;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

public class TypeDataProvider implements IDataProvider {
		
		public TypeDataProvider(){
		}
		
		public Iterator iterator(final int first, final int count){ 
			return ((HardwareInventoryApplication)Application.get()).getSystem().getHardwareInventoryDAO().getAllTypes().iterator();
		}
		 
		public int size(){
			return ((HardwareInventoryApplication)Application.get()).getSystem().getHardwareInventoryDAO().getAllTypes().size();
		}
		
		public IModel model(Object object){
			return new CompoundPropertyModel(object);
		}

		@Override
		public void detach() {			
		}
	
}
