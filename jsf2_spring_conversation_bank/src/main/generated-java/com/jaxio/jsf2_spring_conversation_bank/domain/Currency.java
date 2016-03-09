/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-backend-jpa:src/main/java/domain/Entity.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-backend-jpa
 */
package com.jaxio.jsf2_spring_conversation_bank.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.jaxio.jpa.querybyexample.Identifiable;
import com.jaxio.jsf2_spring_conversation_bank.validation.FixedLength;

@Entity
@Table(name = "CURRENCY")
public class Currency implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(Currency.class);

    // Raw attributes
    private Integer id;
    private String code;
    private String name;
    private Integer decimalCount;
    private Integer version;

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

    public Currency id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    @XmlTransient
    public boolean isIdSet() {
        return id != null;
    }

    // -- [code] ------------------------

    @FixedLength(length = 3, nullable = false)
    @NotEmpty
    @Column(name = "CODE", nullable = false, length = 3)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Currency code(String code) {
        setCode(code);
        return this;
    }

    // -- [name] ------------------------

    @NotEmpty
    @Size(max = 100)
    @Column(name = "NAME", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Currency name(String name) {
        setName(name);
        return this;
    }

    // -- [decimalCount] ------------------------

    @Digits(integer = 10, fraction = 0)
    @Column(name = "DECIMAL_COUNT", precision = 10)
    public Integer getDecimalCount() {
        return decimalCount;
    }

    public void setDecimalCount(Integer decimalCount) {
        this.decimalCount = decimalCount;
    }

    public Currency decimalCount(Integer decimalCount) {
        setDecimalCount(decimalCount);
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

    public Currency version(Integer version) {
        setVersion(version);
        return this;
    }

    /**
     * Apply the default values.
     */
    public Currency withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Currency && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this Currency instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("code", getCode()) //
                .add("name", getName()) //
                .add("decimalCount", getDecimalCount()) //
                .add("version", getVersion()) //
                .toString();
    }
}