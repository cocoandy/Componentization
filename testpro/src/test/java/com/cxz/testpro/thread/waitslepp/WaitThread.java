package com.cxz.testpro.thread.waitslepp;

/**
 * 虽然wait释放了锁但是notify后进如等待队列还是会从wati那里执行
 */
public class WaitThread extends Thread {
    Object object;

    public WaitThread(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        synchronized (object) {
            try {
                System.out.println("Wait-------------> waiting1");
                object.wait();
                System.out.println("Wait-------------> waiting2");
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Wait------------->");
        }


    }
}
