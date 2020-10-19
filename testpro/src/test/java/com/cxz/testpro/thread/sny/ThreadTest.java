package com.cxz.testpro.thread.sny;

import org.junit.Test;

/**
 * synchronized
 * 操作共同资源的地方用synchronized修饰和volatile
 * 解决竞态条件和内存不可见
 * 竞态条件：多线程操作公共数据，结果和执行的时序有关，也就是线程调度问题
 * 内存不可见：数据存在内存里。但是多线程操作数据的时候从缓存中获取，然后更改后，没有同步到内存导致计算结果没有达到单线程那样的效果
 */
class ThreadTest {

    @Test
    public void main() throws InterruptedException {
        int num = 100;
        School school = new School();
        Thread[] threads = new Thread[num];
        for (int i = 0; i < num; i++) {
            threads[i] = new CounThread(school);
            threads[i].start();
        }

        for (int i = 0; i < num; i++) {
            threads[i].join();
        }

        System.out.println("This school total student:" + school.getPeople());
    }

    class School {
        int students;

        volatile int people;

        /**
         * 多线程 执行该方法
         * 当某一个线程执行到synchronized获得了锁 ，然后其他线程进来后会进入等待队列、
         * 得到锁的线程执行代码体
         * 执行完之后释放锁 唤醒别的线程（这个是随机性的 ）
         */
        public void addBoy() {
            //锁代码块
            synchronized (School.class) {
                students++;
            }
        }

        //方法锁
        public synchronized void addGirl() {
            students++;
        }

        public int getStudents() {
            return students;
        }

        /**
         * 虽然该方法中没有使用syn关键字 也没有锁 但是用了原子变量volatile
         */
        public void addPeople() {
            people++;
        }

        public int getPeople() {
            return people;
        }
    }

    class CounThread extends Thread {
        School school;

        CounThread(School school) {
            this.school = school;
        }

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 100; i++) {
                school.addPeople();
            }
        }
    }
}
