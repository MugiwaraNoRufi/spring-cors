package com.freelance.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * <p>
 * For security reasons, browsers prohibit AJAX calls to resources residing
 * outside the current origin.
 * </p>
 * 
 * <p>
 * Cross-origin resource sharing (CORS) is a W3C specification implemented by
 * most browsers that allows you to specify in a flexible way what kind of cross
 * domain requests are authorized.
 * </p>
 * 
 * <p>
 * In order to support CORS with filter-based security frameworks like Spring
 * Security, or with other libraries that do not support natively CORS, Spring
 * Framework also provides a {@code CorsFilter}. Instead of using
 * {@code @CrossOrigin } or
 * {@code WebMvcConfigurer#addCorsMappings(CorsRegistry)}, you need to register
 * a custom filter defined like bellow:
 * </p>
 * 
 * @author mugiwaranorufi
 *
 */
@Configuration
public class CustomCorsFilter extends CorsFilter {

	public CustomCorsFilter() {
		super(configurationSource());
	}

	private static UrlBasedCorsConfigurationSource configurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("http://localhost:9000");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));

		// We need to ensure that CorsFilter is ordered before the other
		// filters.
		bean.setOrder(0);
		return source;
	}

}
