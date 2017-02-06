package helloworld.techkids.meomunm.android7pomodoro.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import helloworld.techkids.meomunm.android7pomodoro.R;
import helloworld.techkids.meomunm.android7pomodoro.settings.SharedPrefs;
import helloworld.techkids.meomunm.android7pomodoro.settings.TaskSettingCredentials;

public class TaskSettingActivity extends AppCompatActivity {
    private TextView tvWorktime;
    private SeekBar sbWorktime;
    private TextView tvBreaktime;
    private SeekBar sbBreaktime;
    private TextView tvLongBreaktime;
    private SeekBar sbLongBreaktime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_setting);

        tvWorktime = (TextView) findViewById(R.id.tv_worktime);
        sbWorktime = (SeekBar) findViewById(R.id.sb_worktime);

        tvBreaktime = (TextView) findViewById(R.id.tv_breaktime);
        sbBreaktime = (SeekBar) findViewById(R.id.sb_breaktime);

        tvLongBreaktime = (TextView) findViewById(R.id.tv_longbreaktime);
        sbLongBreaktime = (SeekBar) findViewById(R.id.sb_longbreaktime);

        loadSaveSetting();

        sbWorktime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvWorktime.setText(String.format("Work time %s mins", sbWorktime.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                SharedPrefs.getInstance().put(new TaskSettingCredentials(
                        sbWorktime.getProgress(),
                        sbBreaktime.getProgress(),
                        sbLongBreaktime.getProgress()));
            }
        });
        sbBreaktime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvBreaktime.setText(String.format("Break time %s mins", sbBreaktime.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                SharedPrefs.getInstance().put(new TaskSettingCredentials(
                        sbWorktime.getProgress(),
                        sbBreaktime.getProgress(),
                        sbLongBreaktime.getProgress()));
            }
        });
        sbLongBreaktime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvLongBreaktime.setText(String.format("Long break time %s mins", sbLongBreaktime.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                SharedPrefs.getInstance().put(new TaskSettingCredentials(
                        sbWorktime.getProgress(),
                        sbBreaktime.getProgress(),
                        sbLongBreaktime.getProgress()));
            }
        });
    }
    public void loadSaveSetting(){
        tvWorktime.setText(String.format("Work time %s mins", SharedPrefs.getInstance().getTaskSettingCredentials().getWorktime()));
        tvBreaktime.setText(String.format("Break time %s mins", SharedPrefs.getInstance().getTaskSettingCredentials().getBreaktime()));
        tvLongBreaktime.setText(String.format("Long break time %s mins", SharedPrefs.getInstance().getTaskSettingCredentials().getLongBreaktime()));
        if (SharedPrefs.getInstance().getTaskSettingCredentials() == null){
            sbWorktime.setProgress(25);
            sbBreaktime.setProgress(5);
            sbLongBreaktime.setProgress(10);
        }else {
            sbWorktime.setProgress(SharedPrefs.getInstance().getTaskSettingCredentials().getWorktime());
            sbBreaktime.setProgress(SharedPrefs.getInstance().getTaskSettingCredentials().getBreaktime());
            sbLongBreaktime.setProgress(SharedPrefs.getInstance().getTaskSettingCredentials().getLongBreaktime());
        }
    }
}
