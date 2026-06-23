package it.uniroma3.siw;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration 
{

    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";

    private final DataSource dataSource;

    public SecurityConfiguration(DataSource dataSource) 
    {
        this.dataSource = dataSource;
    }

    @Bean
    public UserDetailsService userDetailsService() 
    {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);

        manager.setUsersByUsernameQuery("SELECT username, password, 1 as enabled FROM credenziali WHERE username=?");

        manager.setAuthoritiesByUsernameQuery("SELECT username, role FROM credenziali WHERE username=?");

        return manager;
    }

    @Bean
    PasswordEncoder passwordEncoder() 
    {
        return new BCryptPasswordEncoder();
    }

 @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception 
{
    http
        // 🌟 Diciamo a Spring di ignorare il CSRF per React, per le immagini e anche per la richiesta di LOGIN
        .csrf(csrf -> csrf.ignoringRequestMatchers("/rest/**", "/uploads/**", "/login"))

        .authorizeHttpRequests(authorize -> {

            // 1. Permetti l'accesso a tutte le API REST di React
            authorize.requestMatchers("/rest/**").permitAll();
            
            // 2. Permetti l'accesso alle immagini dei post e degli avatar
            authorize.requestMatchers("/uploads/**").permitAll();
            authorize.requestMatchers("/img/**").permitAll(); 

            authorize.requestMatchers("/admin/**")
                    .hasAuthority(ROLE_ADMIN);

            authorize.requestMatchers(
                    "/user/**"
            ).authenticated();

            authorize.anyRequest().permitAll();
        });

    http.formLogin(form -> {
        form.loginPage("/login");
        form.defaultSuccessUrl("/", true);
        form.failureUrl("/login?error=true");
        form.permitAll();
    });

    http.logout(logout -> {
        logout.logoutUrl("/logout");
        logout.logoutSuccessUrl("/");
        logout.permitAll();
    });

    return http.build();
}
}