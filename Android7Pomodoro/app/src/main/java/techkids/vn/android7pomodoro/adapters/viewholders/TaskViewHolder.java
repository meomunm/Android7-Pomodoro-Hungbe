package techkids.vn.android7pomodoro.adapters.viewholders;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import techkids.vn.android7pomodoro.R;
import techkids.vn.android7pomodoro.databases.models.Task;
import techkids.vn.android7pomodoro.utils.Utils;

/**
 * Created by huynq on 2/8/17.
 */

public class TaskViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.v_task_color)
    View vTaskColor;

    @BindView(R.id.tv_task_name)
    TextView tvTaskName;

    @BindView(R.id.ib_button)
    ImageButton ibButton;

    public ImageButton getIbButton() {
        return ibButton;
    }

    public TaskViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Task task) {
        //1: Bind Color
//        vTaskColor.setBackgroundColor(Color.parseColor(task.getColor()));
        Utils.setSolidColor(vTaskColor, task.getColor());

        //2: Bind Task name
        tvTaskName.setText(task.getName());
    }
}
