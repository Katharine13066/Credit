/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.credit.web.ui.credittype;

import com.company.credit.entity.CreditType;
import com.company.credit.service.CreditTypeService;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.screen.Subscribe;

import javax.inject.Inject;
import java.util.Map;

public class CreditTypeBrowse extends AbstractLookup {

    public static final String DONE = "Пересчет кредита выполнен успешно";

    @Inject
    private Table<CreditType> creditTypesTable;

    @Inject
    private Notifications notifications;

    @Inject
    private CreditTypeService creditTypeService;

    @Override
    public void init(Map<String, Object> params) {
    }

    @Subscribe("updateBtn")
    public void onUpdateBtnClick(Button.ClickEvent event) {
        creditTypeService.updateCreditAmount(
                creditTypesTable.getSingleSelected()
        );
        notifications
                .create(Notifications.NotificationType.HUMANIZED)
                .withCaption(DONE)
                .show();
    }
}