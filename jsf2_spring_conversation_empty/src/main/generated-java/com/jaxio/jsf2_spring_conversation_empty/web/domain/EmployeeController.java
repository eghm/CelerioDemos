/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/domain/Controller.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package com.jaxio.jsf2_spring_conversation_empty.web.domain;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.jaxio.jsf2_spring_conversation_empty.domain.Employee;
import com.jaxio.jsf2_spring_conversation_empty.printer.EmployeePrinter;
import com.jaxio.jsf2_spring_conversation_empty.repository.EmployeeRepository;
import com.jaxio.jsf2_spring_conversation_empty.web.domain.support.GenericController;
import com.jaxio.jsf2_spring_conversation_empty.web.permission.EmployeePermission;

/**
 * Stateless controller for {@link Employee} conversation start.
 */
@Named
@Singleton
public class EmployeeController extends GenericController<Employee, Integer> {
    public static final String EMPLOYEE_EDIT_URI = "/domain/employeeEdit.faces";
    public static final String EMPLOYEE_SELECT_URI = "/domain/employeeSelect.faces";

    @Inject
    public EmployeeController(EmployeeRepository employeeRepository, EmployeePermission employeePermission, EmployeePrinter employeePrinter) {
        super(employeeRepository, employeePermission, employeePrinter, EMPLOYEE_SELECT_URI, EMPLOYEE_EDIT_URI);
    }
}