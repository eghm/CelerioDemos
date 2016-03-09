/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-backend-jpa:src/main/java/printer/Printer.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-backend-jpa
 */
package com.jaxio.jsf2_spring_conversation_bank.printer;

import java.util.Locale;

import javax.inject.Named;
import javax.inject.Singleton;

import com.jaxio.jsf2_spring_conversation_bank.domain.User;
import com.jaxio.jsf2_spring_conversation_bank.domain.User_;
import com.jaxio.jsf2_spring_conversation_bank.printer.support.GenericPrinter;

/**
 * {@link GenericPrinter} for {@link User} 
 *
 * @see GenericPrinter
 * @see TypeAwarePrinter
 */
@Named
@Singleton
public class UserPrinter extends GenericPrinter<User> {
    public UserPrinter() {
        super(User.class, User_.username, User_.firstName, User_.lastName);
    }

    @Override
    public String print(User user, Locale locale) {
        if (user == null) {
            return "";
        }
        StringBuilder ret = new StringBuilder();
        appendIfNotEmpty(ret, user.getUsername());
        appendIfNotEmpty(ret, user.getFirstName());
        appendIfNotEmpty(ret, user.getLastName());
        return ret.toString();
    }
}