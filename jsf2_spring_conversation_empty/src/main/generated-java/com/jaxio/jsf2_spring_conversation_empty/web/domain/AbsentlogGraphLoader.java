/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/domain/GraphLoader.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package com.jaxio.jsf2_spring_conversation_empty.web.domain;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.jaxio.jpa.querybyexample.EntityGraphLoader;
import com.jaxio.jsf2_spring_conversation_empty.domain.Absentlog;
import com.jaxio.jsf2_spring_conversation_empty.repository.AbsentlogRepository;

/**
 * Preloads the {@link Absentlog} associations required by the view layer.
 * 
 * Do not use other GraphLoaders in this GraphLoader. 
 */
@Named
@Singleton
public class AbsentlogGraphLoader extends EntityGraphLoader<Absentlog, Integer> {
    // required by cglib to create a proxy around the object as we are using the @Transactional annotation
    protected AbsentlogGraphLoader() {
        super();
    }

    @Inject
    public AbsentlogGraphLoader(AbsentlogRepository absentlogRepository) {
        super(absentlogRepository);
    }

    @Override
    public void loadGraph(Absentlog absentlog) {
        loadSingular(absentlog.getEmployee());
        loadSingular(absentlog.getAbs());
    }
}