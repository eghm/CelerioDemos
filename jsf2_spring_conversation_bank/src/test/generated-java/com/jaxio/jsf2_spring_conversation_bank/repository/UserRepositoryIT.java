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
import static com.jaxio.jpa.querybyexample.PropertySelector.newPropertySelector;
import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.serializer.DefaultDeserializer;
import org.springframework.core.serializer.DefaultSerializer;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jaxio.jpa.querybyexample.SearchParameters;
import com.jaxio.jsf2_spring_conversation_bank.domain.User;
import com.jaxio.jsf2_spring_conversation_bank.domain.User_;

/**
 * Integration test on UserRepository
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
@Transactional
public class UserRepositoryIT {
    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(UserRepositoryIT.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private UserRepository userRepository;

    @Inject
    private UserGenerator userGenerator;

    @Test
    @Rollback
    public void saveAndGet() {
        User user = userGenerator.getUser();

        // add it to a Set before saving (force equals/hashcode)
        Set<User> set = newHashSet(user, user);
        assertThat(set).hasSize(1);

        userRepository.save(user);
        entityManager.flush();

        // reload it from cache and check equality
        User model = new User();
        model.setId(user.getId());
        assertThat(user).isEqualTo(userRepository.get(model));

        // clear cache to force reload from db
        entityManager.clear();

        // since you use a business key, equality must be preserved.
        assertThat(user).isEqualTo(userRepository.get(model));
    }

    @Test
    @Rollback
    public void saveAndGetWithPropertySelector() {
        User user = userGenerator.getUser();

        // add it to a Set before saving (force equals/hashcode)
        Set<User> set = newHashSet(user, user);
        assertThat(set).hasSize(1);

        userRepository.save(user);
        entityManager.flush();

        // reload it from cache and check equality
        SearchParameters searchParameters = new SearchParameters();
        searchParameters.property(newPropertySelector(User_.id).selected(user.getId()));

        // clear cache to force reload from db
        entityManager.clear();

        SearchParameters ser = null;
        try {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            new DefaultSerializer().serialize(searchParameters, stream);
            byte[] bytes = stream.toByteArray();
            ser = (SearchParameters) new DefaultDeserializer().deserialize(new ByteArrayInputStream(bytes));
        } catch (Exception e) {
            fail();
        }

        // pk are equals...
        assertThat(user).isEqualTo(userRepository.findUnique(ser));
    }

}