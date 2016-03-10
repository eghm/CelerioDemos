/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-backend-jpa:src/test/java/service/ModelGenerator.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-backend-jpa
 */
package com.jaxio.backend_jpa_bank.repository;

import javax.inject.Named;
import javax.inject.Singleton;

import com.jaxio.backend_jpa_bank.domain.Address;

/**
 * Helper class to create transient entities instance for testing purposes.
 * Simple properties are pre-filled with random values.
 */
@Named
@Singleton
public class AddressGenerator {

    /**
     * Returns a new Address instance filled with random values.
     */
    public Address getAddress() {
        Address address = new Address();

        // simple attributes follows
        address.setStreet("a");
        address.setZipCode("a");
        address.setCity("a");
        address.setCountry("a");
        return address;
    }

}