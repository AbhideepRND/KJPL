package org.sysmaco.spring.server.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 
 * This configuration is responsible to initialize spring based web application. 
 * We have implemented WebApplicationInitializer to configure the ServletContext programmatically.
 * 
 *
 * Basically, we declare a class that implements org.springframework.web.WebApplicationInitializer 
 * and this class will be scanned by Spring on application startup and bootstrapped. 
 * This class has one responsibility: 
 * 		assemble the web application's moving parts, like you would in a web.xml, but in code.
 *
 *	@ServiceConfiguration presumably describes how the service tier - 
 *				with its data sources and transaction managers and thread pools and ORM mapping - are assembled.
 *
 *	@WebMvcConfiguration class describes how the web tier - 
 *				supported by Spring MVC - is put together
 *
 *	@ServletRegistration.Dynamic we override it to tailor where file uploads are stored by the Servlet 3 container.
 *				In below we say that dispatcher servlet contain all the jsp files that we have uploaded
 */
public class WebApplication implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		
		// Create the 'root' Spring application context
    	// And attached the servlet context/container with Spring root application context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.setServletContext(container);
        
        // Manage the lifecycle of the root application context
       /* ContextLoaderListener contextLoaderListener = new ContextLoaderListener();
		container.addListener(contextLoaderListener);*/
        
        
        // Create the dispatcher servlet's Spring application context
        // So we can create multiple dispatcher servlet with different url mapping
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(MvcConfiguration.class);	
        
        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("*.html");
		
	}

	
	
}
