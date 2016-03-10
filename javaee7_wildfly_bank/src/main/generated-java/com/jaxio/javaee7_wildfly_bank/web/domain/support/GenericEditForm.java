/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-javaee7-frontend:src/main/java/domain/support/GenericEditForm.p.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/javaee-lab
 */
package com.jaxio.javaee7_wildfly_bank.web.domain.support;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.apache.commons.lang.WordUtils;
import org.omnifaces.util.Faces;

import com.jaxio.javaee7_wildfly_bank.printer.support.TypeAwarePrinter;
import com.jaxio.javaee7_wildfly_bank.repository.support.RepositoryLocator;
import com.jaxio.javaee7_wildfly_bank.util.ResourcesUtil;
import com.jaxio.javaee7_wildfly_bank.web.util.MessageUtil;
import com.jaxio.javaee7_wildfly_bank.web.util.TabBean;
import com.jaxio.jpa.querybyexample.EntityGraphLoader;
import com.jaxio.jpa.querybyexample.GenericRepository;
import com.jaxio.jpa.querybyexample.Identifiable;
import com.jaxio.jpa.querybyexample.JpaUniqueUtil;

/**
 * Base Edit Form for JPA entities.
 */
public abstract class GenericEditForm<E extends Identifiable<PK>, PK extends Serializable> extends CommonAction<E> {
    private static final long serialVersionUID = 1L;
    private E entity;
    private boolean persistent;

    @Inject
    protected transient JpaUniqueUtil jpaUniqueUtil;
    @Inject
    protected transient MessageUtil messageUtil;
    @Inject
    protected transient TypeAwarePrinter printer;
    @Inject
    protected transient ResourcesUtil resourcesUtil;
    @Inject
    protected transient RepositoryLocator repositoryLocator;

    protected transient GenericRepository<E, PK> repository;
    protected transient EntityGraphLoader<E, PK> entityGraphLoader;

    public GenericEditForm() {
        // mandatory no-args constructor to make this bean proxyable
    }

    public GenericEditForm(GenericRepository<E, PK> repository) {
        this.repository = repository;
    }

    public GenericEditForm(GenericRepository<E, PK> repository, EntityGraphLoader<E, PK> entityGraphLoader) {
        this.repository = repository;
        this.entityGraphLoader = entityGraphLoader;
    }

    protected EntityGraphLoader<E, PK> getEntityGraphLoader() {
        return entityGraphLoader;
    }

    @PostConstruct
    public void init() {
        PK id = null;
        String idParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

        if (idParam != null) {
            id = repository.convertToPrimaryKey(idParam);
        }

        if (id == null) {
            // no need to merge anything since it is a brand new entity, not yet persisted.
            entity = repository.getNew();
            initNewEntity(entity);
        } else if (entityGraphLoader != null) {
            entity = entityGraphLoader.getById(id);
            persistent = entity != null;
        } else {
            entity = repository.getById(id);
            persistent = entity != null;
        }

        onInit();
    }

    /**
     * When init was called, was the entity persistent?
     */
    public boolean isPersistent() {
        return persistent;
    }

    /**
     * Override this method to pre-filled the passed new entity, for example to set the owner side in case the passed entity
     * destiny is to be part of an one-to-many association.
     */
    protected void initNewEntity(E entity) {
    }

    /**
     * Override this method to complete the current entity initialization.
     */
    protected void onInit() {
    }

    /**
     * Return the entity that this edit form backs.
     */
    public E getEntity() {
        return entity;
    }

    /**
     * Return the TabBean used by this form or <code>null</code> if this form
     * does not use any tab.
     */
    public TabBean getTabBean() {
        return null; // leave it null by default as the view checks for null.
    }

    // ------------------------------------
    // Actions
    // ------------------------------------

    /**
     * Close the current edit page, without saving anything.
     */
    public String forceClose() {
        return quit();
    }

    /**
     * deleteAndClose action is used form modal dialogs in the main edit page. 
     */
    public String deleteAndClose() {
        repository.delete(getEntity());
        messageUtil.infoEntity("status_deleted_ok", getEntity());
        return quit();
    }

    /**
     * Save action. Used from main edit page. Expected to be an ajax request.
     */
    public String saveAndClose() {
        if (!validate(entity)) {
            return null;
        }

        // Note: merge work also on new entity (actually it works better with many to many association)
        entity = repository.merge(entity);
        messageUtil.infoEntity("status_saved_ok", entity);
        return quit();
    }

    /**
     * Save action. Used from main edit page. Expected to be an ajax request.
     */
    public void save() {
        if (!validate(entity)) {
            return;
        }

        // Note: merge work also on new entity (actually it works better with many to many association)
        entity = repository.merge(entity);
        onInit(); // init data models...
        messageUtil.infoEntity("status_saved_ok", entity);
        if (!isPersistent()) {
            // force redirect in order to have the id in the URL
            Faces.navigate(FacesContext.getCurrentInstance().getViewRoot().getViewId() + "?faces-redirect=true&id=" + entity.getId().toString());
        }
    }

    public boolean validate(E entity) {
        List<String> errors = jpaUniqueUtil.validateUniques(entity);
        for (String error : errors) {
            messageUtil.error(error);
        }
        return errors.isEmpty();
    }

    protected void checkPermission(boolean check) {
        if (!check) {
            throw new IllegalStateException();
        }
    }

    protected String getLabelName() {
        return WordUtils.uncapitalize(repository.getType().getSimpleName());
    }

    public String getEditKey() {
        return getLabelName() + "_edit";
    }

    public String getViewKey() {
        return getLabelName() + "_view";
    }

    public String getCreateKey() {
        return getLabelName() + "_create";
    }

    public String getTitle() {
        String key = isPersistent() ? getEditKey() : getCreateKey();
        return resourcesUtil.getProperty(key, printer.print(entity));
    }
}