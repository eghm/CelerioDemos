/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-javaee7-backend:src/test/java/service/ModelGenerator.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/javaee-lab
 */
package com.jaxio.javaee7_wildfly_bank.repository;

import javax.inject.Named;
import javax.inject.Singleton;

import com.jaxio.javaee7_wildfly_bank.domain.Customer;

/**
 * Helper class to create transient entities instance for testing purposes.
 * Simple properties are pre-filled with random values.
 */
@Named
@Singleton
public class CustomerGenerator {

    /**
     * Returns a new Customer instance filled with random values.
     */
    public Customer getCustomer() {
        Customer customer = new Customer();

        // simple attributes follows
        customer.setCompanyName("a");
        customer.setContractBinary("dummy".getBytes());
        customer.setContractFileName("dummy.txt");
        customer.setContractContentType("application/text");
        customer.setContractSize(1);
        return customer;
    }

}