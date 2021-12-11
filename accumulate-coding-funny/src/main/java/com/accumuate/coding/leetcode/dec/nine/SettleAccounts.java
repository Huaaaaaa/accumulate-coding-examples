package com.accumuate.coding.leetcode.dec.nine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author: cyhua
 * @createTime: 2021/12/9
 * @description:
 */
public class SettleAccounts {

    public static void main(String[] args) {
        List<Loan> loans = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Loan loan = new Loan();
            loan.setId("id" + i);
            loan.setAmount(new BigDecimal(i));
            loan.setOvdDays(i);
            loan.setRate(new BigDecimal(1));
            loan.setStartDate(new Date());
            loans.add(loan);
        }

        reduce(loans);

    }

    public static void reduce(List<Loan> loans) {
        Comparator<Loan> byOvdDays = Comparator.comparing(Loan::getOvdDays).reversed();
        Comparator<Loan> byRate = Comparator.comparing(Loan::getRate).reversed();
        Comparator<Loan> byDate = Comparator.comparing(Loan::getStartDate);
        Comparator<Loan> byId = Comparator.comparing(Loan::getId);
        loans.sort(byOvdDays.thenComparing(byRate).thenComparing(byDate).thenComparing(byId));
    }

}
