/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.credit.service;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.thesis.core.entity.Bank;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.UUID;

@Service(BankService.NAME)
public class BankServiceBean implements BankService {

    @Inject
    private Persistence persistence;

    @Override
    public BigDecimal getSum(Bank bank) {
        return getSum(bank.getId());
    }

    @Override
    public BigDecimal getSum(UUID uuid) {
        BigDecimal sum;
        try(Transaction transaction = persistence.createTransaction()) {
            EntityManager entityManager = persistence.getEntityManager();
            Query query = entityManager.createQuery(
                    "select sum(c.amount) from credit$Credit c where c.bank.id = :bankId"
            );
            query.setParameter("bankId", uuid);
            sum = (BigDecimal) query.getFirstResult();
            transaction.commit();
        }
        return sum != null ? sum : BigDecimal.ZERO;
    }
}