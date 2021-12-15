package com.coding.interview.huawei;

import java.util.Scanner;

/**
 * @Author: Bug改了我
 * @CreateTime: 2021/12/15 10:37 上午
 * @Description:
 */
public class CodeEditor {

    private static final String CLI_INSERT = "INSERT";
    private static final String CLI_FORWARD = "FORWARD";
    private static final String CLI_BACKWARD = "BACKWARD";
    private static final String CLI_SEARCH_FORWARD = "SEARCH FORWARD";
    private static final String CLI_SEARCH_BACKWARD = "SEARCH BACKWARD";
    private static final String CLI_REPLACE = "REPLACE";
    private static final String CLI_DELETE = "DELETE";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = 0;
        int commandLen = 0;
        String srcText = "";
        String commands = "";
        int commandEnd = 0;
        while (scanner.hasNext()) {
            String next = scanner.next();
            if (lines == 0) {
                commandLen = Integer.parseInt(next);
            }
            if (lines == 1) {
                srcText = next;
            }
            if (lines > 1) {
                commands = next + ",";
                commandLen++;
            }
            lines++;
            if (commandEnd == commandLen) {
                break;
            }
        }
        String[] clis = commands.substring(0, commands.lastIndexOf(",")).split(",");
        editCode(srcText, clis, 0);
        System.out.println(srcText);

    }

    public static String editCode(String srcTxt, String[] commands, int currIndex) {
        for (String command : commands) {
            if (command.contains(CLI_FORWARD)) {
                int forward = getNum(command);
                currIndex = forward(srcTxt, currIndex, forward);
            }
            if (command.contains(CLI_BACKWARD)) {
                int backward = getNum(command);
                currIndex = backward(srcTxt, currIndex, backward);
            }
            if (command.contains(CLI_INSERT)) {
                srcTxt = insert(srcTxt, validAndGetArgs(command), currIndex);
            }
            if (command.contains(CLI_DELETE)) {
                srcTxt = delete(srcTxt, currIndex, getNum(command));
            }
            if (command.contains(CLI_REPLACE)) {
                srcTxt = replace(srcTxt, currIndex, validAndGetArgs(command));
            }
            if (command.contains(CLI_SEARCH_FORWARD)) {
                currIndex = searchForward(srcTxt, validAndGetArgs(command), currIndex);
            }
            if (command.contains(CLI_SEARCH_BACKWARD)) {
                currIndex = searchBackward(srcTxt, validAndGetArgs(command), currIndex);
            }
        }
        return srcTxt;
    }

    public static String insert(String src, String ins, int currIndex) {
        int length = src.length();
        if (currIndex < length) {
            String head = src.substring(0, currIndex);
            String tail = src.substring(currIndex + 1, length);
            src = head + ins + tail;
            currIndex = head.length() + ins.length();
        } else {
            src = src + ins;
            currIndex = src.length();
        }
        return src;
    }

    public static int forward(String src, int curIndex, int moveLen) {
        int length = src.length();
        if (moveLen > length || curIndex >= length - 1) {
            return 0;
        }
        curIndex = curIndex + moveLen;
        if (curIndex > length) {
            curIndex = length;
        }
        return curIndex;
    }

    public static int backward(String src, int curIndex, int moveLen) {
        if (curIndex == 0) {
            return curIndex;
        }
        curIndex = curIndex - moveLen;
        if (curIndex <= 0) {
            return 0;
        }
        return curIndex;
    }

    public static String replace(String src, int currIndex, String des) {
        src = delete(src, currIndex, des.length());
        return insert(src, des, currIndex);
    }

    public static String delete(String src, int currIndex, int num) {
        int length = src.length();
        if (currIndex >= length) {
            return src;
        }
        String head = src.substring(0, currIndex);
        String tail = src.substring(currIndex + num);
        src = head + tail;
        return src;
    }

    public static int searchForward(String src, String target, int currIndex) {
        String substring = src.substring(currIndex);
        int move = 0;
        if (substring.contains(target)) {
            move = substring.indexOf(target);
        }
        currIndex = currIndex + move + 1;
        return currIndex;
    }

    public static int searchBackward(String src, String target, int currIndex) {
        String substring = src.substring(0, currIndex);
        int move = 0;
        if (substring.contains(target)) {
            move = substring.indexOf(target);
        }
        currIndex = currIndex - move - 1;
        return currIndex;
    }


    /**
     * 验证带参数命令是否缺失参数
     *
     * @param command
     * @return
     */
    public static String validAndGetArgs(String command) {
        String[] s = command.split(" ");
        if (s.length == 0) {
            return "";
        }
        return s[1];
    }

    public static int getNum(String command) {
        String s = validAndGetArgs(command);
        if ("".equals(s)) {
            return 0;
        }
        return Integer.parseInt(s);
    }
}
