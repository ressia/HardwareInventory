package hwinventory.ui;

import hwinventory.ui.user.UserDataView;

import org.apache.wicket.protocol.http.WebApplication;

public class AddUserApplication extends WebApplication {
    
	public AddUserApplication() {
    }
    
    @Override
    public Class getHomePage() {
        return UserDataView.class;
    }
}