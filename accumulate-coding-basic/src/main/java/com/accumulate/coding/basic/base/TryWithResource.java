package com.accumulate.coding.basic.base;

/**
 * @author: Huaaaaaa
 * @createTime: 2021/11/15
 * @description:
 */
public class TryWithResource {

    public static void main(String[] args) {
        TryWithResource tryWithResource = new TryWithResource();
        int res1 = tryWithResource.catchReturnFinallyUpdate(10);
        System.out.println("catchReturnFinallyUpdate=" + res1);
        int res2 = tryWithResource.catchReturnFinallyReturn(10);
        System.out.println("catchReturnFinallyReturn=" + res2);
        int res3 = tryWithResource.finallyUpdate(10);
        System.out.println("finallyUpdate=" + res3);
    }

    public int catchReturnFinallyUpdate(int number) {
        int res;
        try {
            res = number / 0;
        } catch (Exception e) {
            res = 10;
            return res;
        } finally {
            res = 20;
        }
        return res;
    }

    public int catchReturnFinallyReturn(int number) {
        int res;
        try {
            res = number / 0;
        } catch (Exception e) {
            res = 10;
            return res;
        } finally {
            res = 20;
            return res;
        }
    }

    public int finallyUpdate(int number) {
        int res;
        try {
            res = number / 0;
        } catch (Exception e) {
            res = 10;
        } finally {
            res = 20;
        }
        return res;
    }

}
