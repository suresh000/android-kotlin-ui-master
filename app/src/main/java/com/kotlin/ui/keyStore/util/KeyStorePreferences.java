package com.kotlin.ui.keyStore.util;

import android.content.Context;
import android.content.SharedPreferences;

public class KeyStorePreferences {

    public static final String DB_PASSWORD = "dbPassword";

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    private static final String PREF_NAME = "store";

    private static KeyStorePreferences instance;

    public static KeyStorePreferences getInstance(Context context) {
        if (instance == null) {
            instance = new KeyStorePreferences(context);
        }
        return instance;
    }

    private KeyStorePreferences(Context context) {
        pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public void putString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public void putFloat(String key, float value) {
        editor.putFloat(key, value);
        editor.commit();
    }

    public void putLong(String key, long value) {
        editor.putLong(key, value);
        editor.commit();
    }

    public String getString(String key) {
        return pref.getString(key, null);
    }

    public boolean getBoolean(String key) {
        return pref.getBoolean(key, false);
    }

    public int getInt(String key) {
        return pref.getInt(key, -1);
    }

    public float getFloat(String key) {
        return pref.getFloat(key, -1);
    }

    public long getLong(String key) {
        return pref.getLong(key, -1);
    }

}
