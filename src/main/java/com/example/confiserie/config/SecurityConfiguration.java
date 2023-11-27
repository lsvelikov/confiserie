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


//    private final UserRepository userRepository;
//
//
//    private final JwtAuthenticationFilter jwtFilter;
//
//    public SecurityConfiguration(UserRepository userRepository, JwtAuthenticationFilter jwtFilter) {
//        this.userRepository = userRepository;
//        this.jwtFilter = jwtFilter;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService(userRepository));
//        authProvider.setPasswordEncoder(passwordEncoder());
//        return authProvider;
//    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {


//        httpSecurity
//                .csrf(AbstractHttpConfigurer::disable)
//                .cors(AbstractHttpConfigurer::disable)
//                .cors(withDefaults())
//                .authorizeHttpRequests(request -> request.requestMatchers("/**")
//                        .permitAll().anyRequest().authenticated())
//                .sessionManagement(manager -> manager.sessionCreationPolicy(STATELESS))
//                .authenticationProvider(authenticationProvider())
//                .exceptionHandling(configurer -> configurer.authenticationEntryPoint((request, response, exception) ->
//                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
//                                exception.getMessage())))
//                .addFilterBefore(
//                        jwtFilter, UsernamePasswordAuthenticationFilter.class);
//        return httpSecurity.build();


        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(
                authorizeHttpRequests -> authorizeHttpRequests
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers("/", "/users/login", "/users/register", "/users/login-error").permitAll()
                        .requestMatchers("/products/add", "/products/delete").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/products/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/products/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/assortment/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "products/change-product/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "products/update/**").hasRole("ADMIN")
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
