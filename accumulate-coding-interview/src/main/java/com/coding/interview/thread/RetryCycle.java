package com.coding.interview.thread;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/25 2:13 下午
 * @description: 测试retry功能
 * 总结：一般的continue和break只是针对当前循环，利用retry可以控制任意循环的位置
 * continue retry:可以继续执行retry指定的循环体，而不只是当前循环体
 * break retry:可以跳出retry指定的循环体，而不止是当前循环体
 */
public class RetryCycle {

    public static void main(String[] args) {
        justContinue();
        retryContinue();
        justBreak();
        retryBreak();
    }

    public static void justContinue() {
        System.out.println("---------justContinue begin---------");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println("justContinue:i=" + i + "    j=" + j);
                if (j == 3) {
                    continue;
                }
            }
        }
        System.out.println("---------justContinue end---------");
    }

    public static void retryContinue() {
        System.out.println("---------retryContinue begin---------");
        retry:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println("retryContinue:i=" + i + "    j=" + j);
                if (j == 3) {
                    //继续执行retry开始的循环
                    continue retry;
                }
            }
        }
        System.out.println("---------retryContinue end---------");
    }

    public static void justBreak() {
        System.out.println("---------justBreak begin---------");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println("justBreak:i=" + i + "    j=" + j);
                if (j == 3) {
                    //跳出内层循环，继续执行外层循环，等价于break
                    break;
                }
            }
        }

        System.out.println("---------justBreak end---------");
    }

    public static void retryBreak() {
        System.out.println("---------retryBreak begin---------");
        retry:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println("justBreak:i=" + i + "    j=" + j);
                if (j == 3) {
                    //直接跳出循环开始的位置
                    break retry;
                }
            }
        }
        System.out.println("---------retryBreak  end---------");
    }
}
