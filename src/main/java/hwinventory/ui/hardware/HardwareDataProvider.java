package hwinventory.ui.hardware;

import hwinventory.ui.application.HardwareInventoryApplication;

import java.util.Iterator;

import org.apache.wicket.Application;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

public class HardwareDataProvider implements IDataProvider {
		
		public HardwareDataProvider(){
		}
		
		public Iterator iterator(final int first, final int count){ 
			return ((HardwareInventoryApplication)Application.get()).getSystem().getHardwareInventoryDAO().getAllDevices().iterator();
		}
		 
		public int size(){
			return ((HardwareInventoryApplication)Application.get()).getSystem().getHardwareInventoryDAO().getAllDevices().size();
		}
		
		public IModel model(Object object){
			return new CompoundPropertyModel(object);
		}

		@Override
		public void detach() {			
		}
}
