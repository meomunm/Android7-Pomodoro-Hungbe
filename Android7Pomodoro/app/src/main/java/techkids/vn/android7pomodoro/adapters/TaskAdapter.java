package techkids.vn.android7pomodoro.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import techkids.vn.android7pomodoro.R;
import techkids.vn.android7pomodoro.adapters.viewholders.TaskViewHolder;
import techkids.vn.android7pomodoro.databases.DbContext;
import techkids.vn.android7pomodoro.databases.models.Task;

/**
 * Created by huynq on 2/8/17.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    private TaskItemClickListener taskItemClickListener;
    private TaskPlayClickListener taskPlayClickListener;

    public interface TaskItemClickListener {
        void onItemClick(Task task);

    }

    public interface TaskPlayClickListener{
        void onPlayClick(Task task);
    }

    public void setTaskPlayClickListener(TaskPlayClickListener taskPlayClickListener) {
        this.taskPlayClickListener = taskPlayClickListener;
    }

    public void setTaskItemClickListener(TaskItemClickListener taskItemClickListener) {
        this.taskItemClickListener = taskItemClickListener;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //1: Create View
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_task, parent, false);

        //2: Create ViewHolder
        TaskViewHolder taskViewHolder = new TaskViewHolder(itemView);
        return taskViewHolder;
    }

    @Override
    public void onBindViewHolder(final TaskViewHolder holder, int position) {
        //1: Get data based on position
        final Task task = DbContext.instance.allTasks().get(position);

        //2: Bind data into view
        holder.bind(task);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            //throw event click task
            @Override
            public void onClick(View v) {
                // send event to outside
                if (taskItemClickListener != null) {
                    taskItemClickListener.onItemClick(task);

                }

            }
        });

        holder.getIbButton().setOnClickListener(new View.OnClickListener() {
            //throw event click Button (play)
            @Override
            public void onClick(View v) {
                if (taskPlayClickListener != null){
                    taskPlayClickListener.onPlayClick(task);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return DbContext.instance.allTasks().size();
    }
}