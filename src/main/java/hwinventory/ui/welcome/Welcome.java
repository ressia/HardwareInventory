package hwinventory.ui.welcome;


import hwinventory.ui.login.Login;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;

public class Welcome extends WebPage {

	private String userId;
	
	public Welcome() { 
		add(new Label("message",new PropertyModel(this,"userId")));
		
		Link linkToLogin = new Link("linkToLogin") {
			public void onClick() {
				setResponsePage(Login.class);
			}
		};
		add(linkToLogin);
		/*Form form = new Form("WelcomeForm");
		form.add(linkToLogin);
		add(form);*/
	}
	
	public String getUserId() { 
		return userId;
	}
	public void setUserId(String userId) { 
		this.userId = userId;
	}
}