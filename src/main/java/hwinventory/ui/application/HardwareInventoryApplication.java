package hwinventory.ui.application;

import hwinventory.dao.InventoryAccess;
import hwinventory.dao.NotPersistentDAO;
import hwinventory.system.HardwareInventorySystem;
import hwinventory.ui.inventoryItem.InventoryItemView;
import hwinventory.ui.login.Login;
import hwinventory.ui.session.HardwareInventorySession;
import hwinventory.ui.user.AddUser;
import hwinventory.ui.user.UserView;

import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;

public class HardwareInventoryApplication extends WebApplication {
	
	private HardwareInventorySystem aSystem;

	public HardwareInventoryApplication() {
		aSystem = new HardwareInventorySystem(new InventoryAccess());
		//aSystem = new HardwareInventorySystem(new NotPersistentDAO());
	}
	
	public void init(){
		super.init();
		//mount("/pages", PackageName.forPackage(Login.class.getPackage()));
		mountBookmarkablePage("/login", Login.class); 
		mountBookmarkablePage("/inventoryItem", InventoryItemView.class);
		mountBookmarkablePage("/userView", UserView.class);
		mountBookmarkablePage("/addUser", AddUser.class);
	}
	
	public Session newSession(Request request, Response response) {
		return new HardwareInventorySession(request);
	}
	
	public Class getHomePage(){ 
		return Login.class;
	}
	
	public HardwareInventorySystem getSystem() {
		return aSystem;
	}
}
