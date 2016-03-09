/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-backend-jpa:src/test/java/service/RepositoryIT.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-backend-jpa
 */
package com.jaxio.jsf2_spring_conversation_bank.repository;

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

import com.jaxio.jsf2_spring_conversation_bank.domain.Transaction;

/**
 * Integration test on TransactionRepository
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
@Transactional
public class TransactionRepositoryIT {
    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(TransactionRepositoryIT.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private TransactionRepository transactionRepository;

    @Inject
    private TransactionGenerator transactionGenerator;

    @Test
    @Rollback
    public void saveAndGet() {
        Transaction transaction = transactionGenerator.getTransaction();

        // add it to a Set before saving (force equals/hashcode)
        Set<Transaction> set = newHashSet(transaction, transaction);
        assertThat(set).hasSize(1);

        transactionRepository.save(transaction);
        entityManager.flush();

        // reload it from cache and check equality
        Transaction model = new Transaction();
        model.setId(transaction.getId());
        assertThat(transaction).isEqualTo(transactionRepository.get(model));

        // clear cache to force reload from db
        entityManager.clear();

        // pk are equals...
        assertThat(transaction.getId()).isEqualTo(transactionRepository.get(model).getId());

        // but since you do not use a business key, equality is lost.
        assertThat(transaction).isNotEqualTo(transactionRepository.get(model));
    }

}