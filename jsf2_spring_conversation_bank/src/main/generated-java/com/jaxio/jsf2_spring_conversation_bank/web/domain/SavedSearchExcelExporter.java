/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/domain/ExcelExporter.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package com.jaxio.jsf2_spring_conversation_bank.web.domain;

import javax.inject.Inject;
import javax.inject.Named;

import com.jaxio.jsf2_spring_conversation_bank.domain.SavedSearch;
import com.jaxio.jsf2_spring_conversation_bank.web.domain.support.GenericExcelExporter;
import com.jaxio.jsf2_spring_conversation_bank.web.faces.ConversationContextScoped;

/**
 * Exports to excel document {@link SavedSearch} search criteria and result. 
 */
@Named
@ConversationContextScoped
public class SavedSearchExcelExporter extends GenericExcelExporter<SavedSearch> {
    @Inject
    protected SavedSearchSearchForm sf;

    public SavedSearchExcelExporter() {
        super("savedSearch_name", "savedSearch_formClassname");
    }

    @Override
    protected void fillResultItem(int row, SavedSearch item) {
        int col = 0;
        setValue(row, col++, item.getName());
        setValue(row, col++, item.getFormClassname());
    }

    @Override
    public void fillSearchCriteria(int row) {
        useCriteriaSheet();

        setSelector(row++, 0, "savedSearch_name", sf.getNameSelector());
        setSelector(row++, 0, "savedSearch_formClassname", sf.getFormClassnameSelector());
        setSelectedEntities(row++, 0, "savedSearch_user", sf.getUserSelector().getSelected());
    }
}