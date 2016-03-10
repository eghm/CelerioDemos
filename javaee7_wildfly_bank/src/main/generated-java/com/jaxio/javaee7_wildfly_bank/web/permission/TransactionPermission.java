/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-javaee7-frontend:src/main/java/permission/Permission.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/javaee-lab
 */
package com.jaxio.javaee7_wildfly_bank.web.permission;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.jaxio.javaee7_wildfly_bank.domain.Transaction;
import com.jaxio.javaee7_wildfly_bank.web.permission.support.GenericPermission;

@ApplicationScoped
@Named
public class TransactionPermission extends GenericPermission<Transaction> {
    public TransactionPermission() {
        init(Transaction.class);
    }
}