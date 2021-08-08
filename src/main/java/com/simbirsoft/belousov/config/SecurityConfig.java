package com.simbirsoft.belousov.config;

import com.simbirsoft.belousov.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Set;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserRepository userRepository;

    public SecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/")
                .permitAll()
//                .antMatchers(HttpMethod.GET, "/api/**").hasAnyRole("admin")
//                .antMatchers(HttpMethod.POST, "/api/**").hasAnyRole("admin")
//                .antMatchers(HttpMethod.DELETE, "/api/**").hasAnyRole("admin")
//                .antMatchers(HttpMethod.PUT, "/api/**").hasAnyRole("admin")
                .anyRequest().authenticated().and().httpBasic();


    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {

        Set<UserDetails> users= userRepository.findAll()
                .stream()
                .map(userEntity -> User.builder()
                        .username(userEntity.getName())
                        .password(passwordEncoder().encode(userEntity.getPassword()))
                        .roles(userEntity.getRole().getName())
                        .build())
                .collect(Collectors.toSet());

        return new InMemoryUserDetailsManager(users);

//        return new InMemoryUserDetailsManager(
//                User.builder()
//                        .username("admin")
//                        .password(passwordEncoder().encode("admin"))
//                        .roles("admin")
//                        .build(),
//                User.builder()
//                        .username("user")
//                        .password(passwordEncoder().encode("user"))
//                        .roles("user")
//                        .build())
//                ;
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
