/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-javaee7-frontend:src/main/java/domain/LazyDataModel.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/javaee-lab
 */
package com.jaxio.javaee7_wildfly_bank.web.domain;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;

import com.jaxio.javaee7_wildfly_bank.domain.Address;
import com.jaxio.javaee7_wildfly_bank.repository.AddressRepository;
import com.jaxio.javaee7_wildfly_bank.web.domain.support.GenericLazyDataModel;

/**
 * Provide PrimeFaces {@link LazyDataModel} for {@link Address}
 */
@ViewScoped
@Named
public class AddressLazyDataModel extends GenericLazyDataModel<Address, Integer, AddressSearchForm> {
    private static final long serialVersionUID = 1L;

    public AddressLazyDataModel() {
        // mandatory no-args constructor to make this bean proxyable
    }

    @Inject
    public AddressLazyDataModel(AddressRepository addressRepository, AddressController addressController, AddressSearchForm addressSearchForm,
            AddressExcelExporter addressExcelExporter) {
        super(addressRepository, addressController, addressSearchForm, addressExcelExporter);
    }
}