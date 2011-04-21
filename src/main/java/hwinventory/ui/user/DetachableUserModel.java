package hwinventory.ui.user;

import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.ComponentDetachableModel;

import hwinventory.domain.InventoryAccess;
import hwinventory.domain.User;



public class DetachableUserModel extends LoadableDetachableModel {
	
	InventoryAccess anInventoryAccess = new InventoryAccess();
// Required minimal information to look up the book later
	private final Long id;
	// Adds "transient" modifier to prevent serialization
	private transient User aUser;
	
	public DetachableUserModel(User aUser) {
		this(aUser.getIdUser());
		this.aUser = aUser;
	}
	
	public DetachableUserModel(Long id) {
		if (id == 0) {
			throw new IllegalArgumentException();
		}
		this.id = id;
	}
	
	/**
	* Returns null to indicate there is no nested model
	*/
	public IModel getNestedModel() {
		return null;
	}
	
	/**
	* Uses the DAO to load the required Book object when the
	* model is attached to the request
	*/
	@Override
	protected void onAttach() {
		aUser = (User) anInventoryAccess.accessAnObjectLong("User", "idUser", id);
	}
	/**
	* Clear the reference to the contact when the model is
	* detached.
	*/
	@Override
	protected void onDetach() {
		aUser = null;
	}
	
	/**
	* Called after onAttach to return the detachable object.
	* @param component
	* The component asking for the object
	* @return The detachable object.
	*/
	protected Object onGetObject(Component component) {
		return aUser;
	}
	
	@Override
	protected Object load() {
		// TODO Auto-generated method stub
		return null;
	}
}
