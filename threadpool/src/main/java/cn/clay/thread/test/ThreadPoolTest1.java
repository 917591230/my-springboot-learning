package cn.clay.thread.test;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreadPoolTest1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadPoolTest1.class);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Execute in a thread");
            for (int i = 0; i < 2; i++)
                System.out.println(i);
        });
        t1.start();
        System.out.println("=============================");
        //对于线上应用会导致异常信息丢失，不能加日志输出到文件
//        Thread t2 = new Thread(() -> System.out.println(1 / 0));
//        t2.start();
        Thread t3 = new Thread(() -> {
            try {
                System.out.println(1 / 0);
            } catch (Exception e) {

                LOGGER.error(e.getMessage(), e);
            }
        });
        t3.start();
        System.out.println("========================================");
//        Executors.newSingleThreadExecutor().execute(() -> {
//            throw new RuntimeException("My runtime exception");
//        });
//        System.out.println("====================");
//        ThreadFactory executorThreadFactory = new BasicThreadFactory.Builder()
//                .namingPattern("task-scanner-executor-%d")
//                .uncaughtExceptionHandler(new LogUncaughtExceptionHandler(LOGGER))
//                .build();
//        Executors.newSingleThreadExecutor(executorThreadFactory);

    }




}
