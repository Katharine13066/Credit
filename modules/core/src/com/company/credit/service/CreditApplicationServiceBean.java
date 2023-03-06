/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.credit.service;

import com.company.credit.entity.CreditApplication;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.thesis.core.entity.Individual;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(CreditApplicationService.NAME)
public class CreditApplicationServiceBean implements CreditApplicationService {

    @Inject
    private Persistence persistence;

    @Override
    public long getCount(CreditApplication creditApplication) {
        Long count;
        try(Transaction transaction = persistence.createTransaction()){
            EntityManager entityManager = persistence.getEntityManager();
            Query query = entityManager.createQuery(
                    "select count(ca) from credit$CreditApplication ca join credit$Credit c on ca.credit.id = c.id where c.bank.id = :bankId and ca.individual.id = :contractorId"
            );
            query.setParameter("contractorId", creditApplication.getIndividual().getId());
            query.setParameter("bankId", creditApplication.getCredit().getBank().getId());

            count = (Long) query.getFirstResult();
            transaction.commit();
        }
        return count != null ? count : 0;
    }

    @Override
    public long getCreditApplicationCount(Individual individual) {
        Long count;
        try (Transaction transaction = persistence.createTransaction()) {
            EntityManager entityManager = persistence.getEntityManager();
            Query query = entityManager.createQuery(
                    "select count(ca) from credit$CreditApplication ca where ca.individual.id = :individualId"
            );
            query.setParameter("individualId", individual.getId());
            count = (Long) query.getFirstResult();
            transaction.commit();
        }
        return count != null ? count : 0;
    }
}