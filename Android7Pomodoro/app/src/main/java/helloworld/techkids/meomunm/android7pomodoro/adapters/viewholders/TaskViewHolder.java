package helloworld.techkids.meomunm.android7pomodoro.adapters.viewholders;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import helloworld.techkids.meomunm.android7pomodoro.R;
import helloworld.techkids.meomunm.android7pomodoro.databases.models.Task;

/**
 * Created by PT-LS on 2/8/2017.
 */

public class TaskViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.v_task_color)
    View vTaskColor;

    @BindView(R.id.tv_task_name)
    TextView tvTaskName;

    public TaskViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Task task) {
        //1. bind color
        //vTaskColor.setBackgroundColor(Color.parseColor(task.getColor()));
        GradientDrawable drawable = (GradientDrawable) vTaskColor.getBackground();
        drawable.setColor(Color.parseColor(task.getColor()));

        //2. bind task name
        tvTaskName.setText(task.getName());
    }
}
