package hwinventory.ui.category;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.validation.FormComponentFeedbackBorder;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

import hwinventory.dao.HardwareInventoryDAO;
import hwinventory.domain.CategoryHardwareDevice;
import hwinventory.ui.application.HardwareInventoryApplication;
import hwinventory.ui.webpage.SecureWebPage;

public final class EditCategory extends SecureWebPage {
	public EditCategory(final CategoryHardwareDevice aCategory) {
		final FeedbackPanel feedback = new FeedbackPanel("feedback");
		add(feedback);
		add(new EditCategoryForm("editCategoryForm", aCategory));
	}

	public class EditCategoryForm extends Form {
		public EditCategoryForm(final String id,
				final CategoryHardwareDevice aCategory) {
			super(id, new CompoundPropertyModel(aCategory));

			final TextField nameCategory = new TextField("nameCategory");
			final FormComponentFeedbackBorder nameFeedback = new FormComponentFeedbackBorder(
					"nameFeedback");
			add(nameFeedback);
			nameFeedback.add(nameCategory);
		}

		@Override
		public void onSubmit() {
			CategoryHardwareDevice aCategoryModel = (CategoryHardwareDevice) getModelObject();
			HardwareInventoryDAO aDAO = ((HardwareInventoryApplication) getApplication())
					.getSystem().getHardwareInventoryDAO();
			try {
				aDAO.modifyCategory(aCategoryModel);
				CategoryView aCategoryView = new CategoryView();
				setResponsePage(aCategoryView);
			} catch (Exception e) {
				String errMsg = getLocalizer().getString(
						"login.errors.invalidCredentials ", EditCategory.this, "Unable to modify the category.");
				error(errMsg);
			}
		}
	}
}