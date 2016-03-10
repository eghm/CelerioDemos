/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-javaee7-backend:src/main/java/printer/Printer.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/javaee-lab
 */
package com.jaxio.javaee7_wildfly_bank.printer;

import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.jaxio.javaee7_wildfly_bank.domain.SavedSearch;
import com.jaxio.javaee7_wildfly_bank.domain.SavedSearch_;
import com.jaxio.javaee7_wildfly_bank.printer.support.GenericPrinter;

/**
 * {@link GenericPrinter} for {@link SavedSearch} 
 *
 * @see GenericPrinter
 * @see TypeAwarePrinter
 */
@ApplicationScoped
@Named
public class SavedSearchPrinter extends GenericPrinter<SavedSearch> {
    @PostConstruct
    public void init() {
        init(SavedSearch.class, SavedSearch_.name);
    }

    @Override
    public String print(SavedSearch savedSearch, Locale locale) {
        if (savedSearch == null) {
            return "";
        }
        StringBuilder ret = new StringBuilder();
        appendIfNotEmpty(ret, savedSearch.getName());
        return ret.toString();
    }
}