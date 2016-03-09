/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/domain/EditForm.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package com.jaxio.jsf2_spring_conversation_bank.web.domain;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.jaxio.jsf2_spring_conversation_bank.domain.Account;
import com.jaxio.jsf2_spring_conversation_bank.domain.Address;
import com.jaxio.jsf2_spring_conversation_bank.domain.Customer;
import com.jaxio.jsf2_spring_conversation_bank.domain.Customer_;
import com.jaxio.jsf2_spring_conversation_bank.repository.CustomerRepository;
import com.jaxio.jsf2_spring_conversation_bank.web.domain.support.GenericEditForm;
import com.jaxio.jsf2_spring_conversation_bank.web.domain.support.GenericToManyAssociation;
import com.jaxio.jsf2_spring_conversation_bank.web.domain.support.GenericToOneAssociation;
import com.jaxio.jsf2_spring_conversation_bank.web.faces.ConversationContextScoped;
import com.jaxio.jsf2_spring_conversation_bank.web.util.TabBean;

/**
 * View Helper/Controller to edit {@link Customer}.
 */
@Named
@ConversationContextScoped
public class CustomerEditForm extends GenericEditForm<Customer, Integer> {
    @Inject
    protected CustomerController customerController;
    @Inject
    protected AddressController addressController;
    protected GenericToOneAssociation<Address, Integer> address;
    @Inject
    protected AccountController accountController;
    protected GenericToManyAssociation<Account, Integer> accounts;
    protected TabBean tabBean = new TabBean();

    @Inject
    public CustomerEditForm(CustomerRepository customerRepository, CustomerGraphLoader customerGraphLoader) {
        super(customerRepository, customerGraphLoader);
    }

    /**
     * View helper to store the x-to-many associations tab's index. 
     */
    @Override
    public TabBean getTabBean() {
        return tabBean;
    }

    /**
     * The entity to edit/view.
     */
    public Customer getCustomer() {
        return getEntity();
    }

    public String print() {
        return customerController.print(getCustomer());
    }

    @PostConstruct
    void setupAddressActions() {
        address = new GenericToOneAssociation<Address, Integer>(addressController, Customer_.address) {
            @Override
            protected Address get() {
                return getCustomer().getAddress();
            }

            @Override
            protected void set(Address address) {
                getCustomer().setAddress(address);
            }
        };
    }

    public GenericToOneAssociation<Address, Integer> getAddress() {
        return address;
    }

    @PostConstruct
    void setupAccountsActions() {
        accounts = new GenericToManyAssociation<Account, Integer>(getCustomer().getAccounts(), accountController, Customer_.accounts) {
            @Override
            protected void remove(Account account) {
                getCustomer().removeAccount(account);
            }

            @Override
            protected void add(Account account) {
                getCustomer().addAccount(account);
            }

            @Override
            protected void onCreate(Account account) {
                account.setCustomer(getCustomer()); // for display
            }
        };
    }

    public GenericToManyAssociation<Account, Integer> getAccounts() {
        return accounts;
    }
}
