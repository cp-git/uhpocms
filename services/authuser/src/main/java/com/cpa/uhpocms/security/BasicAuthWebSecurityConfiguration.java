package com.cpa.uhpocms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class BasicAuthWebSecurityConfiguration {

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeHttpRequests().antMatchers().permitAll().anyRequest()
				.authenticated().and().httpBasic();
		return http.build();
	}
	


	 @Bean
	  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    return http
	      .requiresChannel(channel -> 
	          channel.anyRequest().requiresSecure())
	      .authorizeRequests(authorize ->
	          authorize.anyRequest().permitAll() )
	      .build();
	    }
     
	 
//	 @Bean
//	  public ServletWebServerFactory servletContainer() {
//	    TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
//	      @Override
//	      protected void postProcessContext(Context context) {
//	        var securityConstraint = new SecurityConstraint();
//	        securityConstraint.setUserConstraint("CONFIDENTIAL");
//	        var collection = new SecurityCollection();
//	        collection.addPattern("/*");
//	        securityConstraint.addCollection(collection);
//	        context.addConstraint(securityConstraint);
//	      }
//	    };
//	    tomcat.addAdditionalTomcatConnectors(getHttpConnector());
//	    return tomcat;
//	  }
//
//	  private Connector getHttpConnector() {
//	    var connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
//	    connector.setScheme("http");
//	    connector.setPort(8080);
//	    connector.setSecure(false);
//	    connector.setRedirectPort(8443);
//	    return connector;
//	  }
	 
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		String password = "P@55w0rd";
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(password);
		auth.inMemoryAuthentication().withUser("uhpocadmin").password(encodedPassword).authorities("ROLE_USER");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
