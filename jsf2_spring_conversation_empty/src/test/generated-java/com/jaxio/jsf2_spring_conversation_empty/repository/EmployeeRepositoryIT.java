/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-backend-jpa:src/test/java/service/RepositoryIT.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-backend-jpa
 */
package com.jaxio.jsf2_spring_conversation_empty.repository;

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

import com.jaxio.jsf2_spring_conversation_empty.domain.Employee;

/**
 * Integration test on EmployeeRepository
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
@Transactional
public class EmployeeRepositoryIT {
    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(EmployeeRepositoryIT.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private EmployeeRepository employeeRepository;

    @Inject
    private EmployeeGenerator employeeGenerator;

    @Test
    @Rollback
    public void saveAndGet() {
        Employee employee = employeeGenerator.getEmployee();

        // add it to a Set before saving (force equals/hashcode)
        Set<Employee> set = newHashSet(employee, employee);
        assertThat(set).hasSize(1);

        employeeRepository.save(employee);
        entityManager.flush();

        // reload it from cache and check equality
        Employee model = new Employee();
        model.setId(employee.getId());
        assertThat(employee).isEqualTo(employeeRepository.get(model));

        // clear cache to force reload from db
        entityManager.clear();

        // since you use a business key, equality must be preserved.
        assertThat(employee).isEqualTo(employeeRepository.get(model));
    }

}