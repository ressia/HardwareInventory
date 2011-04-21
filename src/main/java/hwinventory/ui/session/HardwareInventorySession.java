package hwinventory.ui.session;

import hwinventory.domain.User;

import org.apache.wicket.Request;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WebSession;

public class HardwareInventorySession extends WebSession {
	
	private User user;
	
	public HardwareInventorySession(Request request) {
		super(request);
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() { 
		return this.user;
	}
	
	public boolean isUserLoggedIn() {
		return (user != null);
	}
}
