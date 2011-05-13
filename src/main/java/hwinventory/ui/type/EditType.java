package hwinventory.ui.type;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.validation.FormComponentFeedbackBorder;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

import hwinventory.dao.HardwareInventoryDAO;
import hwinventory.domain.CategoryHardwareDevice;
import hwinventory.domain.TypeHardwareDevice;
import hwinventory.ui.application.HardwareInventoryApplication;
import hwinventory.ui.webpage.SecureWebPage;

public final class EditType extends SecureWebPage {
	public EditType(final TypeHardwareDevice aType) {
		final FeedbackPanel feedback = new FeedbackPanel("feedback");
		add(feedback);
		add(new EditTypeForm("editTypeForm", aType));
	}

	public class EditTypeForm extends Form {
		HardwareInventoryDAO aDAO = ((HardwareInventoryApplication) getApplication())
				.getSystem().getHardwareInventoryDAO();

		public EditTypeForm(final String id, final TypeHardwareDevice aType) {
			super(id, new CompoundPropertyModel(aType));

			/**
			 * edited values
			 */
			final TextField nameType = new TextField("nameType");
			final FormComponentFeedbackBorder nameFeedback = new FormComponentFeedbackBorder(
					"nameFeedback");
			add(nameFeedback);
			nameFeedback.add(nameType);
			IChoiceRenderer choiceRenderer = new IChoiceRenderer() {
				public String getIdValue(Object object, int index) {
					return object.toString();
				}

				public Object getDisplayValue(Object object) {
					CategoryHardwareDevice category = (CategoryHardwareDevice) object;
					return category.getNameCategory();
				}
			};
			DropDownChoice categoryList = new DropDownChoice("category",
					aDAO.getAllCategories(), choiceRenderer);
			final FormComponentFeedbackBorder categoryFeedback = new FormComponentFeedbackBorder(
					"categoryFeedback");
			add(categoryFeedback);
			categoryFeedback.add(categoryList);
		}

		@Override
		public void onSubmit() {
			TypeHardwareDevice aTypeModel = (TypeHardwareDevice) getModelObject();
			HardwareInventoryDAO aDAO = ((HardwareInventoryApplication) getApplication())
					.getSystem().getHardwareInventoryDAO();
			try {
				aDAO.modifyType(aTypeModel);
				TypeView aTypeView = new TypeView();
				setResponsePage(aTypeView);
			} catch (Exception e) {
				String errMsg = getLocalizer().getString(
						"login.errors.invalidCredentials ", EditType.this,
						"Unable to modify the type's hardware.");
				error(errMsg);
			}
		}
	}
}
