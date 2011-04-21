package hwinventory.ui;

import hwinventory.ui.user.ViewUserPage;

import org.apache.wicket.protocol.http.WebApplication;

public class AddUserApplication extends WebApplication {
    
	public AddUserApplication() {
    }
    
    @Override
    public Class getHomePage() {
        return ViewUserPage.class;
    }
}