package com.cxz.testpro.thread.wait;

import com.cxz.testpro.BaseClass;

import org.junit.Test;

/**
 * 关于wait
 * 生产者和消费者
 * 每次拿到锁都要去判断是否符合条件
 * 所以wait要循环去判断执行
 */
public class ThreadTest extends BaseClass {
    static int num = 0;
    final int time = 200;

    @Test
    public void main() throws InterruptedException {
        Object obj = new Object();
        new CThread(obj).start();
        new PThread(obj).start();
        new CThread(obj).start();
        new CThread(obj).start();
        new CThread(obj).start();
        new CThread(obj).start();
        new CThread(obj).start();
        new CThread(obj).start();
        new CThread(obj).start();
        new CThread(obj).start();
        new CThread(obj).start();
        new CThread(obj).start();
        new CThread(obj).start();
        new CThread(obj).start();
        new CThread(obj).start();
        new CThread(obj).start();
        new CThread(obj).start();
        new CThread(obj).start();
        new CThread(obj).start();
        for (; ; ) {

        }
    }

    class CThread extends Thread {
        Object obj;

        CThread(Object obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            super.run();
            try {
                for (; ; ) {
                    synchronized (obj) {
                        while (num == 0) {
                            obj.wait();
                        }

                        num--;
                        System.out.println(Thread.currentThread().getName() + "消费了--->目前库存： " + num);
                        obj.notifyAll();
                        Thread.sleep((long) (Math.random() * time));
                    }

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    class PThread extends Thread {
        Object obj;

        PThread(Object obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            super.run();
            try {
                for (; ; ) {
                    synchronized (obj) {
                        while (num == 10) {
                            obj.wait();
                        }
                        num++;
                        System.out.println(Thread.currentThread().getName() + "生产了--->目前库存： " + num);
                        obj.notifyAll();
                        Thread.sleep((long) (Math.random() * time));
                    }

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
