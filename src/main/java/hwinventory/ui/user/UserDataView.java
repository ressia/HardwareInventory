package hwinventory.ui.user;

import hwinventory.domain.User;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;

public class UserDataView extends DataView{

	public UserDataView(String id, IDataProvider aUserDataProvider) {
		super(id, aUserDataProvider);
	}
	
	// DataView calls this method for populating the table rows.

	protected void populateItem(final Item item) {
		User aUser = (User) item.getModelObject();
		item.setModel(new CompoundPropertyModel(aUser));
		item.add(new Label("nameUser"));
	}
}
