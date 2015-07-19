package com.example.joel.studyaid;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by johnanderson1 on 7/19/15.
 */


public class SharedPreferenceHelper {
    private static final String APP_SHARED_PREF = SharedPreferenceHelper.class.getSimpleName();
    private SharedPreferences _sharedPreference;
    private SharedPreferences.Editor editor;

    public SharedPreferenceHelper(Context context) {
        this._sharedPreference = context.getSharedPreferences(APP_SHARED_PREF, Activity.MODE_PRIVATE);
        this.editor = _sharedPreference.edit();


    }

    public String getString(String key) {


        return _sharedPreference.getString(key, "No value stored yet");
    }

    public int getInt(String key) {


        return _sharedPreference.getInt(key, 0);
    }

    public String getBoolean(String key) {


        return _sharedPreference.getString(key, "No value stored yet");
    }

    public Long getLong(String key) {


        return _sharedPreference.getLong(key, 0);
    }

    public Boolean getBool(String key) {


        return _sharedPreference.getBoolean(key, false);
    }

    public void setData(String key, String data) {

        editor.putString(key, data);
        editor.commit();

    }

    public void setData(String key, int data) {
        editor.putInt(key, data);
        editor.commit();


    }

    public void setData(String key, long data) {
        editor.putLong(key, data);
        editor.commit();


    }

    public void setData(String key, Boolean data) {
        editor.putBoolean(key, data);
        editor.commit();


    }

    public void removeData() {
        editor.clear();
        editor.commit();


    }
}
