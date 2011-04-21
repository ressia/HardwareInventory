package hwinventory.ui.user;

import hwinventory.ui.UserDraft;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;

class UserDataView extends DataView{
	public UserDataView(String id, UserDataProvider aUserDataProvider) {
	super(id, aUserDataProvider);
	}
	
	// DataView calls this method for populating the table rows.

	protected void populateItem(final Item item) {
	UserDraft aUserDraft = (UserDraft) item.getModelObject();
	item.setModel(new CompoundPropertyModel(aUserDraft));
	item.add(new Label("name"));
	item.add(new CheckBox("selected",new Model("")));
	}
}
