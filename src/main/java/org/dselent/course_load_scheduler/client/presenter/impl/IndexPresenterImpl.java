package org.dselent.course_load_scheduler.client.presenter.impl;

import javax.inject.Inject;

import org.dselent.course_load_scheduler.client.action.GoToCurrentCoursesAction;
import org.dselent.course_load_scheduler.client.action.GoToLogoutAction;
import org.dselent.course_load_scheduler.client.action.GoToReportAProblemAction;
import org.dselent.course_load_scheduler.client.event.GoToCurrentCoursesEvent;
import org.dselent.course_load_scheduler.client.event.GoToLogoutEvent;
import org.dselent.course_load_scheduler.client.event.GoToReportAProblemEvent;
import org.dselent.course_load_scheduler.client.model.GlobalData;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.IndexView;
import com.google.gwt.dom.client.Style;
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
	}
	
	@Override
	public void init()
	{
		bind();
	}
	
	@Override
	public void bind()
	{
		//come back after the rest and ask about this-Josue
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
	public void goHome() {
		if(!homeClickInProgress) 
		{
			homeClickInProgress = true;
			view.getHome().setEnabled(false);
			parentPresenter.showLoadScreen();
			
			HasWidgets container = parentPresenter.getView().getMiddlePanel();
			boolean isAdmin = parentPresenter.getGlobalData().getIsAdmin();
			
			if(isAdmin) {
				//GoToAdminHomepage
			}
			else {
				//GoToHomepage
			}
		}
	}
	
	@Override
	public void logout() {
		
		if(!logoutClickInProgress) 
		{
			logoutClickInProgress = true;
			view.getHome().setEnabled(false);
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
			view.getHome().setEnabled(false);
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
			view.getHome().setEnabled(false);
			parentPresenter.showLoadScreen();
			
			HasWidgets container = parentPresenter.getView().getMiddlePanel();
			GoToCurrentCoursesAction cca = new GoToCurrentCoursesAction();
			GoToCurrentCoursesEvent cce = new GoToCurrentCoursesEvent(cca, container);
			eventBus.fireEvent(cce);
			
		}
		
	}
}
