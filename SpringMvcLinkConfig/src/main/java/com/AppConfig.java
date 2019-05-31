package com;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

//@EnableWebMvc
@Configuration
public class AppConfig {

    @Autowired
    ApplicationContext applicationContext;

    @Bean
    public SpringResourceTemplateResolver springResourceTemplateResolver(){
        SpringResourceTemplateResolver spReTeRe =
                new SpringResourceTemplateResolver();
        spReTeRe.setApplicationContext(this.applicationContext);
        spReTeRe.setPrefix("classpath:/templates/");
        spReTeRe.setCacheable(false);
        spReTeRe.setSuffix(".html");
        spReTeRe.setTemplateMode(TemplateMode.HTML);
        spReTeRe.setCharacterEncoding("UTF-8");
        return spReTeRe;
    }

    @Bean
    public SpringTemplateEngine springTemplateEngine(){
        SpringTemplateEngine sPTeEn = new SpringTemplateEngine();
        sPTeEn.setTemplateResolver(springResourceTemplateResolver());
        sPTeEn.setEnableSpringELCompiler(true);
        return sPTeEn;
    }

    @Bean
    public ViewResolver viewResolver(){
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(springTemplateEngine());
        return thymeleafViewResolver;
    }
}
