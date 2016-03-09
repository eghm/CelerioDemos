/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/domain/LazyDataModel.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package com.jaxio.jsf2_spring_conversation_bank.web.domain;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;

import com.jaxio.jsf2_spring_conversation_bank.domain.SavedSearch;
import com.jaxio.jsf2_spring_conversation_bank.repository.SavedSearchRepository;
import com.jaxio.jsf2_spring_conversation_bank.web.domain.support.GenericLazyDataModel;
import com.jaxio.jsf2_spring_conversation_bank.web.faces.ConversationContextScoped;

/**
 * Provide PrimeFaces {@link LazyDataModel} for {@link SavedSearch}
 */
@Named
@ConversationContextScoped
public class SavedSearchLazyDataModel extends GenericLazyDataModel<SavedSearch, Integer, SavedSearchSearchForm> {
    private static final long serialVersionUID = 1L;

    @Inject
    public SavedSearchLazyDataModel(SavedSearchRepository savedSearchRepository, SavedSearchController savedSearchController,
            SavedSearchSearchForm savedSearchSearchForm, SavedSearchExcelExporter savedSearchExcelExporter) {
        super(savedSearchRepository, savedSearchController, savedSearchSearchForm, savedSearchExcelExporter);
    }
}