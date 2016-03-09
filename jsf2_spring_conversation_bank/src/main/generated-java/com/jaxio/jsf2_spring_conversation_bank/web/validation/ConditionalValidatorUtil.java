/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/validation/ConditionalValidatorUtil.p.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package com.jaxio.jsf2_spring_conversation_bank.web.validation;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

/**
 * Central place for conditional validation policy.
 */
public final class ConditionalValidatorUtil {
    private static final List<String> actionsRequiringValidation = newArrayList( //
            "form:saveAndClose", // close button present in main form (see saveButton.xml)
            "form:save", // button present in main form (see saveButton.xml)
            "form:askForSaveDialogYes", // button present in ask for save dialog
            "form:ok" // button present in sub-edit (see saveButton.xml)

    );

    private ConditionalValidatorUtil() {
    }

    /**
     * Depending on which action was triggered, decides if validation should take place or not.
     * 
     * @return true if validation should be performed, false otherwise.
     */
    public static boolean doValidation(FacesContext context) {
        Map<String, String[]> requestParameterValuesMap = context.getExternalContext().getRequestParameterValuesMap();

        for (String action : actionsRequiringValidation) {
            if (requestParameterValuesMap.containsKey(action)) {
                return true;
            }
        }
        return false;
    }
}
