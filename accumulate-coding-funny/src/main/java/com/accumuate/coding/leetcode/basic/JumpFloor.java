package com.accumuate.coding.leetcode.basic;

/**
 * @Author: Bug改了我
 * @CreateTime: 2021/12/14 7:51 上午
 * @Description: 跳台阶问题
 */
public class JumpFloor {

    public static void main(String[] args) {
        dp(10);
    }

    public static int dp(int n){
        if(n<=1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <= n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

}


