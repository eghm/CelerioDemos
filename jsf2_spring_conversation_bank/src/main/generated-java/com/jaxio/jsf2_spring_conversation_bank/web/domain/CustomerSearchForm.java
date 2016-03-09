/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/domain/SearchForm.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package com.jaxio.jsf2_spring_conversation_bank.web.domain;

import static com.jaxio.jpa.querybyexample.PropertySelector.newPropertySelector;

import javax.inject.Named;

import com.jaxio.jpa.querybyexample.PropertySelector;
import com.jaxio.jpa.querybyexample.SearchParameters;
import com.jaxio.jsf2_spring_conversation_bank.domain.Address;
import com.jaxio.jsf2_spring_conversation_bank.domain.Customer;
import com.jaxio.jsf2_spring_conversation_bank.domain.Customer_;
import com.jaxio.jsf2_spring_conversation_bank.web.domain.support.GenericSearchForm;
import com.jaxio.jsf2_spring_conversation_bank.web.faces.ConversationContextScoped;

/**
 * View Helper to search {@link Customer}.
 * It exposes a {@link Customer} instance so it can be used in search by-example-query.
 */
@Named
@ConversationContextScoped
public class CustomerSearchForm extends GenericSearchForm<Customer, Integer, CustomerSearchForm> {
    private static final long serialVersionUID = 1L;
    protected Customer customer = new Customer();
    protected PropertySelector<Customer, String> companyNameSelector = newPropertySelector(Customer_.companyName);
    protected PropertySelector<Customer, Address> addressSelector = newPropertySelector(Customer_.address);

    public Customer getCustomer() {
        return customer;
    }

    @Override
    protected Customer getEntity() {
        return getCustomer();
    }

    @Override
    public CustomerSearchForm newInstance() {
        return new CustomerSearchForm();
    }

    @Override
    public SearchParameters toSearchParameters() {
        SearchParameters sp = searchParameters();
        sp.property(companyNameSelector);
        sp.property(addressSelector);
        return sp;
    }

    @Override
    public void resetWithOther(CustomerSearchForm other) {
        this.customer = other.getCustomer();
        this.companyNameSelector = other.getCompanyNameSelector();
        this.addressSelector = other.getAddressSelector();
    }

    // Property selectors
    public PropertySelector<Customer, String> getCompanyNameSelector() {
        return companyNameSelector;
    }

    // Relation selectors
    public PropertySelector<Customer, Address> getAddressSelector() {
        return addressSelector;
    }
}
