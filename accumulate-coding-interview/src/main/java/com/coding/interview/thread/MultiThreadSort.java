package com.coding.interview.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/28 10:46 上午
 * @description:
 */
public class MultiThreadSort {


    private ThreadPoolExecutor executor = new ThreadPoolExecutor(0, 3, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(5), new ThreadFactoryBuilder().build());

    private String COMMON_PREFIX = "/tmp/data";
    private String COMMON_SUFFIX = ".txt";
    private String COMMON_SPLIT = "-";

    public String multiThreadSort(int[] data) {
        if (data == null || data.length == 0) {
            return "";
        }

        int size = data.length;
        int length = size / 3;
        int mod = size % 3;
        int begin = 0, end = 0;
        List<ForkSort> tasks = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            end = mod > 0 ? (begin + length + mod) : (begin + length);
            int[] subData = Arrays.copyOfRange(data, begin, end);
            begin = end;
            --mod;
            ForkSort forkSort = new ForkSort(subData, COMMON_PREFIX + COMMON_SPLIT + i + COMMON_SUFFIX);
            tasks.add(forkSort);
        }
        List<int[]> joinData = new ArrayList<>();
        int[] newData = new int[data.length];
        String joinFileName = "";
        try {
            List<Future<String>> futures = executor.invokeAll(tasks);
            executor.shutdown();
            if (!CollectionUtils.isEmpty(futures)) {
                for (Future<String> future : futures) {
                    final int[] sortedData = readFromFile(future.get());
                    joinData.add(sortedData);
                }
            }
            newData = mergeArray(newData, joinData);
            joinFileName = COMMON_PREFIX + COMMON_SPLIT + "merge" + COMMON_SUFFIX;
            String s = writeToFile(newData, joinFileName);
            System.out.println("s=" + s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return joinFileName;
    }

    class ForkSort implements Callable<String> {

        private int[] data;

        private String filePath;

        public ForkSort() {
        }

        public ForkSort(int[] data, String filePath) {
            this.data = data;
            this.filePath = filePath;
        }

        public int[] getData() {
            return data;
        }

        public void setData(int[] data) {
            this.data = data;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        @Override
        public String call() throws Exception {
            Arrays.sort(data);
            writeToFile(data, filePath);
            return filePath;
        }
    }

    /**
     * 将数组写入文件
     *
     * @param data
     * @param path
     * @return
     */
    public String writeToFile(int[] data, String path) {
        File file = new File(path);
        try (FileWriter fileWriter = new FileWriter(file);) {
            for (int i = 0; i < data.length; i++) {
                fileWriter.write(data[i] + ",");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }

    /**
     * 从文件读取数组
     *
     * @param path
     * @return
     */
    public int[] readFromFile(String path) {
        File file = new File(path);
        int[] result = null;
        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                final String[] lines = line.split("\t");
                if (lines.length > 0) {
                    for (String lineData : lines) {
                        result = Arrays.asList(lineData.split(",")).stream().mapToInt(Integer::parseInt).toArray();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 合并数组
     *
     * @param des
     * @param list
     * @return
     */
    public int[] mergeArray(int[] des, List<int[]> list) {
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            int[] ele = list.get(i);
            for (int j = 0; j < ele.length; j++) {
                des[index] = ele[j];
                index++;
            }
        }
        Arrays.sort(des);
        return des;
    }


    public static void main(String[] args) {
        final MultiThreadSort multiThreadSort = new MultiThreadSort();
        int[] data = {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        try {
            /*final String s = multiThreadSort.writeToFile(data, "/tmp/test.txt");
            final List<Integer> integers = multiThreadSort.readFromFile(s);
            System.out.println(integers);*/
            final String s = multiThreadSort.multiThreadSort(data);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
