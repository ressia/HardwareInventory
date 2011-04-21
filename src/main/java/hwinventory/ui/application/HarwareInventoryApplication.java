package hwinventory.ui.application;

import hwinventory.ui.inventoryItem.InventoryItemView;
import hwinventory.ui.login.Login;
import hwinventory.ui.session.HardwareInventorySession;

import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;

public class HarwareInventoryApplication extends WebApplication {
	
	public HarwareInventoryApplication() {
	}
	
	public void init(){
		super.init();
		//mount("/pages", PackageName.forPackage(Login.class.getPackage()));
		mountBookmarkablePage("/login", Login.class); 
		mountBookmarkablePage("/inventoryItem", InventoryItemView.class);
	}

	
	public Session newSession(Request request, Response response) {
		return new HardwareInventorySession(request);
	}
	
	public Class getHomePage(){ 
		return Login.class;
	}
}
