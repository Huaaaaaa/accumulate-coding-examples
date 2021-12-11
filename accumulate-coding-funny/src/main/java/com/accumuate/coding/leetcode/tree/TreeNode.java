package com.accumuate.coding.leetcode.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: Huaaaaaa
 * @createTime: 2021/4/18
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode implements Serializable {

    /**
     * 根节点的值
     */
    private int data;

    /**
     * 左子树
     */
    private TreeNode leftChild;

    /**
     * 右子树
     */
    private TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }


}
