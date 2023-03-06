/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.credit.service;

import com.haulmont.thesis.core.entity.Bank;

import java.math.BigDecimal;
import java.util.UUID;

public interface BankService {
    String NAME = "credit_BankService";

    BigDecimal getSum(Bank bank);

    BigDecimal getSum(UUID uuid);
}