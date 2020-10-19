package com.cxz.testpro.thread.join;

class HttpUtil {

    void startHttp(long time, int flag) {
        Thread thread = new Thread(() -> {
            JoinThread jt = new JoinThread();
            jt.setName("Threa_" + flag);
            jt.start();

            try {
                jt.join(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            jt.interrupt();
            System.out.println(Thread.currentThread().getName() + "----------" + time + "------>" + flag);
        });
        thread.start();
    }


    void startHttp1() {
        Thread thread = new Thread(() -> {
            JoinThread jt = new JoinThread();
            jt.setName("Threa>>" + 1);
            jt.setDaemon(true);
            jt.start();
            try {
                jt.join(500);
            } catch (InterruptedException e) {
            }
            jt.interrupt();
            System.out.println(Thread.currentThread().getName());
        });
        thread.setName("Threa--" + 1);
        thread.start();
    }


    void startHttp2() {
        Thread thread = new Thread(() -> {
            JoinThread jt = new JoinThread();
            jt.setName("Threa>>" + 2);
            jt.setDaemon(true);
            jt.start();
            try {
                jt.join(3000);
            } catch (InterruptedException e) {
            }
            jt.interrupt();
            System.out.println(Thread.currentThread().getName());
        });
        thread.setName("Threa--" + 2);
        thread.start();
    }

    void startHttp3() {
        Thread thread = new Thread(() -> {
            JoinThread jt = new JoinThread();
            jt.setName("Threa>>" + 3);
            jt.setDaemon(true);
            jt.start();
            try {
                jt.join(7000);
            } catch (InterruptedException e) {
            }
            jt.interrupt();
            System.out.println(Thread.currentThread().getName());
        });
        thread.setName("Threa--" + 3);
        thread.start();
    }
}
