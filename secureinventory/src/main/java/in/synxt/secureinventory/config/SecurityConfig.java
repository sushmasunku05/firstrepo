package in.synxt.secureinventory.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import in.synxt.secureinventory.filter.CustomFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.csrf().disable();
		http.addFilterAt(new CustomFilter(),BasicAuthenticationFilter.class);
		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		http.authorizeHttpRequests().antMatchers("/public/user/*").hasRole("read-write").
		//hasAuthority("ADMIN").
		antMatchers("/public/**").permitAll().
		antMatchers("/secure/**").authenticated();
		http.formLogin(); // basic form login page
		http.httpBasic(); // digest box
	}

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * auth.inMemoryAuthentication().withUser("sushma").password("sushma123$").
	 * authorities("user").and()
	 * .withUser("vamsi").password("krishna123$").authorities("user"); }
	 */
	
	@Bean
	public PasswordEncoder encoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { InMemoryUserDetailsManager inMemoryUDM=new
	 * InMemoryUserDetailsManager();
	 * 
	 * UserDetails
	 * userOne=User.withUsername("sushma").password("sushma123$").authorities("user"
	 * ).build(); UserDetails
	 * userTwo=User.withUsername("vamsi").password("vamsi123$").authorities("admin")
	 * .build();
	 * 
	 * inMemoryUDM.createUser(userOne); inMemoryUDM.createUser(userTwo);
	 * 
	 * auth.userDetailsService(inMemoryUDM); }
	 */
	
	/*
	 * @Bean public JdbcUserDetailsManager jdbcConfig(DataSource datasource) {
	 * return new JdbcUserDetailsManager(datasource);
	 * 
	 * }
	 */
	
}
