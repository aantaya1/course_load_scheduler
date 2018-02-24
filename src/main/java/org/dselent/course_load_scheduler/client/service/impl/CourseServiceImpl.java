package org.dselent.course_load_scheduler.client.service.impl;

import org.dselent.course_load_scheduler.client.action.AddCourseAction;
import org.dselent.course_load_scheduler.client.action.AddToCartAction;
import org.dselent.course_load_scheduler.client.action.CourseSearchAction;
import org.dselent.course_load_scheduler.client.action.CurrentCoursesAction;
import org.dselent.course_load_scheduler.client.action.DeleteCourseAction;
import org.dselent.course_load_scheduler.client.action.EditCourseAction;
import org.dselent.course_load_scheduler.client.callback.AddCourseCallback;
import org.dselent.course_load_scheduler.client.callback.AddToCartCallback;
import org.dselent.course_load_scheduler.client.callback.CourseSearchCallback;
import org.dselent.course_load_scheduler.client.callback.CurrentCoursesCallback;
import org.dselent.course_load_scheduler.client.callback.DeleteCourseCallback;
import org.dselent.course_load_scheduler.client.callback.EditCourseCallback;
import org.dselent.course_load_scheduler.client.event.AddCourseEvent;
import org.dselent.course_load_scheduler.client.event.AddToCartEvent;
import org.dselent.course_load_scheduler.client.event.CourseSearchEvent;
import org.dselent.course_load_scheduler.client.event.CurrentCoursesEvent;
import org.dselent.course_load_scheduler.client.event.DeleteCourseEvent;
import org.dselent.course_load_scheduler.client.event.EditCourseEvent;
import org.dselent.course_load_scheduler.client.network.NetworkRequest;
import org.dselent.course_load_scheduler.client.network.NetworkRequestStrings;
import org.dselent.course_load_scheduler.client.service.CourseService;
import org.dselent.course_load_scheduler.client.translator.impl.AddCourseTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.AddToCartActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.CourseSearchTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.CurrentCoursesActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.DeleteCourseActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.EditCourseActionTranslatorImpl;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.json.client.JSONObject;

public class CourseServiceImpl extends BaseServiceImpl implements CourseService{
	
	public CourseServiceImpl()
	{
		
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
		
		registration = eventBus.addHandler(CourseSearchEvent.TYPE, this);
		eventBusRegistration.put(CourseSearchEvent.TYPE, registration);
	}

	@Override
	public void onCourseSearch(CourseSearchEvent evt) {
		CourseSearchAction action = evt.getAction();
		CourseSearchTranslatorImpl courseSearchTranslator = new CourseSearchTranslatorImpl();
		JSONObject json = courseSearchTranslator.translateToJson(action);
		CourseSearchCallback courseSearchCallback = new CourseSearchCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.COURSE_SEARCH, courseSearchCallback, json);
		request.send();
	}
	
	@Override
	public void onEditCourse(EditCourseEvent evt) {
		EditCourseAction action = evt.getAction();
		EditCourseActionTranslatorImpl editCourseTranslator = new EditCourseActionTranslatorImpl();
		JSONObject json = editCourseTranslator.translateToJson(action);
		EditCourseCallback editCourseCallback = new EditCourseCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.EDIT_COURSE, editCourseCallback, json);
		request.send();
	}
	
	@Override
	public void onAddCourse(AddCourseEvent evt) {
		AddCourseAction action = evt.getAction();
		AddCourseTranslatorImpl addCourseTranslator = new AddCourseTranslatorImpl();
		JSONObject json = addCourseTranslator.translateToJson(action);
		AddCourseCallback addCourseCallback = new AddCourseCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.ADD_COURSE, addCourseCallback, json);
		request.send();
	}
	
	public void onDeleteCourse(DeleteCourseEvent evt) {
		DeleteCourseAction action = evt.getAction();
		DeleteCourseActionTranslatorImpl deleteCourseTranslator = new DeleteCourseActionTranslatorImpl();
		JSONObject json = deleteCourseTranslator.translateToJson(action);
		DeleteCourseCallback deleteCourseCallback = new DeleteCourseCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.DELETE_COURSE, deleteCourseCallback, json);
		request.send();
	}
	
	public void onCurrentCourses(CurrentCoursesEvent evt) {
		CurrentCoursesAction action = evt.getAction();
		CurrentCoursesActionTranslatorImpl currentCoursesTranslator = new CurrentCoursesActionTranslatorImpl();
		JSONObject json = currentCoursesTranslator.translateToJson(action);
		CurrentCoursesCallback currentCoursesCallback = new CurrentCoursesCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.CURRENT_COURSES, currentCoursesCallback, json);
		request.send();
	}
	
	public void onAddToCart(AddToCartEvent evt) {
		AddToCartAction action = evt.getAction();
		AddToCartActionTranslatorImpl currentCoursesTranslator = new AddToCartActionTranslatorImpl();
		JSONObject json = currentCoursesTranslator.translateToJson(action);
		AddToCartCallback currentCoursesCallback = new AddToCartCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.CURRENT_COURSES, currentCoursesCallback, json);
		request.send();
	}
}
