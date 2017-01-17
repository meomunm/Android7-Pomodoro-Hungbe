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
    private static final String TASK_SETTING_KEY = "setting";
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

    public void put(TaskSettingCredentials taskSettingCredentials) {
        String taskSettingJSON = gson.toJson(taskSettingCredentials);
        this.sharedPreferences.edit().putString(TASK_SETTING_KEY, taskSettingJSON).commit();
    }

    public LoginCredentials getLoginCredentials() {
        //1. get String
        String loginJSON = this.sharedPreferences.getString(LOGIN_KEY, null);
        //2. Convert string to object
        if (loginJSON == null) return null;
        LoginCredentials loginCredentials = gson.fromJson(loginJSON, LoginCredentials.class);
        return loginCredentials;
    }

    public TaskSettingCredentials getTaskSettingCredentials(){
        String taskSettingJSON = this.sharedPreferences.getString(TASK_SETTING_KEY, null);
        if (taskSettingJSON == null) {return null;}
        TaskSettingCredentials taskSettingCredentials = gson.fromJson(taskSettingJSON, TaskSettingCredentials.class);
        return taskSettingCredentials;
    }
}
