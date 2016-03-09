/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/configuration/ViewScopeConfiguration.p.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package com.jaxio.jsf2_spring_conversation_bank.web.configuration;

import static com.google.common.collect.Maps.newHashMap;

import java.util.Map;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jaxio.jsf2_spring_conversation_bank.web.faces.ConversationContextScope;
import com.jaxio.jsf2_spring_conversation_bank.web.faces.ConversationScope;
import com.jaxio.jsf2_spring_conversation_bank.web.faces.ViewScope;

@Configuration
public class ViewScopeConfiguration {
    @Bean
    public static CustomScopeConfigurer viewScope() {
        CustomScopeConfigurer scope = new CustomScopeConfigurer();
        Map<String, Object> map = newHashMap();
        map.put("view", new ViewScope());
        map.put("conversationContext", new ConversationContextScope());
        map.put("conversation", new ConversationScope());
        scope.setScopes(map);
        return scope;
    }
}