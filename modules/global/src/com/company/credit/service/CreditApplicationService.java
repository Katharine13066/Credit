/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.credit.service;

import com.company.credit.entity.CreditApplication;
import com.haulmont.thesis.core.entity.Individual;

public interface CreditApplicationService {
    String NAME = "credit_CreditApplicationService";

    long getCount(CreditApplication creditApplication);

    long getCreditApplicationCount(Individual individual);
}