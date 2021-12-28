package com.coding.interview.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @author: HYC
 * @createTime: 2021/12/28 3:09 下午
 * @description: 编写一个程序，开启3个线程A，B，C，给定一组数据，将该数据分成3部分，分别让ABC三个线程进行排序处理（存储到本地文件中），三个线程处理完成之后，将这个三个文件内容读取后合并成一个有序文件,返回文件路径
 * 输入： 4,2,3,1,6,5,9,7,8
 * 分配：A : 4,2,3 B:1,6,5 C: 9,7,8
 * 输出：
 * 文件A内容：2，3，4
 * 文件B内容：1，5，6
 * 文件C内容：7，8，9
 * 结果文件内容： 1，2，3，4，5，6，7，8，9
 */
public class ConcurrentBuildData {

    private static Logger log = LoggerFactory.getLogger(ConcurrentBuildData.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (StringUtils.isEmpty(line)) {
            return;
        }
        int[] array = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
        ConcurrentBuildData concurrentBuildData = new ConcurrentBuildData();
        String s = concurrentBuildData.concurrentBuildData(array);
        log.info("合并之后的文件名为:{}", s);
    }

    /**
     * 只有三个线程，可以创建一个核心数为0，最大线程数为3的线程池
     */
    private ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(5), new ThreadFactoryBuilder().build());

    //文件前缀
    private final String COMMON_PREFIX = "/tmp/data";
    //文件后缀
    private final String COMMON_SUFFIX = ".txt";
    //文件名分隔符
    private final String COMMON_FILE_SPLIT = "-";
    //合并之后的文件名
    private final String MERGE_FILE_PATH = COMMON_PREFIX + COMMON_FILE_SPLIT + "merge" + COMMON_SUFFIX;

    public String concurrentBuildData(int[] data) {
        if (null == data || data.length == 0) {
            return "";
        }

        int size = data.length;
        //分隔子数组的平均长度
        int length = size / 3;
        //如果不是3的倍数，部分数组元素会多一些
        int mod = size % 3;
        int begin = 0, end = 0;
        List<ForkSortTask> tasks = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            end = mod > 0 ? (begin + length + mod) : (begin + length);
            int[] subData = Arrays.copyOfRange(data, begin, end);
            begin = end;
            --mod;
            //分隔数组并创建排序任务
            ForkSortTask forkSortTask = new ForkSortTask(subData, COMMON_PREFIX + COMMON_FILE_SPLIT + i + COMMON_SUFFIX);
            //加入任务组
            tasks.add(forkSortTask);
        }
        return forkAndJoin(tasks, size);

    }

    /**
     * 分开执行并合并
     *
     * @param tasks 要执行的子任务
     * @param size  新数组的长度（原始数据长度）
     * @return 返回合并之后的文件名
     */
    public String forkAndJoin(List<ForkSortTask> tasks, int size) {
        List<int[]> joinData = new ArrayList<>();
        int[] newData = new int[size];
        try {
            //分开执行子任务
            List<Future<String>> futures = executor.invokeAll(tasks);
            executor.shutdown();
            //执行结束后合并结果
            if (!CollectionUtils.isEmpty(futures)) {
                for (Future<String> future : futures) {
                    //每个future返回文件名，再从文件名读取数据到数组（已排好序）
                    int[] sortedData = readFromFile(future.get());
                    joinData.add(sortedData);
                }
            }
            //合并数组并排序
            newData = mergeArray(newData, joinData);
            String s = writeToFile(newData, MERGE_FILE_PATH);
            log.info("s={}", s);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return MERGE_FILE_PATH;
    }

    /**
     * 排序并写入文件的任务
     */
    private class ForkSortTask implements Callable<String> {

        /**
         * 当前线程要处理的数据
         */
        private int[] data;

        /**
         * 将数据写入的文件
         */
        private String filePath;

        public ForkSortTask() {
        }

        public ForkSortTask(int[] data, String filePath) {
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
        public String call() {
            Arrays.sort(data);
            writeToFile(data, filePath);
            System.out.println("当前线程：" + Thread.currentThread().getName());
            return filePath;
        }
    }

    /**
     * 将数组写入文件
     *
     * @param data 要写入的数据
     * @param path 文件名
     * @return 返回文件名
     */
    public String writeToFile(int[] data, String path) {
        File file = new File(path);
        try (FileWriter fileWriter = new FileWriter(file);) {
            for (int datum : data) {
                fileWriter.write(datum + ",");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }

    /**
     * 从文件读取数组
     *
     * @param path 要读取的文件名
     * @return 返回从文件读取的数据，数组
     */
    public int[] readFromFile(String path) {
        File file = new File(path);
        int[] result = null;
        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] lines = line.split("\t");
                if (lines.length > 0) {
                    for (String lineData : lines) {
                        result = Arrays.stream(lineData.split(",")).mapToInt(Integer::parseInt).toArray();
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
     * @param des  合并之后的数组
     * @param list 要合并的数组
     * @return 返回合并之后的数组
     */
    public int[] mergeArray(int[] des, List<int[]> list) {
        int index = 0;
        for (int[] ele : list) {
            for (int k : ele) {
                des[index] = k;
                index++;
            }
        }
        Arrays.sort(des);
        return des;
    }
}
