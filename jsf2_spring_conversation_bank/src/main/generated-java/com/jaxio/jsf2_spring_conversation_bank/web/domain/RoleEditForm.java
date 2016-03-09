/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/domain/EditForm.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package com.jaxio.jsf2_spring_conversation_bank.web.domain;

import javax.inject.Inject;
import javax.inject.Named;

import com.jaxio.jsf2_spring_conversation_bank.domain.Role;
import com.jaxio.jsf2_spring_conversation_bank.repository.RoleRepository;
import com.jaxio.jsf2_spring_conversation_bank.web.domain.support.GenericEditForm;
import com.jaxio.jsf2_spring_conversation_bank.web.faces.ConversationContextScoped;

/**
 * View Helper/Controller to edit {@link Role}.
 */
@Named
@ConversationContextScoped
public class RoleEditForm extends GenericEditForm<Role, Integer> {
    @Inject
    protected RoleController roleController;

    @Inject
    public RoleEditForm(RoleRepository roleRepository) {
        super(roleRepository);
    }

    /**
     * The entity to edit/view.
     */
    public Role getRole() {
        return getEntity();
    }

    public String print() {
        return roleController.print(getRole());
    }
}
