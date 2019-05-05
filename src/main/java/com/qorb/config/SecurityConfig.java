package com.qorb.config;
import com.qorb.security.CustomPermissionEvaluator;
import com.qorb.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan("com.qorb")
public class SecurityConfig extends WebSecurityConfigurerAdapter  {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    //???????????????????????????
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().and()
                .authorizeRequests().anyRequest()
                .authenticated()
                .and().httpBasic()
                .and()
                .formLogin()  //login configuration
                .loginPage("/login").permitAll()
                .loginProcessingUrl("/login")
                .usernameParameter("custome_username")
                .passwordParameter("custome_password")
                .defaultSuccessUrl("/home",true)
                .and().logout()    //logout configuration
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                /*.and().exceptionHandling() //exception handling configuration
                .accessDeniedPage("/error")*/;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }

    @EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
    public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
        @Override
        protected MethodSecurityExpressionHandler createExpressionHandler() {
            DefaultMethodSecurityExpressionHandler expressionHandler =
                    new DefaultMethodSecurityExpressionHandler();
            expressionHandler.setPermissionEvaluator(new CustomPermissionEvaluator());
            return expressionHandler;
        }
    }
}
