package com.cxz.testpro.thread.waitslepp;

public class SleepThread extends Thread {
    Object object;

    public SleepThread(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i <20 ; i++) {

        } {
            try {
                Thread.sleep(1500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object) {

                object.notify();
                System.out.println("Sleep------------->");
            }
        }

    }
}