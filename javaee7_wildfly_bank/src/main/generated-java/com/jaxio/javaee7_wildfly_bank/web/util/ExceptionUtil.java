/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-javaee7-frontend:src/main/java/util/ExceptionUtil.p.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/javaee-lab
 */
package com.jaxio.javaee7_wildfly_bank.web.util;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;

@ApplicationScoped
@Named
public class ExceptionUtil {

    /**
     * Use it during development as an action to throw exceptions and thus verify that your
     * error handling code is correct.
     */
    public void throwRuntimeException() {
        throw new RuntimeException("Just testing RuntimeException from ExceptionUtil ...");
    }

    public void throwDataAccessException() {
        throw new OptimisticLockException("Just testing OptimisticLockException from ExceptionUtil ...");
    }

    public static boolean isCausedBy(Throwable e, Class<?> cause) {
        Throwable current = e;
        while (current != null) {
            if (cause.isAssignableFrom(current.getClass())) {
                return true;
            }
            current = current.getCause();
        }
        return false;
    }
}