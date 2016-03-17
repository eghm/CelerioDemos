/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/domain/ExcelExporter.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package com.jaxio.jsf2_spring_conversation_empty.web.domain;

import javax.inject.Inject;
import javax.inject.Named;

import com.jaxio.jsf2_spring_conversation_empty.domain.Absentlog;
import com.jaxio.jsf2_spring_conversation_empty.web.domain.support.GenericExcelExporter;
import com.jaxio.jsf2_spring_conversation_empty.web.faces.ConversationContextScoped;

/**
 * Exports to excel document {@link Absentlog} search criteria and result. 
 */
@Named
@ConversationContextScoped
public class AbsentlogExcelExporter extends GenericExcelExporter<Absentlog> {
    @Inject
    protected AbsentlogSearchForm sf;

    public AbsentlogExcelExporter() {
        super("absentlog_logdate", "absentlog_logversionid", "absentlog_lognotes");
    }

    @Override
    protected void fillResultItem(int row, Absentlog item) {
        int col = 0;
        setDateTime(row, col++, item.getLogdate());
        setValue(row, col++, item.getLogversionid());
        setValue(row, col++, item.getLognotes());
    }

    @Override
    public void fillSearchCriteria(int row) {
        useCriteriaSheet();

        setSelectedEntities(row++, 0, "absentlog_employee", sf.getEmployeeSelector().getSelected());
        setSelectedEntities(row++, 0, "absentlog_abs", sf.getAbsSelector().getSelected());
        setRangeDateTime(row++, 0, "absentlog_logdate", sf.getLogdateRange());
        setRangeNumber(row++, 0, "absentlog_logversionid", sf.getLogversionidRange());
        setSelector(row++, 0, "absentlog_lognotes", sf.getLognotesSelector());
    }
}