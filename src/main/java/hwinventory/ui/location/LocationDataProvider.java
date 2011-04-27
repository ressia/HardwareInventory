package hwinventory.ui.location;

import hwinventory.ui.application.HardwareInventoryApplication;

import java.util.Iterator;
import java.util.List;

import org.apache.wicket.Application;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

public class LocationDataProvider implements IDataProvider {
	
	
	List listLocation = ((HardwareInventoryApplication)Application.get()).getSystem().getHardwareInventoryDAO().getAllLocations();

	public Iterator iterator(final int first, final int count){
		return listLocation.iterator();
	}

	public int size(){
		return listLocation.size();
	}
	
	public IModel model(Object object){
		return new CompoundPropertyModel(object);
	}
		
	@Override
	public void detach() {		
	}
}
