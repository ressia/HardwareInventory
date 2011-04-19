package hwinventory.domain;

import org.apache.wicket.protocol.http.WebApplication;

public class UserApplication extends WebApplication {
    public UserApplication() {
    }
    
    @Override
    public Class getHomePage() {
        return UserPage.class;
    }
}