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

import com.jaxio.jsf2_spring_conversation_bank.domain.Account;
import com.jaxio.jsf2_spring_conversation_bank.domain.Account_;
import com.jaxio.jsf2_spring_conversation_bank.printer.support.GenericPrinter;

/**
 * {@link GenericPrinter} for {@link Account} 
 *
 * @see GenericPrinter
 * @see TypeAwarePrinter
 */
@Named
@Singleton
public class AccountPrinter extends GenericPrinter<Account> {
    public AccountPrinter() {
        super(Account.class, Account_.accountNumber, Account_.name);
    }

    @Override
    public String print(Account account, Locale locale) {
        if (account == null) {
            return "";
        }
        StringBuilder ret = new StringBuilder();
        appendIfNotEmpty(ret, account.getAccountNumber());
        appendIfNotEmpty(ret, account.getName());
        return ret.toString();
    }
}