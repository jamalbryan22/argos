package bryan.Argos.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf()
        .disable()
        .authorizeRequests()
        .antMatchers("/**")
        .permitAll()
        .and()
        .httpBasic()
        .disable();
//        .authorizeRequests()
//        .antMatchers("/", "index", "/css/*", "/js/*", "api/**")
//        .permitAll().and().httpBasic().disable();
  }
}
