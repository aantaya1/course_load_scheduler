package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.AccountInfoPresenter;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

public interface AccountInfoView extends BaseView<AccountInfoPresenter>{
	Button getSubmitChangesButton();
	PasswordTextBox getCurrPassword();
	PasswordTextBox getNewPassword();
	PasswordTextBox getRepeatNewPassword();
	TextBox getPreferedEmail();
	TextBox getPhoneNumber();
}