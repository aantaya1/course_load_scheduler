/**
 * 
 */
package org.dselent.course_load_scheduler.client.presenter.impl;


import org.dselent.course_load_scheduler.client.action.GoToAccountInfoAction;
import org.dselent.course_load_scheduler.client.action.GoToCartAction;
import org.dselent.course_load_scheduler.client.action.GoToClassSearchAction;
import org.dselent.course_load_scheduler.client.action.GoToCurrentCoursesAction;
import org.dselent.course_load_scheduler.client.action.GoToFacultyCourseMapAction;
import org.dselent.course_load_scheduler.client.event.GoToAccountInfoEvent;
import org.dselent.course_load_scheduler.client.event.GoToCartEvent;
import org.dselent.course_load_scheduler.client.event.GoToClassSearchEvent;
import org.dselent.course_load_scheduler.client.event.GoToCurrentCoursesEvent;
import org.dselent.course_load_scheduler.client.event.GoToFacultyCourseMapEvent;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.InstructorHomepagePresenter;
import org.dselent.course_load_scheduler.client.view.InstructorHomepageView;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

/**
 * @author bobbyshome
 *
 */
public class InstructorHomepagePresenterImpl extends BasePresenterImpl implements InstructorHomepagePresenter {
	
	private IndexPresenter parentPresenter;
	private InstructorHomepageView view;
	private boolean clickInProgress;
	private HasWidgets container = parentPresenter.getView().getMiddlePanel();

	/**
	 * 
	 */
	@Inject
	public InstructorHomepagePresenterImpl(IndexPresenter parentPresenter, InstructorHomepageView view) {
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		clickInProgress = false;
	}

	/* (non-Javadoc)
	 * @see org.dselent.course_load_scheduler.client.presenter.BasePresenter#go(com.google.gwt.user.client.ui.HasWidgets)
	 */
	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(view.getWidgetContainer());
	}

	/* (non-Javadoc)
	 * @see org.dselent.course_load_scheduler.client.presenter.BasePresenter#getView()
	 */
	@Override
	public InstructorHomepageView getView() {
		return view;
	}

	/**
	 * @return the parentPresenter
	 */
	public IndexPresenter getParentPresenter() {
		return parentPresenter;
	}

	/**
	 * @param parentPresenter the parentPresenter to set
	 */
	public void setParentPresenter(IndexPresenter parentPresenter) {
		this.parentPresenter = parentPresenter;
	}
	
	public void currentClasses() {
		if(!clickInProgress) {
			
			clickInProgress = true;
			view.getCurrentClassButton().setEnabled(false);
			parentPresenter.showLoadScreen();
			
			GoToCurrentCoursesAction gcca = new GoToCurrentCoursesAction();
			GoToCurrentCoursesEvent gcce = new GoToCurrentCoursesEvent(gcca, container);
			eventBus.fireEvent(gcce);
			
		}
	}
	
	public void classSearch() {
		if(!clickInProgress) {
			
			clickInProgress = true;
			view.getClassSearchButton().setEnabled(false);
			parentPresenter.showLoadScreen();
			
			HasWidgets container = parentPresenter.getView().getViewRootPanel();
			GoToClassSearchAction gcsa = new GoToClassSearchAction();
			GoToClassSearchEvent gcse = new GoToClassSearchEvent(gcsa, container);
			eventBus.fireEvent(gcse);
			
		}
	}
	
	public void accountInfo() {
		if(!clickInProgress) {
			
			clickInProgress = true;
			view.getAccountInfoButton().setEnabled(false);
			parentPresenter.showLoadScreen();
			
			HasWidgets container = parentPresenter.getView().getViewRootPanel();
			GoToAccountInfoAction gaa = new GoToAccountInfoAction();
			GoToAccountInfoEvent gae = new GoToAccountInfoEvent(gaa, container);
			eventBus.fireEvent(gae);
			
		}
	}
	
	public void courseCart() {
		if(!clickInProgress) {
			
			clickInProgress = true;
			view.getCourseCartButton().setEnabled(false);
			parentPresenter.showLoadScreen();
			
			HasWidgets container = parentPresenter.getView().getViewRootPanel();
			GoToCartAction gca = new GoToCartAction();
			GoToCartEvent gce = new GoToCartEvent(gca, container);
			eventBus.fireEvent(gce);
			
		}
	}
	
	public void facultyCourseMap() {
		if(!clickInProgress) {
			
			clickInProgress = true;
			view.getGenerateScheduleButton().setEnabled(false);
			parentPresenter.showLoadScreen();
			
			HasWidgets container = parentPresenter.getView().getViewRootPanel();
			GoToFacultyCourseMapAction gfcma = new GoToFacultyCourseMapAction();
			GoToFacultyCourseMapEvent gfcme = new GoToFacultyCourseMapEvent(gfcma, container);
			eventBus.fireEvent(gfcme);
			
		}
	}
}
