/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/domain/SearchForm.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package com.jaxio.jsf2_spring_conversation_empty.web.domain;

import static com.jaxio.jpa.querybyexample.PropertySelector.newPropertySelector;

import javax.inject.Named;

import com.jaxio.jpa.querybyexample.PropertySelector;
import com.jaxio.jpa.querybyexample.SearchParameters;
import com.jaxio.jsf2_spring_conversation_empty.domain.Employee;
import com.jaxio.jsf2_spring_conversation_empty.domain.Empmanager;
import com.jaxio.jsf2_spring_conversation_empty.domain.Empmanager_;
import com.jaxio.jsf2_spring_conversation_empty.web.domain.support.GenericSearchForm;
import com.jaxio.jsf2_spring_conversation_empty.web.faces.ConversationContextScoped;

/**
 * View Helper to search {@link Empmanager}.
 * It exposes a {@link Empmanager} instance so it can be used in search by-example-query.
 */
@Named
@ConversationContextScoped
public class EmpmanagerSearchForm extends GenericSearchForm<Empmanager, Integer, EmpmanagerSearchForm> {
    private static final long serialVersionUID = 1L;
    protected Empmanager empmanager = new Empmanager();
    protected PropertySelector<Empmanager, Integer> idSelector = newPropertySelector(Empmanager_.id);
    protected PropertySelector<Empmanager, String> divisionSelector = newPropertySelector(Empmanager_.division);
    protected PropertySelector<Empmanager, Employee> employeeSelector = newPropertySelector(Empmanager_.employee);

    public Empmanager getEmpmanager() {
        return empmanager;
    }

    @Override
    protected Empmanager getEntity() {
        return getEmpmanager();
    }

    @Override
    public EmpmanagerSearchForm newInstance() {
        return new EmpmanagerSearchForm();
    }

    @Override
    public SearchParameters toSearchParameters() {
        SearchParameters sp = searchParameters();
        sp.property(idSelector, divisionSelector);
        sp.property(employeeSelector);
        return sp;
    }

    @Override
    public void resetWithOther(EmpmanagerSearchForm other) {
        this.empmanager = other.getEmpmanager();
        this.idSelector = other.getIdSelector();
        this.divisionSelector = other.getDivisionSelector();
        this.employeeSelector = other.getEmployeeSelector();
    }

    // Property selectors
    public PropertySelector<Empmanager, Integer> getIdSelector() {
        return idSelector;
    }

    public PropertySelector<Empmanager, String> getDivisionSelector() {
        return divisionSelector;
    }

    // Relation selectors
    public PropertySelector<Empmanager, Employee> getEmployeeSelector() {
        return employeeSelector;
    }
}
