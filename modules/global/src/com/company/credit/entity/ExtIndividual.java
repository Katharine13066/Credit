/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.credit.entity;

import com.haulmont.cuba.core.entity.annotation.Extends;
import com.haulmont.thesis.core.entity.Individual;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@javax.persistence.DiscriminatorValue("A")
@Table(name = "DF_INDIVIDUAL")
@Entity(name = "credit$ExtIndividual")
@PrimaryKeyJoinColumn(name = "CONTRACTOR_ID", referencedColumnName = "ID")
@Extends(Individual.class)
public class ExtIndividual extends Individual {
    private static final long serialVersionUID = 513384035952655798L;

    @Column(name = "COUNTER")
    protected Long counter;

    public Long getCounter() {
        return counter;
    }

    public void setCounter(Long counter) {
        this.counter = counter;
    }
}