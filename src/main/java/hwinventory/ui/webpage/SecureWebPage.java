package hwinventory.ui.webpage;

import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.markup.html.WebPage;

import hwinventory.ui.login.Login;
import hwinventory.ui.session.HardwareInventorySession;

public abstract class SecureWebPage extends WebPage {

	public SecureWebPage() {
		super();
		verifyAccess(); 
	}
		
	protected void verifyAccess() { 
		if (!isUserLoggedIn()) {
			throw new RestartResponseAtInterceptPageException(Login.class);
	
		} 
	}	
		
	protected boolean isUserLoggedIn() { 
		return ((HardwareInventorySession)getSession()).isUserLoggedIn();
	}	
}
