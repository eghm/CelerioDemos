/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/domain/GraphLoader.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package com.jaxio.jsf2_spring_conversation_bank.web.domain;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.jaxio.jpa.querybyexample.EntityGraphLoader;
import com.jaxio.jsf2_spring_conversation_bank.domain.SavedSearch;
import com.jaxio.jsf2_spring_conversation_bank.repository.SavedSearchRepository;

/**
 * Preloads the {@link SavedSearch} associations required by the view layer.
 * 
 * Do not use other GraphLoaders in this GraphLoader. 
 */
@Named
@Singleton
public class SavedSearchGraphLoader extends EntityGraphLoader<SavedSearch, Integer> {
    // required by cglib to create a proxy around the object as we are using the @Transactional annotation
    protected SavedSearchGraphLoader() {
        super();
    }

    @Inject
    public SavedSearchGraphLoader(SavedSearchRepository savedSearchRepository) {
        super(savedSearchRepository);
    }

    @Override
    public void loadGraph(SavedSearch savedSearch) {
        loadSingular(savedSearch.getUser());
    }
}