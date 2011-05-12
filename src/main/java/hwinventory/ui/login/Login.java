package hwinventory.ui.login;

import hwinventory.domain.User;
import hwinventory.ui.inventoryItem.InventoryItemView;
import hwinventory.ui.session.HardwareInventorySession;
import hwinventory.ui.user.UserDataView;
import hwinventory.ui.user.UserView;
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
			HardwareInventorySession session = (HardwareInventorySession)getSession();
			if (authenticate(userId, password)) {
				/*
				 * This is wrong we should use another user than the inventory user!!!!
				 */
				User loggedInUser = new User(userId);
				session.setUser(loggedInUser);
				InventoryItemView aInventoryItemView = new InventoryItemView();  
				setResponsePage(aInventoryItemView);
			} else {
				String errMsg = getLocalizer().getString(
					"login.errors.invalidCredentials ", Login.this,"Unable to sign you in");
				error(errMsg);
			}
		}
		
		public final boolean authenticate(final String username, final String password) {
			if ("w".equalsIgnoreCase(username) && "w".equalsIgnoreCase(password))
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
