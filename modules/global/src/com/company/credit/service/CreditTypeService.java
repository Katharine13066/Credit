/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.credit.service;

import com.company.credit.entity.CreditType;

public interface CreditTypeService {
    String NAME = "credit_CreditTypeService";

    public void updateCreditAmount(CreditType creditType);
}