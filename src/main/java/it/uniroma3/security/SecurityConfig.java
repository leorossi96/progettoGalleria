package it.uniroma3.security;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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

		auth.inMemoryAuthentication()
		.withUser("user").password("user").roles("ADMIN");

//		.jdbcAuthentication().dataSource(dataSource)
//		.passwordEncoder(new BCryptPasswordEncoder())
//		.usersByUsernameQuery(
//                "select username,password, enabled from users where username=?")
//        .authoritiesByUsernameQuery(
//                "select username, role from user_roles where username=?")
//		.withDefaultSchema()
//		.withUser("user").password("password").roles("ADMIN");
	}
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
        .authorizeRequests()
        	.antMatchers("/","/index","/quadri","/inserimentoQuadro","/inserimentoAutore").permitAll()
//            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
        .logout()
           .permitAll();
    }
}