package aua.capstone.storeApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.session.web.http.CookieHttpSessionIdResolver;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.session.web.http.HttpSessionIdResolver;

@EnableWebSecurity
@Configuration
public class AppSecurityConfig
{
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(csrf -> csrf.disable())
//                .headers(headers -> headers.frameOptions().disable())
//                .authorizeRequests(authorize -> authorize
//                        .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
//                        .anyRequest().authenticated()
//                )
//                .httpBasic()
//                .build();
//    }


//    @Bean
//    public UserDetailsService userDetailsService() {
//        // Implement and return your UserDetailsService to load user details for authentication
//       // return super.userDetailsService();
//    } //////chmorananq sra masin

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public HttpSessionIdResolver httpSessionIdResolver() {
        CookieHttpSessionIdResolver resolver = new CookieHttpSessionIdResolver();
        DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();
        cookieSerializer.setUseBase64Encoding(false);
        resolver.setCookieSerializer(cookieSerializer);
        return resolver;
    }
}