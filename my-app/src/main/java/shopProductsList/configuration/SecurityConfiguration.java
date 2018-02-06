package shopProductsList.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import shopProductsList.listener.UserLoggListener;



@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
        dao.setUserDetailsService(userDetailsService);
        dao.setPasswordEncoder(md5PasswordEncoder());
        return dao;
    }
	
	@Bean
	public Md5PasswordEncoder md5PasswordEncoder() {
		return new Md5PasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.authenticationProvider(daoAuthenticationProvider());
	}
	
	@Bean 
	public UserLoggListener userLoggedListener() {
		return new UserLoggListener();
	}
	@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable();
        httpSecurity.authorizeRequests()
       .antMatchers("/contact").permitAll()
       .antMatchers("/register").permitAll()
       .antMatchers("/dodajUsera").permitAll()
       .antMatchers("/").permitAll().antMatchers("*/register/**").permitAll()       
       .antMatchers("/").permitAll().antMatchers("*/register/**").permitAll()
        .anyRequest().fullyAuthenticated().and()
        .formLogin().loginPage("/login").failureUrl("/login?error").usernameParameter("email").permitAll().and()
        .logout().logoutUrl("/logout").deleteCookies("remember-me").logoutSuccessUrl("/").permitAll().and().rememberMe();
    	
    }
}
