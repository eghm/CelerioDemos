/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-backend-jpa:src/main/java/configuration/MessageSourceConfiguration.p.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-backend-jpa
 */
package com.jaxio.jsf2_spring_conversation_empty.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessageSourceConfiguration {
    /**
     * Base message source to handle internationalization<p>
     * Order of basenames matters, the first found property is returned 
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setFallbackToSystemLocale(false);
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasenames( // 
                // main resources
                "classpath:/localization/application", "classpath:/localization/messages", //
                // pages
                "classpath:/localization/pages/home", //
                "classpath:/localization/pages/login", //
                "classpath:/localization/pages/concurrentModificationResolution", //
                // default spring security messages
                "classpath:org/springframework/security/messages", //
                //  our bean validation messages
                "classpath:ValidationMessages", //
                // default conversion messages
                "classpath:javax/faces/Messages", //
                // generated domain resources
                "classpath:/localization/domain/Absent", //
                "classpath:/localization/domain/Absentlog", //
                "classpath:/localization/domain/Employee", //
                "classpath:/localization/domain/Empmanager", //
                // default bean validation messages 
                "classpath:org/hibernate/validator/ValidationMessages" //
        );
        return messageSource;
    }
}
