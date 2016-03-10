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

import com.jaxio.backend_jpa_bank.domain.Role;
import com.jaxio.backend_jpa_bank.util.ValueGenerator;

/**
 * Helper class to create transient entities instance for testing purposes.
 * Simple properties are pre-filled with random values.
 */
@Named
@Singleton
public class RoleGenerator {

    /**
     * Returns a new Role instance filled with random values.
     */
    public Role getRole() {
        Role role = new Role();

        // simple attributes follows
        role.setRoleName(ValueGenerator.getUniqueString(100));
        return role;
    }

}