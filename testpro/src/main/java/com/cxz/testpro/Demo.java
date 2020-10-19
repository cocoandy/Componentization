package com.cxz.testpro;

import android.app.Activity;
import android.os.Looper;

import com.google.gson.internal.LinkedHashTreeMap;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Demo {
    public static Activity activity = null;
    private volatile EnumMap enumMap;
    public HashMap hashMap;
    private TreeMap treeMap;
    private LinkedHashMap linkedHashMap;
    private LinkedHashTreeMap linkedHashTreeMap;

    private HashSet hashSet;
    private TreeSet treeSet;
    private EnumSet enumSet;
    private LinkedHashSet linkedHashSet;

    private void setData(){
        hashMap.put(1,1);
        hashMap.keySet();
        Looper.loop();
    }



}
