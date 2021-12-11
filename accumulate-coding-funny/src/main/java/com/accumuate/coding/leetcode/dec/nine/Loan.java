package com.accumuate.coding.leetcode.dec.nine;

import io.swagger.models.auth.In;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: cyhua
 * @createTime: 2021/12/9
 * @description:
 */
public class Loan {

    private String id;

    private Integer ovdDays;

    private BigDecimal rate;

    private Date startDate;

    private BigDecimal amount;

    public Loan() {
    }

    public Loan(String id, Integer ovdDays, BigDecimal rate, Date startDate, BigDecimal amount) {
        this.id = id;
        this.ovdDays = ovdDays;
        this.rate = rate;
        this.startDate = startDate;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getOvdDays() {
        return ovdDays;
    }

    public void setOvdDays(Integer ovdDays) {
        this.ovdDays = ovdDays;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
