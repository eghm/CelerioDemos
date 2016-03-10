/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-javaee7-backend:src/main/java/domain/Entity.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/javaee-lab
 */
package com.jaxio.javaee7_wildfly_bank.domain;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.common.base.Objects;
import com.jaxio.jpa.querybyexample.Identifiable;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(Customer.class.getName());

    // Raw attributes
    private Integer id;
    private String companyName;
    private byte[] contractBinary;
    private String contractFileName;
    private String contractContentType;
    private Integer contractSize;
    private Integer version;

    // Many to one
    private Address address;

    // One to many
    private List<Account> accounts = new ArrayList<Account>();

    @Override
    public String entityClassName() {
        return Customer.class.getSimpleName();
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

    public Customer id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    @XmlTransient
    public boolean isIdSet() {
        return id != null;
    }

    // -- [companyName] ------------------------

    @NotEmpty
    @Size(max = 100)
    @Column(name = "COMPANY_NAME", nullable = false, length = 100)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Customer companyName(String companyName) {
        setCompanyName(companyName);
        return this;
    }

    // -- [contractBinary] ------------------------

    @Basic(fetch = LAZY)
    @Column(name = "CONTRACT_BINARY")
    @Lob
    public byte[] getContractBinary() {
        return contractBinary;
    }

    public void setContractBinary(byte[] contractBinary) {
        this.contractBinary = contractBinary;
    }

    public Customer contractBinary(byte[] contractBinary) {
        setContractBinary(contractBinary);
        return this;
    }

    // -- [contractFileName] ------------------------

    @Size(max = 100)
    @Column(name = "CONTRACT_FILE_NAME", length = 100)
    public String getContractFileName() {
        return contractFileName;
    }

    public void setContractFileName(String contractFileName) {
        this.contractFileName = contractFileName;
    }

    public Customer contractFileName(String contractFileName) {
        setContractFileName(contractFileName);
        return this;
    }

    // -- [contractContentType] ------------------------

    @Size(max = 100)
    @Column(name = "CONTRACT_CONTENT_TYPE", length = 100)
    public String getContractContentType() {
        return contractContentType;
    }

    public void setContractContentType(String contractContentType) {
        this.contractContentType = contractContentType;
    }

    public Customer contractContentType(String contractContentType) {
        setContractContentType(contractContentType);
        return this;
    }

    // -- [contractSize] ------------------------

    @Digits(integer = 10, fraction = 0)
    @Column(name = "CONTRACT_SIZE", precision = 10)
    public Integer getContractSize() {
        return contractSize;
    }

    public void setContractSize(Integer contractSize) {
        this.contractSize = contractSize;
    }

    public Customer contractSize(Integer contractSize) {
        setContractSize(contractSize);
        return this;
    }

    // -- [version] ------------------------

    @Column(name = "VERSION", precision = 10)
    @Version
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Customer version(Integer version) {
        setVersion(version);
        return this;
    }

    // -----------------------------------------------------------------
    // Many to One support
    // -----------------------------------------------------------------

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: Customer.address ==> Address.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @JoinColumn(name = "ADDRESS_ID")
    @ManyToOne(cascade = { PERSIST, MERGE }, fetch = LAZY)
    public Address getAddress() {
        return address;
    }

    /**
     * Set the {@link #address} without adding this Customer instance on the passed {@link #address}
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    public Customer address(Address address) {
        setAddress(address);
        return this;
    }

    // -----------------------------------------------------------------
    // One to Many support
    // -----------------------------------------------------------------

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // one to many: customer ==> accounts
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @OneToMany(mappedBy = "customer", orphanRemoval = true, cascade = ALL)
    public List<Account> getAccounts() {
        return accounts;
    }

    /**
     * Set the {@link Account} list.
     * It is recommended to use the helper method {@link #addAccount(Account)} / {@link #removeAccount(Account)}
     * if you want to preserve referential integrity at the object level.
     *
     * @param accounts the list to set
     */
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    /**
     * Helper method to add the passed {@link Account} to the {@link #accounts} list
     * and set this customer on the passed account to preserve referential
     * integrity at the object level.
     *
     * @param account the to add
     * @return true if the account could be added to the accounts list, false otherwise
     */
    public boolean addAccount(Account account) {
        if (getAccounts().add(account)) {
            account.setCustomer(this);
            return true;
        }
        return false;
    }

    /**
     * Helper method to remove the passed {@link Account} from the {@link #accounts} list and unset
     * this customer from the passed account to preserve referential integrity at the object level.
     *
     * @param account the instance to remove
     * @return true if the account could be removed from the accounts list, false otherwise
     */
    public boolean removeAccount(Account account) {
        if (getAccounts().remove(account)) {
            account.setCustomer(null);
            return true;
        }
        return false;
    }

    /**
     * Apply the default values.
     */
    public Customer withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Customer && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this Customer instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this) //
                .add("id", getId()) //
                .add("companyName", getCompanyName()) //
                .add("contractBinary", getContractBinary()) //
                .add("contractFileName", getContractFileName()) //
                .add("contractContentType", getContractContentType()) //
                .add("contractSize", getContractSize()) //
                .add("version", getVersion()) //
                .toString();
    }
}