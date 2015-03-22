package com.factory.asv.mtglifecounter;

import android.os.Debug;
import android.util.Log;

/**
 * Created by nuborisar on 22/03/2015.
 */
public class logg {
    private static logg ourInstance = new logg();

    public static logg getInstance() {
        return ourInstance;
    }

    private logg() {
    }

    public static void printD(Exception str) {
        Log.d("DEBUG", str.toString());
    }

    public static void printE(Exception str) {
        Log.e("TAG", str.toString());
    }

    public static void printWTF(Exception str) {
        Log.wtf("WTF", str.toString());
    }

    public static void printD(String str) {
        Log.d("DEBUG", str);
    }

    public static void printE(String str) {
        Log.e("TAG", str);
    }

    public static void printWTF(String str) {
        Log.wtf("WTF", str);
    }
}
