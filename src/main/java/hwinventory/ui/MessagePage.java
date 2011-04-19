package hwinventory.ui;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class MessagePage extends WebPage {
	public MessagePage(){
		add(new Label("message","User added"));
	}

}
