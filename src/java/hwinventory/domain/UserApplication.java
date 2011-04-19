package hwinventory.domain;

/**
Each Wicket application is defined by an Application object. 
This object defines what the home page is, and allows for some configuration.
package com.helloworld.
**/

import org.apache.wicket.protocol.http.WebApplication;

public class UserApplication extends WebApplication {
    public UserApplication() {
    }
    
    @Override
    public Class getHomePage() {
        return UserPage.class;
    }
}