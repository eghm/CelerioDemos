/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-backend-jpa:src/main/java/util/ResourcesUtil.p.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-backend-jpa
 */
package com.jaxio.backend_jpa_bank.util;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Lazy;

import com.jaxio.backend_jpa_bank.context.LocaleHolder;

/**
 * ResourcesUtil allows you to retrieve localized resources for the locale present in the current thread of execution.
 * It can be used from both Spring beans (simple dependency injection) and from non spring beans. In the later case,
 * you obtain the reference thanks to the static method ResourcesUtil.getInstance()
 */
@Named
@Singleton
@Lazy(false)
public class ResourcesUtil {
    private static ResourcesUtil instance;

    public static ResourcesUtil getInstance() {
        return instance;
    }

    @Inject
    private MessageSource messageSource;

    public ResourcesUtil() {
        instance = this;
    }

    /**
     * Return the {@link MessageSource} that backs this ResourcesUtil.
     */
    public MessageSource getMessageSource() {
        return messageSource;
    }

    // Note: do not replace the 3 methods below by one taking Object... args as second argument, EL 3.0 would cry.

    public String getProperty(String key) {
        if (key == null) {
            return "";
        }

        return messageSource.getMessage(key, new Object[0], LocaleHolder.getLocale());
    }

    public String getProperty(String key, Object arg) {
        if (key == null) {
            return "";
        }

        return messageSource.getMessage(key, new Object[] { arg }, LocaleHolder.getLocale());
    }

    /**
     * Return the property value for the contextual locale.
     * If no value is found, the given key is returned.
     */
    public String getProperty(String key, Object[] args) {
        if (key == null) {
            return "";
        }

        return messageSource.getMessage(key, args, LocaleHolder.getLocale());
    }

    /**
     * Same as {@link #getProperty(String, Object...)} but use the count to choose the proper key.
     * Used when the message varies depending on the context. 
     * <p>
     * For example: 
     * <ul>
     * <li>there is no result</li>
     * <li>there is one result</li>
     * <li>there are n results</li>
     * </ul>
     * @param key the base key
     */
    public String getPluralableProperty(String key, int count) {
        if (key == null) {
            return "";
        }

        switch (count) {
        case 0:
            return getProperty(key + "_0");
        case 1:
            return getProperty(key + "_1");
        default:
            return getProperty(key + "_n", count);
        }
    }
}