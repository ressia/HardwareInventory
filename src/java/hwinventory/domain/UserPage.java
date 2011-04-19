package hwinventory.domain;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;


public class UserPage extends WebPage {
	
    public UserPage() {
    	User user = new User();
    	CompoundPropertyModel userModel = new CompoundPropertyModel(user);
    	Form form = new UserForm("user",userModel);
    	
    	add(form);
    	
    	TextField userName = new TextField("nameUser");
    	
    	form.add(userName);
    	
    }
    
    class UserForm extends Form {
    	
    	public UserForm (String id, CompoundPropertyModel model) {
    		super(id,model);
    	}
    	
    	@Override
    	
    	public void onSubmit() {
    	/* Print the contents of its own model object */
    	System.out.println(getModelObject());
    		}
    	}   
}
