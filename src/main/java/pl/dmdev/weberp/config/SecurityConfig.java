package pl.dmdev.weberp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.authorizeRequests()
                .antMatchers("/").hasAnyAuthority("INSP","DYR")
                .antMatchers("/dyrekcja/**").hasAnyAuthority("INSP","DYR")
                .antMatchers("/inspektor/**").hasAnyAuthority("INSP")
                .antMatchers("/kadry/**").hasAnyAuthority("DYR","INSP")
                .anyRequest().authenticated()
                .and().formLogin().defaultSuccessUrl("/")
        ;
        security.csrf().disable();


        security.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll();

    }


    @Autowired
    public void securityUsers(AuthenticationManagerBuilder auth) throws Exception{

//        auth.inMemoryAuthentication().withUser("user1").password("dominik").roles("USER");

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT username,password,enabled FROM user WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT username,role FROM ROLE WHERE username = ?");

    }
}
