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

import com.jaxio.jsf2_spring_conversation_bank.domain.Address;
import com.jaxio.jsf2_spring_conversation_bank.domain.Address_;
import com.jaxio.jsf2_spring_conversation_bank.printer.support.GenericPrinter;

/**
 * {@link GenericPrinter} for {@link Address} 
 *
 * @see GenericPrinter
 * @see TypeAwarePrinter
 */
@Named
@Singleton
public class AddressPrinter extends GenericPrinter<Address> {
    public AddressPrinter() {
        super(Address.class, Address_.city, Address_.country);
    }

    @Override
    public String print(Address address, Locale locale) {
        if (address == null) {
            return "";
        }
        StringBuilder ret = new StringBuilder();
        appendIfNotEmpty(ret, address.getCity());
        appendIfNotEmpty(ret, address.getCountry());
        return ret.toString();
    }
}