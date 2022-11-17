package projectbackend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import projectbackend.jwt.JwtFilter;
import projectbackend.service.decentralization.impl.MyUserDetailService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService userDetailService;
    @Autowired
    private JwtFilter jwtFilter;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*cài đặt lấy thông tin của userDetail và mã hóa passs*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/api/public/**",
                        "/api/customer/add",
                        "/api/customer",
                        "/api/customer/{username}",
                        "/api/user/find/{username}",
                        "/api/customer/find/{id}",
                        "/api/promotion/**",
                        "/api/ticket/**")
                .permitAll()
                .antMatchers("/api/user/**",
                        "/api/promotion/list",
                        "/api/promotion/save",
                        "/api/promotion/delete/{id}",
                        "/api/promotion/edit/{id}",
                        "/api/promotion/detail/{id}"
                        ).hasAnyRole("ROLE_ADMIN","ROLE_EMPLOYEE", "ROLE_CUSTOMER")
                .antMatchers("api/admin/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .rememberMe().key("uniqueAndSecret").tokenValiditySeconds(60*60*24);
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
