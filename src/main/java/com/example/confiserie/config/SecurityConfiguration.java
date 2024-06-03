package com.example.confiserie.config;

import com.example.confiserie.repository.UserRepository;
import com.example.confiserie.service.impl.ConfiUserDetailService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .csrf(csrf -> csrf.disable())
                //.csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(
                authorizeHttpRequests -> authorizeHttpRequests
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers("/", "/users/login", "/users/register", "/users/login-error").permitAll()
                        .requestMatchers("/products/add", "/products/delete").hasAnyRole("ADMIN", "MANAGER")
                        .requestMatchers(HttpMethod.GET,"/admin/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/products/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/products/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/assortment/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/products/change-product/**").hasAnyRole("ADMIN", "MANAGER")
                        .requestMatchers(HttpMethod.POST, "/products/update/**").hasAnyRole("ADMIN", "MANAGER")
                        .requestMatchers(HttpMethod.GET, "/products/buy/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/products/buy/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/users/make-admin/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/users/make-manager/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/managers/make-admin/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/managers/delete-manager/**").hasRole("ADMIN")
                        .requestMatchers("/about", "/contact").permitAll()
                        .requestMatchers("/products/all").permitAll()
                        .anyRequest()
                        .authenticated()

        ).formLogin(
                formLogin -> formLogin
                        .loginPage("/users/login")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/", true)
                        .failureForwardUrl("/users/login-error")
        ).logout(
                logout -> logout
                        .logoutUrl("/users/logout")
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
        ).build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new ConfiUserDetailService(userRepository);
    }
}
