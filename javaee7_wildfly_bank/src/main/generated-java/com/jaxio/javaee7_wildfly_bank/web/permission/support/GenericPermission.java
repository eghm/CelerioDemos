/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-javaee7-frontend:src/main/java/permission/support/GenericPermission.p.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/javaee-lab
 */
package com.jaxio.javaee7_wildfly_bank.web.permission.support;

import java.io.Serializable;

import com.jaxio.jpa.querybyexample.Identifiable;

public abstract class GenericPermission<E extends Identifiable<? extends Serializable>> {
    private Class<E> clazz;

    public void init(Class<E> clazz) {
        this.clazz = clazz;
    }

    public Class<E> getTarget() {
        return clazz;
    }

    public boolean canCreate() {
        return true;
    }

    public boolean canView() {
        return true;
    }

    public boolean canView(E e) {
        return e == null ? false : canView();
    }

    public boolean canEdit() {
        return true;
    }

    public boolean canEdit(E e) {
        return e == null ? false : canEdit();
    }

    public boolean canDelete() {
        return true;
    }

    public boolean canDelete(E e) {
        return canDelete();
    }

    public boolean canSearch() {
        return canView();
    }

    public boolean canSearch(E e) {
        return canSearch();
    }

    public boolean canSelect() {
        return canSearch();
    }

    public boolean canSelect(E e) {
        return canSelect();
    }

    public boolean canUse() {
        return canView() || canSelect() || canDelete() || canEdit();
    }

    public boolean canUse(E e) {
        return canView(e) || canSelect(e) || canDelete(e) || canEdit(e);
    }
}
