/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.credit.web.ui.individual;

import com.company.credit.service.CreditApplicationService;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.thesis.core.entity.Individual;
import com.haulmont.thesis.web.ui.individual.IndividualBrowseFrame;

import javax.inject.Inject;
import java.util.Map;

public class ExtIndividualBrowseFrame extends IndividualBrowseFrame {

    @Inject
    private CreditApplicationService creditRequestService;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        individualsTable.addGeneratedColumn("Количество кредитов", new Table.ColumnGenerator() {
            @Override
            public Component generateCell(Entity entity) {
                return new Table.PlainTextCell(String.valueOf(creditRequestService.getCreditApplicationCount((Individual) entity)));
            }
        });
    }
}