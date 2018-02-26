package org.dselent.course_load_scheduler.client.presenter.impl;

import javax.inject.Inject;

import org.dselent.course_load_scheduler.client.action.GoToAdminHomeAction;
import org.dselent.course_load_scheduler.client.action.GoToCurrentCoursesAction;
import org.dselent.course_load_scheduler.client.action.GoToInstructorHomeAction;
import org.dselent.course_load_scheduler.client.action.GoToLogoutAction;
import org.dselent.course_load_scheduler.client.action.GoToReportAProblemAction;
import org.dselent.course_load_scheduler.client.event.GoToAdminHomeEvent;
import org.dselent.course_load_scheduler.client.event.GoToCurrentCoursesEvent;
import org.dselent.course_load_scheduler.client.event.GoToInstructorHomeEvent;
import org.dselent.course_load_scheduler.client.event.GoToLogoutEvent;
import org.dselent.course_load_scheduler.client.event.GoToReportAProblemEvent;
import org.dselent.course_load_scheduler.client.event.SendLoginEvent;
import org.dselent.course_load_scheduler.client.model.GlobalData;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.IndexView;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;


public class IndexPresenterImpl extends BasePresenterImpl implements IndexPresenter
{
	private IndexPresenter parentPresenter;
	private IndexView view;
	private boolean viewCurrentClassesClickInProgress;
	private boolean homeClickInProgress;
	private boolean logoutClickInProgress;
	private boolean reportAProblemClickInProgress;
	private GlobalData globalData;

	@Inject
	public IndexPresenterImpl(IndexView view, GlobalData globalData)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		viewCurrentClassesClickInProgress = false;
		homeClickInProgress = false;
		logoutClickInProgress = false;
		reportAProblemClickInProgress = false;
		this.globalData = globalData;	//TODO make sure I got this right
//		if (globalData.getUserInfo().getUserRole() == 2) {
//			HasWidgets container = parentPresenter.getView().getMiddlePanel();
//			GoToInstructorHomeAction giha = new GoToInstructorHomeAction();
//			GoToInstructorHomeEvent gihe = new GoToInstructorHomeEvent(giha,container);
//			eventBus.fireEvent(gihe);
//		}
//		else {
//			HasWidgets container = parentPresenter.getView().getMiddlePanel();
//			GoToAdminHomeAction gaha = new GoToAdminHomeAction();
//			GoToAdminHomeEvent gahe = new GoToAdminHomeEvent(gaha,container);
//			eventBus.fireEvent(gahe);
//		}
	}

	@Override
	public void init()
	{
		bind();
	}

	@Override
	public void bind()
	{
		HandlerRegistration registration;

		registration = eventBus.addHandler(SendLoginEvent.TYPE, this);
		eventBusRegistration.put(SendLoginEvent.TYPE, registration);
	}

	@Override
	public void go(HasWidgets container)
	{
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public IndexView getView()
	{
		return view;
	}

	@Override
	public IndexPresenter getParentPresenter()
	{
		return parentPresenter;
	}

	@Override
	public GlobalData getGlobalData() {
		return globalData;
	}

	@Override
	public void setParentPresenter(IndexPresenter parentPresenter)
	{
		this.parentPresenter = parentPresenter;
	}


	@Override
	public void showLoadScreen()
	{
		// thank you stackoverflow
		// https://stackoverflow.com/questions/23017908/gwt-set-the-visibility-of-widget-using-css-visibility-property
		view.getLoadingImage().getElement().getStyle().setVisibility(Style.Visibility.VISIBLE);
		view.getGlassLoadingPanel().getElement().getStyle().setVisibility(Style.Visibility.VISIBLE);
	}

	@Override
	public void hideLoadScreen()
	{
		view.getLoadingImage().getElement().getStyle().setVisibility(Style.Visibility.HIDDEN);
		view.getGlassLoadingPanel().getElement().getStyle().setVisibility(Style.Visibility.HIDDEN);
	}

	@Override
	public void home() {
		if(!homeClickInProgress) 
		{
			homeClickInProgress = true;
			view.getHomeButton().setEnabled(false);
			parentPresenter.showLoadScreen();

			HasWidgets container = parentPresenter.getView().getMiddlePanel();
			boolean isAdmin = parentPresenter.getGlobalData().getIsAdmin();

			if(isAdmin) {
				GoToAdminHomeAction aha = new GoToAdminHomeAction();
				GoToAdminHomeEvent ahe = new GoToAdminHomeEvent(aha, container);
				eventBus.fireEvent(ahe);
			}
			else {
				GoToInstructorHomeAction iha = new GoToInstructorHomeAction();
				GoToInstructorHomeEvent ihe = new GoToInstructorHomeEvent(iha, container);
				eventBus.fireEvent(ihe);
			}
		}
	}

	@Override
	public void logout() {

		if(!logoutClickInProgress) 
		{
			logoutClickInProgress = true;
			view.getLogoutButton().setEnabled(false);
			parentPresenter.showLoadScreen();

			HasWidgets container = parentPresenter.getView().getMiddlePanel();
			GoToLogoutAction rap = new GoToLogoutAction();
			GoToLogoutEvent rae = new GoToLogoutEvent(rap,container);
			eventBus.fireEvent(rae);
		}

	}

	@Override
	public void reportAProblem() {

		if(!reportAProblemClickInProgress) 
		{
			reportAProblemClickInProgress = true;
			view.getReportAProblemButton().setEnabled(false);
			parentPresenter.showLoadScreen();

			HasWidgets container = parentPresenter.getView().getMiddlePanel();
			GoToReportAProblemAction rap = new GoToReportAProblemAction();
			GoToReportAProblemEvent rae = new GoToReportAProblemEvent(rap,container);
			eventBus.fireEvent(rae);
		}

	}

	@Override
	public void currentClasses() {

		if(!viewCurrentClassesClickInProgress) 
		{
			viewCurrentClassesClickInProgress = true;
			view.getViewCurrentClassesButton().setEnabled(false);
			parentPresenter.showLoadScreen();

			HasWidgets container = parentPresenter.getView().getMiddlePanel();
			GoToCurrentCoursesAction cca = new GoToCurrentCoursesAction();
			GoToCurrentCoursesEvent cce = new GoToCurrentCoursesEvent(cca, container);
			eventBus.fireEvent(cce);

		}

	}
}
