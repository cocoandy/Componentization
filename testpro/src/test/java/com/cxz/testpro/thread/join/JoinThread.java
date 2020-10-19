package com.cxz.testpro.thread.join;

class JoinThread extends Thread {


    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + "===================>" + isAlive());
    }


}
