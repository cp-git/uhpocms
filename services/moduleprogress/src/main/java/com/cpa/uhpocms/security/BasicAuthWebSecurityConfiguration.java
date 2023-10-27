package com.cpa.uhpocms.security;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;





@EnableWebSecurity
public class BasicAuthWebSecurityConfiguration {


	 
	
	 @Bean
	    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
	         http
	        .exceptionHandling()
	        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
	        .and()
	        .cors().and()
	        .csrf().disable().authorizeHttpRequests()
	        .antMatchers().permitAll()
	        .anyRequest().authenticated()
//	        .and()
//	        .formLogin();

		        .and()
		        .httpBasic();
//			
//				  
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
	 
	 @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		 String password = "P@55w0rd"; 
		 PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
		 String encodedPassword = passwordEncoder.encode(password);
	        auth
	          .inMemoryAuthentication()
	          .withUser("uhpocadmin")
	          .password(encodedPassword)
	          .authorities("ROLE_USER");
	    }
	 
	 
	  @Bean
	  public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }
	  
}
