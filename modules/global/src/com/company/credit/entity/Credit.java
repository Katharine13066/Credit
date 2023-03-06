/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.credit.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.EnableRestore;
import com.haulmont.cuba.core.entity.annotation.Listeners;
import com.haulmont.cuba.core.entity.annotation.TrackEditScreenHistory;
import com.haulmont.thesis.core.entity.Bank;
import com.haulmont.thesis.core.entity.Contractor;
import com.haulmont.thesis.core.entity.TsCard;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@DiscriminatorValue("2000")
@Table(name = "CREDIT_CREDIT")
@EnableRestore
@TrackEditScreenHistory
@Entity(name = "credit$Credit")
@Listeners("credit_CreditListener")
@PrimaryKeyJoinColumn(name = "CARD_ID", referencedColumnName = "ID")
@NamePattern("%s|description")
public class Credit extends TsCard {
    private static final long serialVersionUID = -3616648860527239459L;

    @Column(name = "NUMBER_", length = 50)
    protected String number;

    @Transient
    @MetaProperty
    protected BigDecimal sum;

    @JoinColumn(name = "SURETY_ID")
    @OneToOne(fetch = FetchType.LAZY)
    protected Contractor surety;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREDIT_TYPE_ID")
    protected CreditType creditType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BANK_ID")
    protected Bank bank;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_")
    protected Date date;

    @Column(name = "AMOUNT")
    protected BigDecimal amount;

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public Contractor getSurety() {
        return surety;
    }

    public void setSurety(Contractor surety) {
        this.surety = surety;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public CreditType getCreditType() {
        return creditType;
    }

    public void setCreditType(CreditType creditType) {
        this.creditType = creditType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}