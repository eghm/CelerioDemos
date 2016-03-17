/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-backend-jpa:src/main/java/domain/Entity.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-backend-jpa
 */
package com.jaxio.jsf2_spring_conversation_empty.domain;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.jaxio.jpa.querybyexample.Identifiable;

@Entity
@Table(name = "absentlog")
public class Absentlog implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(Absentlog.class);

    // Raw attributes
    private Integer id;
    private Date logdate;
    private Integer logversionid;
    private String lognotes;

    // Many to one
    private Employee employee;
    private Absent abs;

    // -- [id] ------------------------

    @Override
    @Column(name = "empid", precision = 10)
    @Id
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Absentlog id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    @XmlTransient
    public boolean isIdSet() {
        return id != null;
    }

    // -- [logdate] ------------------------

    @NotNull
    @Column(name = "logdate", nullable = false, length = 19)
    @Temporal(TIMESTAMP)
    public Date getLogdate() {
        return logdate;
    }

    public void setLogdate(Date logdate) {
        this.logdate = logdate;
    }

    public Absentlog logdate(Date logdate) {
        setLogdate(logdate);
        return this;
    }

    // -- [logversionid] ------------------------

    @Digits(integer = 10, fraction = 0)
    @NotNull
    @Column(name = "logversionid", nullable = false, precision = 10)
    public Integer getLogversionid() {
        return logversionid;
    }

    public void setLogversionid(Integer logversionid) {
        this.logversionid = logversionid;
    }

    public Absentlog logversionid(Integer logversionid) {
        setLogversionid(logversionid);
        return this;
    }

    // -- [lognotes] ------------------------

    @Size(max = 2147483647)
    @Column(name = "lognotes", length = 2147483647)
    public String getLognotes() {
        return lognotes;
    }

    public void setLognotes(String lognotes) {
        this.lognotes = lognotes;
    }

    public Absentlog lognotes(String lognotes) {
        setLognotes(lognotes);
        return this;
    }

    // -----------------------------------------------------------------
    // Many to One support
    // -----------------------------------------------------------------

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: Absentlog.employee ==> Employee.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @JoinColumn(name = "empid", nullable = false)
    @ManyToOne(cascade = { PERSIST, MERGE }, fetch = LAZY)
    @MapsId
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Set the {@link #employee} without adding this Absentlog instance on the passed {@link #employee}
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Absentlog employee(Employee employee) {
        setEmployee(employee);
        return this;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: Absentlog.abs ==> Absent.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @NotNull
    @JoinColumn(name = "absid", nullable = false)
    @ManyToOne(cascade = { PERSIST, MERGE }, fetch = LAZY)
    public Absent getAbs() {
        return abs;
    }

    /**
     * Set the {@link #abs} without adding this Absentlog instance on the passed {@link #abs}
     */
    public void setAbs(Absent abs) {
        this.abs = abs;
    }

    public Absentlog abs(Absent abs) {
        setAbs(abs);
        return this;
    }

    /**
     * Apply the default values.
     */
    public Absentlog withDefaults() {
        setLogversionid(1);
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Absentlog && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this Absentlog instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("logdate", getLogdate()) //
                .add("logversionid", getLogversionid()) //
                .add("lognotes", getLognotes()) //
                .toString();
    }
}