package helloworld.techkids.meomunm.android7pomodoro.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import helloworld.techkids.meomunm.android7pomodoro.R;
import helloworld.techkids.meomunm.android7pomodoro.settings.SharedPrefs;

public class TaskSettingActivity extends AppCompatActivity {
    private TextView tvWorktime;
    private SeekBar sbWorktime;
    private TextView tvBreaktime;
    private SeekBar sbBreaktime;
    private TextView tvLongBreaktime;
    private SeekBar sbLongBreaktime;

    private static final String WORK_TIME_KEY = "worktime";
    private static final String BREAK_TIME_KEY = "breaktime";
    private static final String LONG_BREAK_TIME_KEY = "longbreaktime";

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

        loadSaveSettings();

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
                SharedPrefs.getInstance().put(new TaskSettingActivity(), WORK_TIME_KEY, sbWorktime.getProgress());
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
                SharedPrefs.getInstance().put(new TaskSettingActivity(), BREAK_TIME_KEY, sbBreaktime.getProgress());
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
                SharedPrefs.getInstance().put(new TaskSettingActivity(), LONG_BREAK_TIME_KEY, sbLongBreaktime.getProgress());
            }
        });
    }

    private void loadSaveSettings(){
        sbWorktime.setProgress(SharedPrefs.getInstance().getValue(WORK_TIME_KEY));
        sbBreaktime.setProgress(SharedPrefs.getInstance().getValue(BREAK_TIME_KEY));
        sbLongBreaktime.setProgress(SharedPrefs.getInstance().getValue(LONG_BREAK_TIME_KEY));

        tvWorktime.setText(String.format("Work time %s mins", sbWorktime.getProgress()));
        tvBreaktime.setText(String.format("Break time %s mins", sbBreaktime.getProgress()));
        tvLongBreaktime.setText(String.format("Long break %s mins", sbBreaktime.getProgress()));
    }
}
