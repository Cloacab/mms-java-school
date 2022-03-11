//package com.yuri.mmsjavaschool.security;
//
//import com.yuri.mmsjavaschool.security.credentials.ClientDetailsService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final ClientDetailsService clientDetailsService;
//    private final ClientSuccessAuthenticationHandler clientSuccessAuthenticationHandler;
//    private final BasicAuthenticationEntryPoint authenticationEntryPoint;
//
//    public WebSecurityConfig(ClientDetailsService clientDetailsService,
//                             ClientSuccessAuthenticationHandler clientSuccessAuthenticationHandler) {
//        this.clientDetailsService = clientDetailsService;
//        this.clientSuccessAuthenticationHandler = clientSuccessAuthenticationHandler;
//        this.authenticationEntryPoint = new BasicAuthenticationEntryPoint();
//        this.authenticationEntryPoint.setRealmName("myRealm");
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(clientDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
////                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////                .and()
//                .authorizeRequests()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/clients/**").hasRole("USER")
//                .antMatchers("/resource", "/api/auth/**").permitAll();
//
//        http.httpBasic().authenticationEntryPoint(authenticationEntryPoint);
//    }
//}
