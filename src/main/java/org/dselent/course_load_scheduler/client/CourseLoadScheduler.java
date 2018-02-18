package org.dselent.course_load_scheduler.client;

import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.presenter.AccountInfoPresenter;
import org.dselent.course_load_scheduler.client.presenter.impl.AccountInfoPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.AddCoursePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.AddInstancePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.AddSectionPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.IndexPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.LoginPresenterImpl;
import org.dselent.course_load_scheduler.client.view.AccountInfoView;
import org.dselent.course_load_scheduler.client.view.AddCourseView;
import org.dselent.course_load_scheduler.client.view.AddInstanceView;
import org.dselent.course_load_scheduler.client.view.AddSectionView;
import org.dselent.course_load_scheduler.client.view.IndexView;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CourseLoadScheduler implements EntryPoint
{

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad()
	{
		RootLayoutPanel root = RootLayoutPanel.get();
		
		//SimplePanelExample simplePanelExample = new SimplePanelExample();
		//root.add(simplePanelExample);
		
		//SimplePanelExample2 simplePanelExample2 = new SimplePanelExample2();
		//root.add(simplePanelExample2);
		
		//HTMLPanelExample htmlPanelExample = new HTMLPanelExample();
		//root.add(htmlPanelExample);
		
		//FlowPanelExample flowPanelExample = new FlowPanelExample();
		//root.add(flowPanelExample);
		
		//VerticalPanelExample verticalPanelExample = new VerticalPanelExample();
		//root.add(verticalPanelExample);
		
		//HorizontalPanelExample horizontalPanelExample = new HorizontalPanelExample();
		//root.add(horizontalPanelExample);
		
		//DockLayoutPanelExample dockLayoutPanelExample = new DockLayoutPanelExample();
		//root.add(dockLayoutPanelExample);
		
		//GridExample gridExample = new GridExample();
		//root.add(gridExample);

		//TabLayoutPanelExample tabLayoutPanelExample = new TabLayoutPanelExample();
		//root.add(tabLayoutPanelExample);
		
		//ExamplesPanel examplesPanel = new ExamplesPanel();
		//root.add(examplesPanel);

		// Get the injector, which injected objects can be retrieved from
		final Injector injector = Injector.INSTANCE;
		
		// added by me and javier root.add(injector.getIndexPresenter().getView().getMainPanel());
		
		//Initialize all presenters
		AccountInfoPresenterImpl AccountInfoPresenter = injector.getAccountInfoPresenter(); 
		AccountInfoPresenter.init();
		AccountInfoView AccountInfoView = AccountInfoPresenter.getView();	
		
		AddCoursePresenterImpl AddCoursePresenter = injector.getAddCoursePresenter(); 
		AddCoursePresenter.init();
		AddCourseView AddCourseView = AddCoursePresenter.getView();	
		
		AddInstancePresenterImpl AddInstancePresenter = injector.getAddInstancePresenter(); 
		AddInstancePresenter.init();
		AddInstanceView AddInstanceView = AddInstancePresenter.getView();	
		
		AddSectionPresenterImpl AddSectionPresenter = injector.getAddSectionPresenter(); 
		AddSectionPresenter.init();
		AddSectionView AddSectionView = AddSectionPresenter.getView();	
		
		
		
		
		IndexPresenterImpl indexPresenter = injector.getIndexPresenter(); // on-demand injection
		indexPresenter.init();
		IndexView indexView = indexPresenter.getView();		
		
		LoginPresenterImpl loginPresenter = injector.getLoginPresenter();
		loginPresenter.init();
		//LoginView loginView = loginPresenter.getView();	
		
		//indexPresenter.go(RootPanel.get("indexContainer"));
		indexPresenter.go(root);
		loginPresenter.go(indexView.getViewRootPanel());
		
		AccountInfoPresenterImpl accountInfoPresenter = injector.getAccountInfoPresenter();
		accountInfoPresenter.init();
		AccountInfoView accountInfoView = accountInfoPresenter.getView();
		
		accountInfoPresenter.go(accountInfoView.getViewRootPanel());
		
	}
}
