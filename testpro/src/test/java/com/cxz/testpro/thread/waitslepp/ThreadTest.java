package com.cxz.testpro.thread.waitslepp;

import android.nfc.Tag;
import android.util.Log;

import com.cxz.testpro.BaseClass;
import com.cxz.testpro.thread.waitslepp.SleepThread;
import com.cxz.testpro.thread.waitslepp.WaitThread;

import org.junit.Test;

/**
 * 关于wait和sleep
 * 注意：wait和sleep会抛出异常
 * 1. wait()
 * wait是Object的方法；
 * wait方法使线程让出cpu同时释放锁，直到这个这个对象调用notify后才回到等待syn的队列
 * wait需要和syn配合使用
 * 2.sleep()
 * sleep是Thread的方法,是操作自身流程的方法；
 * sleep方法使线程让出cpu但是并未释放锁资源，等到时间过后，会继续执行
 * sleep可以单独使用
 */
public class ThreadTest extends BaseClass {
    @Test
    public void main() throws InterruptedException {
        Object obj = new Object();
        WaitThread wait = new WaitThread(obj);
        SleepThread sleep = new SleepThread(obj);
        wait.start();
        sleep.start();
        wait.join();
        sleep.join();
    }
}
