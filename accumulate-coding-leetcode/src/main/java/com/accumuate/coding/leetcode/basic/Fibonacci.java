package com.accumuate.coding.leetcode.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: cyhua
 * @createTime: 2021/4/25
 * @description: 斐波那契数列
 */
public class Fibonacci {

    private static AtomicInteger forceTotalCount = new AtomicInteger(0);
    private static AtomicInteger mementoTotalCount = new AtomicInteger(0);

    public static void main(String[] args) {
        int n = 40;
        int fib = new Fibonacci().fib(100);
        System.out.println(fib);
       /* System.out.println("开始使用暴力法.......");
        long forceStart = System.currentTimeMillis();
        int forceResult = forceCalculate(n);
        long forceEnd = System.currentTimeMillis();
        System.out.println("使用暴力法计算f(" + n + ")的计算结果为:" + forceResult);
        System.out.println("使用暴力法总共计算了:" + forceTotalCount.intValue() + "次:+使用了" + (forceEnd - forceStart) + "毫秒");
        System.out.println("开始使用备忘录模式.......");
        long mementoStart = System.currentTimeMillis();
        int mementoResult = mementoCalculate(n);
        long mementoEnd = System.currentTimeMillis();
        System.out.println("使用备忘录法计算f(" + n + ")的计算结果为:" + mementoResult);
        System.out.println("使用备忘录法总共计算了:" + mementoTotalCount.intValue() + "次:+使用了" + (mementoEnd - mementoStart) + "毫秒");毫秒*/
    }

    /**
     * 暴力求解法
     *
     * @param n
     * @return
     */
    public static int forceCalculate(int n) {
//        System.out.println("暴力法计算:f(" + n + ")");
        forceTotalCount.incrementAndGet();
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return forceCalculate(n - 1) + forceCalculate(n - 2);
    }


    public static int mementoCalculate(int n) {
//        System.out.println("备忘录法计算:f(" + n + ")");
        if (n == 0) {
            return 0;
        }
        HashMap<Integer, Integer> memento = new HashMap<>();
        memento.put(n, 0);
        return fromMemento(memento, n);
    }

    public static int fromMemento(HashMap<Integer, Integer> memento, int n) {
        mementoTotalCount.incrementAndGet();
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memento.get(n) != null && memento.get(n) != 0) {
            return memento.get(n);
        }
        Integer mementoN = fromMemento(memento, n - 1) + fromMemento(memento, n - 2);
        return mementoN;
    }

    Map<String,Integer> exist = new HashMap<String,Integer>();
    public int fib(int n) {
        String key = String.valueOf(n);
        if(n==0){
            return 0;
        };
        if(n==1 || n==2) return 1;
        if(exist.get(key)!=null){
            return exist.get(key);
        }
        int sum = (fib(n-1)+fib(n-2))%1000000007;
        exist.put(key,sum);
        return sum;
    }

}
