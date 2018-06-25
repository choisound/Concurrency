package com.cyx.concurrucy.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ConcurrencyTest {
    //计数数量
    private static int count = 0;
    //所有线程数
    private static int totalThread = 5000;
    //最大并发线程数
    private static int limitThread = 200;
    public static void main(String []args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        Semaphore semaphore = new Semaphore(limitThread);
        for(int i = 0; i<totalThread; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
    }
    private static void add(){

    }
}
