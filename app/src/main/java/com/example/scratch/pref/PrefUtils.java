package com.example.scratch.pref;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.example.scratch.core.Contextor;


public class PrefUtils {

    private static final String TAG = "PrefUtils";

    private static PrefUtils instance = null;
    private SharedPreferences sp;
    private final String PREF_NAME = "shared_pref";


    public static synchronized PrefUtils getInstance() {
        if (instance == null)
            instance = new PrefUtils();
        return instance;
    }

    private PrefUtils() {
        Context context = Contextor.getInstance().getContext();
        //sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        sp = PreferenceManager.getDefaultSharedPreferences(context);
    }


    public void putInt(String key, int value) {

        SharedPreferences.Editor ed = sp.edit();
        ed.putInt(key, value);
        ed.apply();

    }

    public void putLong(String key, long value) {

        SharedPreferences.Editor ed = sp.edit();
        ed.putLong(key, value);
        ed.apply();

    }

    public void putFloat(String key, float value) {

        SharedPreferences.Editor ed = sp.edit();
        ed.putFloat(key, value);
        ed.apply();

    }

    public void putString(String key, String value) {

        SharedPreferences.Editor ed = sp.edit();
        ed.putString(key, value);
        ed.apply();

    }

    public void putBoolean(String key, boolean value) {

        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean(key, value);
        ed.apply();

    }


    public int getInt(String key, int defValue) {

        return sp.getInt(key, defValue);
    }

    public long getLong(String key, long defValue) {

        return sp.getLong(key, defValue);
    }

    public boolean getBoolean(String key, boolean defValue) {

        return sp.getBoolean(key, defValue);
    }

    public float getFloat(String key, float defValue) {

        return sp.getFloat(key, defValue);
    }

    public String getString(String key, String defValue) {

        return sp.getString(key, defValue);
    }

    public void remove(String key) {

        SharedPreferences.Editor ed = sp.edit();

        try {
            ed.remove(key);
            ed.apply();
            Log.d(TAG, "remove: " + key + " removed successfully");
        } catch (Exception e) {
            Log.e(TAG, "remove: " + e.getMessage(), e);
            e.printStackTrace();
        }

    }

    public void clear() {

        SharedPreferences.Editor ed = sp.edit();
        try {
            ed.clear();
            //ed.commit();
            ed.apply();
            Log.d(TAG, "clear: Preference cleared successfully");
        } catch (Exception e) {
            Log.e(TAG, "clear: " + e.getMessage(), e);
            e.printStackTrace();

        }
    }


}

