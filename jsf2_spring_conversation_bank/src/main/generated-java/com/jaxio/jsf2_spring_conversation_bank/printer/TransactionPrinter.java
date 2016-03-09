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

import com.jaxio.jsf2_spring_conversation_bank.domain.Transaction;
import com.jaxio.jsf2_spring_conversation_bank.domain.Transaction_;
import com.jaxio.jsf2_spring_conversation_bank.printer.support.GenericPrinter;

/**
 * {@link GenericPrinter} for {@link Transaction} 
 *
 * @see GenericPrinter
 * @see TypeAwarePrinter
 */
@Named
@Singleton
public class TransactionPrinter extends GenericPrinter<Transaction> {
    public TransactionPrinter() {
        super(Transaction.class, Transaction_.description);
    }

    @Override
    public String print(Transaction transaction, Locale locale) {
        if (transaction == null) {
            return "";
        }
        StringBuilder ret = new StringBuilder();
        appendIfNotEmpty(ret, transaction.getDescription());
        return ret.toString();
    }
}