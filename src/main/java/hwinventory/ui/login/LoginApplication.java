package hwinventory.ui.login;

import org.apache.wicket.protocol.http.WebApplication;

public class LoginApplication extends WebApplication {
	
	public LoginApplication() {
	}
	
	public Class getHomePage(){ 
		return Login.class;
	}
}
