package com.qorb.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.qorb")
public class WebConfiguration  implements WebMvcConfigurer {

   /* @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
        registry.setViewClass(JstlView.class);
    }*/
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    @Bean("messageSource")
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource=new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:message");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("fa"));
        return localeResolver;
    }

   /* @Bean(name = "localeResolver")
    public CookieLocaleResolver getCookieLocaleResolver(){
        // Create a CookieLocaleResolver object.
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        // Set cookie name
        localeResolver.setCookieName("cookie-locale-info");
        // Set default locale value.
        localeResolver.setDefaultLocale(Locale.ENGLISH);
        // Set cookie max exist time.
        localeResolver.setCookieMaxAge(3600);

        return localeResolver;
    }*/

    /* If user disable cookie then you can use SessionLocaleResolver instead. */
   @Bean(name = "localeResolver")
    public SessionLocaleResolver getSessionLocaleResolver(){
      // Create a SessionLocaleResolver object.
      SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        // Set default locale in session.
      localeResolver.setDefaultLocale(new Locale("fa"));
        return localeResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        ThemeChangeInterceptor themeChangeInterceptor = new ThemeChangeInterceptor();
        themeChangeInterceptor.setParamName("theme");
        registry.addInterceptor(themeChangeInterceptor);

        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        registry.addInterceptor(localeChangeInterceptor);
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // Register resource handler for CSS and JS
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/themesite/**").addResourceLocations("/themesite/");
                //.setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());

        // Register resource handler for images
      /*  registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/")
                .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());*/
    }
}

