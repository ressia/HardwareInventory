package hwinventory.ui.hardware;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.validation.FormComponentFeedbackBorder;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

import hwinventory.dao.HardwareInventoryDAO;
import hwinventory.domain.HardwareDevice;
import hwinventory.domain.TypeHardwareDevice;
import hwinventory.ui.application.HardwareInventoryApplication;
import hwinventory.ui.webpage.SecureWebPage;

public final class EditHardware extends SecureWebPage {
	public EditHardware(final HardwareDevice aHardware) {
		final FeedbackPanel feedback = new FeedbackPanel("feedback");
		add(feedback);
		add(new EditHardwareForm("editHardwareForm", aHardware));
	}

	public class EditHardwareForm extends Form {
		HardwareInventoryDAO aDAO = ((HardwareInventoryApplication) getApplication())
				.getSystem().getHardwareInventoryDAO();

		public EditHardwareForm(final String id, final HardwareDevice aHardware) {
			super(id, new CompoundPropertyModel(aHardware));

			/**
			 * edited values
			 */
			IChoiceRenderer choiceRenderer = new IChoiceRenderer() {
				public String getIdValue(Object object, int index) {
					return object.toString();
				}

				public Object getDisplayValue(Object object) {
					TypeHardwareDevice type = (TypeHardwareDevice) object;
					return type.getNameType();
				}
			};
			DropDownChoice typeList = new DropDownChoice("type",
					aDAO.getAllTypes(), choiceRenderer);
			final FormComponentFeedbackBorder typeFeedback = new FormComponentFeedbackBorder(
					"typeFeedback");
			final TextField aDisk = new TextField("diskSize");
			final TextField aMemory = new TextField("memorySize");
			final TextField anIam = new TextField("ianNumber");
			final TextField aMac = new TextField("macAddress");
			final TextField aSerial = new TextField("serialNumber");
			final TextField anIp = new TextField("ipAddress");
			final FormComponentFeedbackBorder diskFeedback = new FormComponentFeedbackBorder(
					"diskFeedback");
			final FormComponentFeedbackBorder memoryFeedback = new FormComponentFeedbackBorder(
					"memoryFeedback");
			final FormComponentFeedbackBorder iamFeedback = new FormComponentFeedbackBorder(
					"iamFeedback");
			final FormComponentFeedbackBorder macFeedback = new FormComponentFeedbackBorder(
					"macFeedback");
			final FormComponentFeedbackBorder serialFeedback = new FormComponentFeedbackBorder(
					"serialFeedback");
			final FormComponentFeedbackBorder ipFeedback = new FormComponentFeedbackBorder(
					"ipFeedback");
			add(typeFeedback);
			typeFeedback.add(typeList);
			add(diskFeedback);
			diskFeedback.add(aDisk);
			add(memoryFeedback);
			memoryFeedback.add(aMemory);
			add(iamFeedback);
			iamFeedback.add(anIam);
			add(macFeedback);
			macFeedback.add(aMac);
			add(serialFeedback);
			serialFeedback.add(aSerial);
			add(ipFeedback);
			ipFeedback.add(anIp);
		}

		@Override
		public void onSubmit() {
			HardwareDevice aHardwareModel = (HardwareDevice) getModelObject();
			HardwareInventoryDAO aDAO = ((HardwareInventoryApplication) getApplication())
					.getSystem().getHardwareInventoryDAO();
			try {
				aDAO.modifyHardwareDevice(aHardwareModel);
				HardwareView aHardwareView = new HardwareView();
				setResponsePage(aHardwareView);
			} catch (Exception e) {
				String errMsg = getLocalizer().getString(
						"login.errors.invalidCredentials ", EditHardware.this,
						"Unable to modify the hardware device.");
				error(errMsg);
			}
		}
	}
}
