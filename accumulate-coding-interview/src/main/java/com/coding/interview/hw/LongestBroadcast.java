package com.coding.interview.hw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Bug改了我
 * @CreateTime: 2021/12/15 12:32 下午
 * @Description: 最长广播响应
 */
public class LongestBroadcast {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] first = s.split(" ");
        int N = Integer.parseInt(first[0]);
        int line = Integer.parseInt(first[1]);
        int flag = 0;
        int firstNode = 0;
        List<HashMap<Integer, Integer>> nodeMap = new ArrayList<>(line);
        while (scanner.hasNext() && flag < line + 1) {
            String next = scanner.nextLine();
            if (flag == line) {
                firstNode = Integer.parseInt(next);
                break;
            }
            String[] nodeData = next.split(" ");
            HashMap<Integer, Integer> node = new HashMap<>();
            node.put(Integer.parseInt(nodeData[0]), Integer.parseInt(nodeData[1]));
            nodeMap.add(node);
            flag++;
        }
        int search = search(firstNode, N, nodeMap);
        System.out.println("最大次数=" + search);


    }

    public static int search(int src, int des, List<HashMap<Integer, Integer>> nodeMap) {
        int sum = 0;
        for (HashMap node : nodeMap) {
            if (node.containsKey(src) || node.containsValue(des)) {
                sum = sum + 1;
            }
        }
        return sum;
    }

}
