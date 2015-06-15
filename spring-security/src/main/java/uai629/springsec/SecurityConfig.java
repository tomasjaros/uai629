package uai629.springsec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/public.html").permitAll()
				.antMatchers("/admin.html").hasAnyRole("ADMIN")
				.antMatchers("/user.html").hasAnyRole("USER")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login.html").permitAll()
				.loginProcessingUrl("/login")
				.and()
			.csrf().disable()
			.logout().logoutUrl("/logout").logoutSuccessUrl("/login.html").and()
			.httpBasic();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("admin").password("veslo").roles("ADMIN", "USER").and()
			.withUser("pepa").password("padlo").roles("USER").and()
			.and()
			.authenticationProvider(authenticationProvider());
	}
	
	
	private AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(new DummyUserService());
		
//		authProvider.setPasswordEncoder(new Md5PasswordEncoder());
//		ReflectionSaltSource saltSource = new ReflectionSaltSource();
//		saltSource.setUserPropertyToUse("username");
//		authProvider.setSaltSource(saltSource);
		
		return authProvider;
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
}
