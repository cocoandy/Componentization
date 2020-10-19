package com.cxz.testpro.thread.callable;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import org.junit.Test;

import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.xml.validation.Validator;

public class CallableTest {

    @Test
    public void main() throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (; ; ) {
                System.out.println("----------->");
            }
        });
        thread.start();
        Thread.sleep(1500);
        thread.interrupt();
//        Vector vector = new Vector();
//        vector.add("1322");
//
//        Stack stack = new Stack();
//        stack.add("1121");
//
//        Map map = new Hashtable();
//        map.put("12", 123);
//
//        StringBuffer buffer = new StringBuffer();
//        buffer.append("");
    }


}
