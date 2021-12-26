package com.accumuate.coding.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/26 5:40 上午
 * @description: leetcode 1609. 奇偶树
 */
public class EvenOddTree {

    /**
     * 总结：广度优先算法，使用队列处理同一层中的数据
     *
     * @param root
     * @return
     */
    public boolean isEvenOddTree(TreeNode root) {
        //将同一层的节点存入队列
        Deque<TreeNode> nodeDeque = new ArrayDeque<>();
        nodeDeque.offer(root);
        int level = 0;
        //判断队列是否为空：处理同一层的节点
        while (!nodeDeque.isEmpty()) {
            int size = nodeDeque.size();
            //偶层单调递增，奇层单调递减
            int prevValue = level % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                //出队
                TreeNode node = nodeDeque.poll();
                int val = node.val;
                //如果偶数层的值为偶数，则不满足条件，直接返回
                if (level % 2 == val % 2) {
                    return false;
                }
                //如果偶数层的值比最小值小，说明不是单调递增；如果奇数层的值比最大值大，说明不是单调递减
                if ((level % 2 == 0 && val <= prevValue) || (level % 2 == 1 && val >= prevValue)) {
                    return false;
                }
                //否则将当前值赋值给前一个值
                prevValue = val;
                if (null != node.left) {
                    nodeDeque.offer(node.left);
                }

                if (null != node.right) {
                    nodeDeque.offer(node.right);
                }
            }
            //层级增长要放在循环外面，在同一层所有节点都遍历完成后执行
            level++;
        }
        return true;
    }

    public boolean checkNode(int level, TreeNode left, TreeNode right) {
        boolean isDesc = true;
        boolean isEvenOdd = true;
        if (left != null && right != null) {
            if (level % 2 == 0) {
                //偶数层严格递减
                isDesc = left.val > right.val;
                //偶层奇值
                isEvenOdd = left.val % 2 != 0 && right.val % 2 != 0;
            } else {
                //奇数层严格递增
                isDesc = left.val < right.val;
                //奇层偶值
                isEvenOdd = left.val % 2 == 0 && right.val % 2 == 0;
            }
        } else if (left != null) {
            if (level % 2 == 0) {
                //偶层奇值
                isEvenOdd = left.val % 2 != 0;
            } else {
                //奇层偶值
                isEvenOdd = left.val % 2 == 0;
            }
        } else if (right != null) {
            if (level % 2 == 0) {
                //偶层奇值
                isEvenOdd = right.val % 2 != 0;
            } else {
                //奇层偶值
                isEvenOdd = right.val % 2 == 0;
            }
        }
        return isDesc & isEvenOdd;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
