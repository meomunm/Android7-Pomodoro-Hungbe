package helloworld.techkids.meomunm.android7pomodoro;

import android.app.Application;
import android.util.Log;

import helloworld.techkids.meomunm.android7pomodoro.settings.SharedPrefs;


/**
 * Created by PT-LS on 1/16/2017.
 */

public class PomodoroApplication extends Application {
    private static final String TAG = "PomodoroApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
        SharedPrefs.init(this);
    }
}
