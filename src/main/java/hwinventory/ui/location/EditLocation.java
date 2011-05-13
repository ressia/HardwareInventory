package hwinventory.ui.location;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.validation.FormComponentFeedbackBorder;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

import hwinventory.dao.HardwareInventoryDAO;
import hwinventory.domain.LocationItemInventory;
import hwinventory.ui.application.HardwareInventoryApplication;
import hwinventory.ui.webpage.SecureWebPage;

public final class EditLocation extends SecureWebPage {
	public EditLocation(final LocationItemInventory aLocation) {
		final FeedbackPanel feedback = new FeedbackPanel("feedback");
		add(feedback);
		add(new EditLocationForm("editLocationForm", aLocation));
	}

	public class EditLocationForm extends Form {
		public EditLocationForm(final String id,
				final LocationItemInventory aLocation) {
			super(id, new CompoundPropertyModel(aLocation));

			final TextField nameLocation = new TextField("nameLocation");
			final FormComponentFeedbackBorder nameFeedback = new FormComponentFeedbackBorder(
					"nameFeedback");
			add(nameFeedback);
			nameFeedback.add(nameLocation);
		}

		@Override
		public void onSubmit() {
			LocationItemInventory aLocationModel = (LocationItemInventory) getModelObject();
			HardwareInventoryDAO aDAO = ((HardwareInventoryApplication) getApplication())
					.getSystem().getHardwareInventoryDAO();
			try {
				aDAO.modifyLocation(aLocationModel);
				LocationView aLocationView = new LocationView();
				setResponsePage(aLocationView);
			} catch (Exception e) {
				String errMsg = getLocalizer().getString(
						"login.errors.invalidCredentials ", EditLocation.this,
						"Unable to modify the location.");
				error(errMsg);
			}
		}
	}
}