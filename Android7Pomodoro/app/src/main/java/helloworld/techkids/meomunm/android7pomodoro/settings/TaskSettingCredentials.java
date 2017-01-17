package helloworld.techkids.meomunm.android7pomodoro.settings;

import helloworld.techkids.meomunm.android7pomodoro.activities.TaskSettingActivity;

/**
 * Created by PT-LS on 1/17/2017.
 */

public class TaskSettingCredentials {
    private int worktime;
    private int breaktime;
    private int longBreaktime;

    public TaskSettingCredentials(int worktime, int breaktime, int longBreaktime){
        this.worktime = worktime;
        this.breaktime = breaktime;
        this.longBreaktime = longBreaktime;
    }

    public int getLongBreaktime() {
        return longBreaktime;
    }

    public void setLongBreaktime(int longBreaktime) {
        this.longBreaktime = longBreaktime;
    }

    public int getBreaktime() {
        return breaktime;
    }

    public void setBreaktime(int breaktime) {
        this.breaktime = breaktime;
    }

    public int getWorktime() {
        return worktime;
    }

    public void setWorktime(int worktime) {
        this.worktime = worktime;
    }

    @Override
    public String toString() {
        return "TaskSettingCredentials{" +
                "worktime=" + worktime +
                ", breaktime=" + breaktime +
                ", longBreaktime=" + longBreaktime +
                '}';
    }
}
