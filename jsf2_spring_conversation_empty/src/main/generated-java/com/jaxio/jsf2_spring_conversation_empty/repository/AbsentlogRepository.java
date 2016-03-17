/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-backend-jpa:src/main/java/repository/Repository.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-backend-jpa
 */
package com.jaxio.jsf2_spring_conversation_empty.repository;

import javax.inject.Named;
import javax.inject.Singleton;

import com.jaxio.jpa.querybyexample.GenericRepository;
import com.jaxio.jsf2_spring_conversation_empty.domain.Absentlog;

/**
 * {@link GenericRepository} for {@link Absentlog} 
 */
@Named
@Singleton
public class AbsentlogRepository extends GenericRepository<Absentlog, Integer> {

    public AbsentlogRepository() {
        super(Absentlog.class);
    }

    @Override
    public Absentlog getNew() {
        return new Absentlog();
    }

    @Override
    public Absentlog getNewWithDefaults() {
        return getNew().withDefaults();
    }
}