package it.uniroma3.security;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Autowired
    private DataSource dataSource;
 
    
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 inMemoryConfigurer()
	        .withUser("user")
	            .password("user")
	            .authorities("ADMIN")
	        .and()
	        .configure(auth);
		auth.jdbcAuthentication().dataSource(dataSource)
		
		.passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery("SELECT username,password,1 FROM utente where username=?")
		.authoritiesByUsernameQuery("SELECT username,ruolo FROM ruoli_utente where username=?");
	}

	private InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder>
    inMemoryConfigurer() {
	return new InMemoryUserDetailsManagerConfigurer<>();
}
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
        .authorizeRequests()
        	.antMatchers("/","/index","/quadri").permitAll()
        	.antMatchers("/inserimentoQuadro").access("hasAuthority('ADMIN')")
        	.anyRequest().authenticated()
            .and()
            
            .formLogin()
            
            .loginPage("/login").permitAll()
            //.defaultSuccessUrl("/hello")
            
            .failureUrl("/login?error")
            .and()
            
  		 .logout()
  		  .logoutSuccessUrl("/?logout")
  		 .and();
  		  
    }
}