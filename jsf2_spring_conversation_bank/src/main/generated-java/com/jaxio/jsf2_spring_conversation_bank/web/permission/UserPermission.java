/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/permission/Permission.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package com.jaxio.jsf2_spring_conversation_bank.web.permission;

import javax.inject.Named;
import javax.inject.Singleton;

import com.jaxio.jsf2_spring_conversation_bank.domain.User;
import com.jaxio.jsf2_spring_conversation_bank.web.permission.support.GenericPermission;

@Named
@Singleton
public class UserPermission extends GenericPermission<User> {
    public UserPermission() {
        super(User.class);
    }
}