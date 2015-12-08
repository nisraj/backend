package app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private SecurityUserDetailService securityUserDetailService;

	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(securityUserDetailService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
		http.csrf().disable();
	}

}