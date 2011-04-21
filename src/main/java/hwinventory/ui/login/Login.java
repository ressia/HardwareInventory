package hwinventory.ui.login;

import hwinventory.ui.inventoryItem.InventoryItemView;
import hwinventory.ui.user.ViewUserPage;
import hwinventory.ui.welcome.Welcome;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;


public class Login extends WebPage {

	private String userId; 
	private String password;
	
	public Login() {
		FeedbackPanel feedback = new FeedbackPanel("feedback");
		TextField userIdField = new TextField("userId",new PropertyModel(this,"userId"));
		PasswordTextField passField = new PasswordTextField("password",new PropertyModel(this, "password"));

		Form form = new LoginForm("loginForm");
		add(feedback);
		form.add(userIdField); 
		form.add(passField); 
		add(form);
	}
	
	class LoginForm extends Form {
		
		public LoginForm(String id) { 
			super(id);
		}
			
		@Override public void onSubmit() {
			String userId = Login.this.getUserId(); 
			String password = Login.this.getPassword(); 
			if (authenticate(userId, password)) {
				/*Welcome welcomePage = new Welcome(); 
				welcomePage.setUserId(userId); 
				setResponsePage(welcomePage);*/
				//InventoryItemView aInventoryItemView = new InventoryItemView();  
				//setResponsePage(aInventoryItemView);
				ViewUserPage aViewUserPage = new ViewUserPage();
				setResponsePage(aViewUserPage);
			} else {
				String errMsg = getLocalizer().getString(
					"login.errors.invalidCredentials ", Login.this,"Unable to sign you in");
				error(errMsg);
			}
		}
		
		public final boolean authenticate(final String username, final String password) {
			if ("wicket".equalsIgnoreCase(username) && "wicket".equalsIgnoreCase(password))
				return true; 
			else
				return false;
			}
	}
		
	protected String getUserId() { 
		return userId;
	}
		
	protected String getPassword() { 
		return password;
	}
	
	public void setUserId(String userId) { 
		this.userId = userId;
	}
	
	public void setPassword(String password) { 
		this.password= password;
	}
	
}