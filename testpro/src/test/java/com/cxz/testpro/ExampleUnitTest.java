package com.cxz.testpro;

import com.cxz.testpro.thread.waitslepp.ThreadTest;

import org.junit.Test;

import static android.icu.util.ULocale.getName;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    int num = 0;
    volatile boolean flag = true;

    @Test
    public void addition_isCorrect() throws InterruptedException {
        String name = getName("123");
    }


}