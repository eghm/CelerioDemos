/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-backend-jpa:src/test/java/service/RepositoryIT.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-backend-jpa
 */
package com.jaxio.backend_jpa_bank.repository;

import static com.google.common.collect.Sets.newHashSet;
import static org.fest.assertions.Assertions.assertThat;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jaxio.backend_jpa_bank.domain.Currency;

/**
 * Integration test on CurrencyRepository
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
@Transactional
public class CurrencyRepositoryIT {
    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(CurrencyRepositoryIT.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private CurrencyRepository currencyRepository;

    @Inject
    private CurrencyGenerator currencyGenerator;

    @Test
    @Rollback
    public void saveAndGet() {
        Currency currency = currencyGenerator.getCurrency();

        // add it to a Set before saving (force equals/hashcode)
        Set<Currency> set = newHashSet(currency, currency);
        assertThat(set).hasSize(1);

        currencyRepository.save(currency);
        entityManager.flush();

        // reload it from cache and check equality
        Currency model = new Currency();
        model.setId(currency.getId());
        assertThat(currency).isEqualTo(currencyRepository.get(model));

        // clear cache to force reload from db
        entityManager.clear();

        // pk are equals...
        assertThat(currency.getId()).isEqualTo(currencyRepository.get(model).getId());

        // but since you do not use a business key, equality is lost.
        assertThat(currency).isNotEqualTo(currencyRepository.get(model));
    }

}