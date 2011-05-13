package hwinventory.ui.user;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.validation.FormComponentFeedbackBorder;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

import hwinventory.dao.HardwareInventoryDAO;
import hwinventory.domain.User;
import hwinventory.ui.application.HardwareInventoryApplication;
import hwinventory.ui.webpage.SecureWebPage;

public final class EditUser extends SecureWebPage {
	public EditUser(final User aUser) {
		final FeedbackPanel feedback = new FeedbackPanel("feedback");
		add(feedback);
		add(new EditUserForm("editUserForm", aUser));
	}

	public class EditUserForm extends Form {
		public EditUserForm(final String id, final User aUser) {
			super(id, new CompoundPropertyModel(aUser));

			/**
			 * edited values
			 */
			final TextField nameUser = new TextField("nameUser");
			final FormComponentFeedbackBorder nameFeedback = new FormComponentFeedbackBorder(
					"nameFeedback");
			add(nameFeedback);
			nameFeedback.add(nameUser);
		}

		@Override
		public void onSubmit() {
			User aUserModel = (User) getModelObject();
			HardwareInventoryDAO aDAO = ((HardwareInventoryApplication) getApplication())
					.getSystem().getHardwareInventoryDAO();
			try {
				aDAO.modifyUser(aUserModel);
				UserView aUserView = new UserView();
				setResponsePage(aUserView);
			} catch (Exception e) {
				String errMsg = getLocalizer().getString(
						"login.errors.invalidCredentials ", EditUser.this,
						"Unable to modify the user.");
				error(errMsg);
			}
		}
	}
}