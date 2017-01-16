package helloworld.techkids.meomunm.android7pomodoro.settings;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import helloworld.techkids.meomunm.android7pomodoro.activities.TaskSettingActivity;

/**
 * Created by PT-LS on 1/16/2017.
 */

public class SharedPrefs {
    private static final String SHARED_PREFS_NAME = "SP";
    private static final String LOGIN_KEY = "login";
    private static final String WORK_TIME_KEY = "worktime";
    private static final String BREAK_TIME_KEY = "breaktime";
    private static final String LONG_BREAK_TIME_KEY = "longbreaktime";
    private static SharedPrefs instance;
    private SharedPreferences sharedPreferences;
    private Gson gson;

    public static SharedPrefs getInstance() {
        return instance;
    }

    public static void init(Context context) {
        instance = new SharedPrefs(context);
    }

    public SharedPrefs(Context context) {
        this.sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        this.gson = new Gson();
    }

    public void put(LoginCredentials loginCredentials) {
        //1. convert object to String
        String loginJSON = gson.toJson(loginCredentials);
        //2. put
        this.sharedPreferences.edit().putString(LOGIN_KEY, loginJSON).commit();
    }

    public void put(TaskSettingActivity taskSettingActivity, String key, int value) {
        int valueSetting = value;
        if (key.equals(this.WORK_TIME_KEY)) {
            this.sharedPreferences.edit().putInt(WORK_TIME_KEY, valueSetting).commit();
        } else if (key.equals(BREAK_TIME_KEY)) {
            this.sharedPreferences.edit().putInt(BREAK_TIME_KEY, valueSetting).commit();
        } else if (key.equals(LONG_BREAK_TIME_KEY)) {
            this.sharedPreferences.edit().putInt(LONG_BREAK_TIME_KEY, valueSetting).commit();
        }
    }
    public int getValue(String key){
        if (key.equals(WORK_TIME_KEY)){
            return sharedPreferences.getInt(WORK_TIME_KEY, 0);
        }else if (key.equals(BREAK_TIME_KEY)){
            return sharedPreferences.getInt(BREAK_TIME_KEY, 0);
        }else if (key.equals(LONG_BREAK_TIME_KEY)){
            return sharedPreferences.getInt(LONG_BREAK_TIME_KEY, 0);
        } return 0;
    }

    public LoginCredentials getLoginCredentials() {
        //1. get String
        String loginJSON = this.sharedPreferences.getString(LOGIN_KEY, null);
        //2. Convert string to object
        if (loginJSON == null) return null;
        LoginCredentials loginCredentials = gson.fromJson(loginJSON, LoginCredentials.class);
        return loginCredentials;
    }
}
