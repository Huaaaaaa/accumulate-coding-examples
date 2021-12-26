package com.accumuate.coding.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/25 4:55 下午
 * @description:
 */
public class GetWordFromDic {

    public static void main(String[] args) {
        ArrayList<String> dic = new ArrayList<>();
        dic.add("leet");
        dic.add("code");
        boolean isFound = wordBreak("leetcodeleet", dic);
        System.out.println(isFound);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int size = wordDict.size();
        for (int i = 0; i < size; i++) {
            String dic = wordDict.get(i);
            while (s.contains(wordDict.get(i))) {
                int originIndex = s.indexOf(dic);
                if (originIndex == 0) {
                    s = s.substring(dic.length());
                } else {
                    s = s.substring(0, originIndex) + s.substring(originIndex + dic.length());
                }

            }
        }

        if ("".equals(s)) {
            return true;
        }
        return false;
    }
    public boolean wordBreakDp(String s, List<String> wordDict) {
        int size = wordDict.size();
        boolean[] value = new boolean[size+1];
        value[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for(int j=0;j<i;j++){
                if(wordDict.contains(s.substring(j,i)) && value[j]){
                    value[i] =true;
                }
            }
        }
        return value[size];
    }


}
