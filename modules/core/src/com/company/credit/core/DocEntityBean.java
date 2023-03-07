/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.credit.core;

import com.haulmont.thesis.core.entity.Doc;
import com.haulmont.thesis.core.listener.DocEntityListener;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component(DocEntityBean.NAME)
public class DocEntityBean extends DocEntityListener {
    public static final String NAME = "credit_DocEntityBean";

    @Override
    protected String createDescription(Doc entity) {
        StringBuilder description = new StringBuilder();
        description.append(getDocKindName(entity));

        String number = getDescriptionNumber(entity);
        if (StringUtils.isNotBlank(number)) {
            description.append("!!! ");
            description.append(messages.getMessage(getClass(), "Doc.numberPrefix")).append(" ");
            description.append(StringUtils.trimToEmpty(number));
        }

        Date date = entity.getDate();
        if (entity.getRegistered() && entity.getRegDate() != null) {
            date = entity.getRegDate();
        }
        if (date != null) {
            description.append(" ").append(messages.getMessage(getClass(), "Doc.datePrefix"))
                    .append(" ").append(String.format("%1$td.%1$tm.%1$tY", date));
        }

        return description.toString();
    }
}