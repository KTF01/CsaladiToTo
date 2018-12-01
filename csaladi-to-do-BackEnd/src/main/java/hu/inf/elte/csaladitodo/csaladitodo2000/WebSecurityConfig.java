package hu.inf.elte.csaladitodo.csaladitodo2000;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
            .csrf()
                .disable() // H2 Console
            .authorizeRequests()
                .antMatchers("/h2/**")
                    .permitAll() // H2 Console
                .anyRequest()
                    .authenticated()
                .and()
            .httpBasic()
                .and()
            .headers()
                .frameOptions()
                    .disable() // H2 Console
                .and()
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth)
        throws Exception {

        auth.inMemoryAuthentication()
            .withUser("user")
                .password("$2a$10$b2KUBuo5r0ReQqTOEFttkeIvx2PnBxariDTDxRK/Y9Xpui2/tMHs2")
                .roles("USER");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}*/
