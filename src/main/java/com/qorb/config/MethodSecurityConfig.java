package com.qorb.config;

import com.qorb.security.CustomPermissionEvaluator;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
/*public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration  {
    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        DefaultMethodSecurityExpressionHandler expressionHandler =
                new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(new CustomPermissionEvaluator());
        return expressionHandler;
    }
}*/

public class MethodSecurityConfig extends AbstractSecurityWebApplicationInitializer {

    public MethodSecurityConfig(){
        super(SecurityConfig.class);
    }
}
