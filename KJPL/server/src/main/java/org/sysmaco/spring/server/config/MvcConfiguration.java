package org.sysmaco.spring.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

/**
 *  WebMvcConfigurationSupport :- 
 *  		1. is the main class providing the configuration behind the MVC Java config.
 *  		2. We could use the @EnableWebMvc annotation to import the configuration of this class automatically
 *  		3. we could extend WebMvcConfigurationSupport to prevent the default configuration imported 
 *  				by the @EnableWebMvc annotation.  
 *  									
 *   WebMvcConfigurerAdapter :-
 *   		1. is simple adapter class for customizing some of the default configuration.
 *   		2. is not related to the @EnableWebMvc annotation.
 *   		3. We could extend WebMvcConfigurerAdapter class to customize some of the 
 *   			default configuration imported by @EnableWebMvc annotation.
 *   
 *   @EnableWebMvc is equivalent to <mvc:annotation-driven />
 *
 */


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"org.sysmaco.spring.server","org.sysmaco.spring.service"})
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	/**
	 * This is the internal view resolver that will redirect the view to the package that contain it. 
	 */
	@Bean
	public UrlBasedViewResolver viewResolver(){
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
        viewResolver.setViewClass(TilesView.class);
        return viewResolver;
    }

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/**
	 *  we can set the home page by override the addViewControllers method where we can set the 
	 *  default home page as described below.
	 */
	/*@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("login");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		super.addViewControllers(registry);
	}*/

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tiles = new TilesConfigurer();
		tiles.setDefinitions(new String[] { "/WEB-INF/tiles/tiles.xml" });
		return tiles;

	}
	
	@Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }
	
}
