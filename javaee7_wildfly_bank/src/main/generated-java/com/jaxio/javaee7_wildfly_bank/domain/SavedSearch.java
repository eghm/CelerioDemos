/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-javaee7-backend:src/main/java/domain/Entity.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/javaee-lab
 */
package com.jaxio.javaee7_wildfly_bank.domain;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.common.base.Objects;
import com.jaxio.jpa.querybyexample.Identifiable;

@Entity
@Table(name = "SAVED_SEARCH")
public class SavedSearch implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(SavedSearch.class.getName());

    // Raw attributes
    private Integer id;
    private String name;
    private String formClassname;
    private byte[] formContent;

    // Many to one
    private User user;

    @Override
    public String entityClassName() {
        return SavedSearch.class.getSimpleName();
    }

    // -- [id] ------------------------

    @Override
    @Column(name = "ID", precision = 10)
    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public SavedSearch id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    @XmlTransient
    public boolean isIdSet() {
        return id != null;
    }

    // -- [name] ------------------------

    @NotEmpty
    @Size(max = 128)
    @Column(name = "NAME", nullable = false, length = 128)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SavedSearch name(String name) {
        setName(name);
        return this;
    }

    // -- [formClassname] ------------------------

    @NotEmpty
    @Size(max = 256)
    @Column(name = "FORM_CLASSNAME", nullable = false, length = 256)
    public String getFormClassname() {
        return formClassname;
    }

    public void setFormClassname(String formClassname) {
        this.formClassname = formClassname;
    }

    public SavedSearch formClassname(String formClassname) {
        setFormClassname(formClassname);
        return this;
    }

    // -- [formContent] ------------------------

    @Basic(fetch = LAZY)
    @Column(name = "FORM_CONTENT")
    @Lob
    public byte[] getFormContent() {
        return formContent;
    }

    public void setFormContent(byte[] formContent) {
        this.formContent = formContent;
    }

    public SavedSearch formContent(byte[] formContent) {
        setFormContent(formContent);
        return this;
    }

    // -----------------------------------------------------------------
    // Many to One support
    // -----------------------------------------------------------------

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: SavedSearch.user ==> User.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @JoinColumn(name = "USER_ID")
    @ManyToOne(cascade = { PERSIST, MERGE }, fetch = LAZY)
    public User getUser() {
        return user;
    }

    /**
     * Set the {@link #user} without adding this SavedSearch instance on the passed {@link #user}
     */
    public void setUser(User user) {
        this.user = user;
    }

    public SavedSearch user(User user) {
        setUser(user);
        return this;
    }

    /**
     * Apply the default values.
     */
    public SavedSearch withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof SavedSearch && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this SavedSearch instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this) //
                .add("id", getId()) //
                .add("name", getName()) //
                .add("formClassname", getFormClassname()) //
                .add("formContent", getFormContent()) //
                .toString();
    }
}