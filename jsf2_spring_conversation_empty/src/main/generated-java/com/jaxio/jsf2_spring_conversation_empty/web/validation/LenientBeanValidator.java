/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/validation/LenientBeanValidator.p.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package com.jaxio.jsf2_spring_conversation_empty.web.validation;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.BeanValidator;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

/**
 * Disables validation for certain actions in order to let the user navigate to sub view
 * without loosing (potentially invalid) data entered in input fields.
 *
 * _HACK_ This setting is tricky. It circumvents a JSF limitation.
 */
@Named
@Scope(SCOPE_PROTOTYPE)
public class LenientBeanValidator extends BeanValidator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) {
        if (ConditionalValidatorUtil.doValidation(context)) {
            super.validate(context, component, value);
        }
    }
}
