package org.dselent.course_load_scheduler.client.presenter.impl;

import javax.inject.Inject;

import org.dselent.course_load_scheduler.client.action.FacultyCourseMapAction;
import org.dselent.course_load_scheduler.client.event.FacultyCourseMapEvent;
import org.dselent.course_load_scheduler.client.presenter.FacultyCourseMapPresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.FacultyCourseMapView;

import com.google.gwt.user.client.ui.HasWidgets;

public class FacultyCourseMapPresenterImpl extends BasePresenterImpl implements FacultyCourseMapPresenter {
	
	private IndexPresenter parentPresenter;
	private FacultyCourseMapView view;
	
	@Inject
	public FacultyCourseMapPresenterImpl(IndexPresenter parentPresenter, FacultyCourseMapView view) {
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public FacultyCourseMapView getView() {
		return view;
	}

	public IndexPresenter getParentPresenter() {
		return parentPresenter;
	}

	public void setParentPresenter(IndexPresenter parentPresenter) {
		this.parentPresenter = parentPresenter;
	}

	public void setView(FacultyCourseMapView view) {
		this.view = view;
	}

	//TODO We will probably scrap this when we get to the service bit
	@Override
	public void getFaculty() {
		FacultyCourseMapAction fcma = new FacultyCourseMapAction();
		FacultyCourseMapEvent fcme = new FacultyCourseMapEvent(fcma);
		eventBus.fireEvent(fcme);
	}

}
