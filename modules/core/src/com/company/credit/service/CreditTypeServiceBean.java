/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.credit.service;

import com.company.credit.entity.Credit;
import com.company.credit.entity.CreditType;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service(CreditTypeService.NAME)
public class CreditTypeServiceBean implements CreditTypeService {

    @Inject
    private Persistence persistence;

    @Override
    public void updateCreditAmount(CreditType creditType) {
        try(Transaction transaction = persistence.createTransaction()){
            EntityManager entityManager = persistence.getEntityManager();
            Query query = entityManager.createQuery(
                    "update credit$Credit c set c.amount = c.amount * ?1 where c.creditType.id = ?2");
            query.setParameter(1, creditType.getNumber());
            query.setParameter(2, creditType.getId());
            query.executeUpdate();
            transaction.commit();
        }
    }


}