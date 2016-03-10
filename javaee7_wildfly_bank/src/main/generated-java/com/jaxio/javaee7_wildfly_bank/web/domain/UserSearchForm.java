/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-javaee7-frontend:src/main/java/domain/SearchForm.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/javaee-lab
 */
package com.jaxio.javaee7_wildfly_bank.web.domain;

import static com.jaxio.jpa.querybyexample.PropertySelector.newPropertySelector;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.jaxio.javaee7_wildfly_bank.domain.Civility;
import com.jaxio.javaee7_wildfly_bank.domain.Role;
import com.jaxio.javaee7_wildfly_bank.domain.User;
import com.jaxio.javaee7_wildfly_bank.domain.User_;
import com.jaxio.javaee7_wildfly_bank.web.domain.support.GenericSearchForm;
import com.jaxio.jpa.querybyexample.PropertySelector;
import com.jaxio.jpa.querybyexample.SearchParameters;
import com.jaxio.jpa.querybyexample.TermSelector;

/**
 * View Helper to search {@link User}.
 * It exposes a {@link User} instance so it can be used in search by-example-query.
 */
@ViewScoped
@Named
public class UserSearchForm extends GenericSearchForm<User, Integer, UserSearchForm> {
    private static final long serialVersionUID = 1L;

    // full text search (applied first)
    protected TermSelector emailTermSelector = new TermSelector(User_.email);
    protected TermSelector firstNameTermSelector = new TermSelector(User_.firstName);
    protected TermSelector lastNameTermSelector = new TermSelector(User_.lastName);

    // classic search
    protected User user = new User();
    protected PropertySelector<User, String> usernameSelector = newPropertySelector(User_.username);
    protected PropertySelector<User, String> passwordSelector = newPropertySelector(User_.password);
    protected PropertySelector<User, String> emailSelector = newPropertySelector(User_.email);
    protected PropertySelector<User, Boolean> isEnabledSelector = newPropertySelector(User_.isEnabled);
    protected PropertySelector<User, Civility> civilitySelector = newPropertySelector(User_.civility);
    protected PropertySelector<User, String> firstNameSelector = newPropertySelector(User_.firstName);
    protected PropertySelector<User, String> lastNameSelector = newPropertySelector(User_.lastName);
    protected PropertySelector<User, Role> securityRolesSelector = newPropertySelector(false, User_.securityRoles);

    public User getUser() {
        return user;
    }

    @Override
    protected User getEntity() {
        return getUser();
    }

    @Override
    public UserSearchForm newInstance() {
        return new UserSearchForm();
    }

    @Override
    public SearchParameters toSearchParameters() {
        SearchParameters sp = searchParameters();
        sp.term(termsOnAll, emailTermSelector, firstNameTermSelector, lastNameTermSelector);
        sp.property(usernameSelector, passwordSelector, emailSelector, isEnabledSelector, civilitySelector, firstNameSelector, lastNameSelector);
        sp.property(securityRolesSelector);
        return sp;
    }

    @Override
    public void resetWithOther(UserSearchForm other) {
        this.user = other.getUser();
        this.termsOnAll = other.getTermsOnAll();
        this.emailTermSelector = other.getEmailTermSelector();
        this.firstNameTermSelector = other.getFirstNameTermSelector();
        this.lastNameTermSelector = other.getLastNameTermSelector();
        this.usernameSelector = other.getUsernameSelector();
        this.passwordSelector = other.getPasswordSelector();
        this.emailSelector = other.getEmailSelector();
        this.isEnabledSelector = other.getIsEnabledSelector();
        this.civilitySelector = other.getCivilitySelector();
        this.firstNameSelector = other.getFirstNameSelector();
        this.lastNameSelector = other.getLastNameSelector();
        this.securityRolesSelector = other.getSecurityRolesSelector();
    }

    // Term selectors    
    public TermSelector getEmailTermSelector() {
        return emailTermSelector;
    }

    public TermSelector getFirstNameTermSelector() {
        return firstNameTermSelector;
    }

    public TermSelector getLastNameTermSelector() {
        return lastNameTermSelector;
    }

    // Property selectors
    public PropertySelector<User, String> getUsernameSelector() {
        return usernameSelector;
    }

    public PropertySelector<User, String> getPasswordSelector() {
        return passwordSelector;
    }

    public PropertySelector<User, String> getEmailSelector() {
        return emailSelector;
    }

    public PropertySelector<User, Boolean> getIsEnabledSelector() {
        return isEnabledSelector;
    }

    public PropertySelector<User, Civility> getCivilitySelector() {
        return civilitySelector;
    }

    public PropertySelector<User, String> getFirstNameSelector() {
        return firstNameSelector;
    }

    public PropertySelector<User, String> getLastNameSelector() {
        return lastNameSelector;
    }

    // Relation selectors
    public PropertySelector<User, Role> getSecurityRolesSelector() {
        return securityRolesSelector;
    }
}
