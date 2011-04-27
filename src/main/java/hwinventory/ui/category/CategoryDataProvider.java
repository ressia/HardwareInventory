package hwinventory.ui.category;

import hwinventory.ui.application.HardwareInventoryApplication;

import java.util.Iterator;
import java.util.List;

import org.apache.wicket.Application;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

public class CategoryDataProvider implements IDataProvider {
	
	
	List listCategory = ((HardwareInventoryApplication)Application.get()).getSystem().getHardwareInventoryDAO().getAllCategories();

	public Iterator iterator(final int first, final int count){
		return listCategory.iterator();
	}

	public int size(){
		return listCategory.size();
	}
	
	public IModel model(Object object){
		return new CompoundPropertyModel(object);
	}
		
	@Override
	public void detach() {		
	}
}
