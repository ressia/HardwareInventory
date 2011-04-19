package hwinventory.ui;

import org.apache.wicket.protocol.http.WebApplication;

public class AddUserApplication extends WebApplication {
    
	public AddUserApplication() {
    }
    
    @Override
    public Class getHomePage() {
        return AddUserPage.class;
    }
}