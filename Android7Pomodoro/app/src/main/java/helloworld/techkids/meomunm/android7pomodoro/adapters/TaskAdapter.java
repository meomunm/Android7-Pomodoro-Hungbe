package helloworld.techkids.meomunm.android7pomodoro.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import helloworld.techkids.meomunm.android7pomodoro.R;
import helloworld.techkids.meomunm.android7pomodoro.adapters.viewholders.TaskViewHolder;
import helloworld.techkids.meomunm.android7pomodoro.databases.DbContext;
import helloworld.techkids.meomunm.android7pomodoro.databases.models.Task;

/**
 * Created by PT-LS on 2/8/2017.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder>{
    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //1. create view
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_task, parent, false);

        //2. create viewholder
        TaskViewHolder taskViewHolder = new TaskViewHolder(itemView);
        return taskViewHolder;
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        //1. get data based on position
        Task task = DbContext.instance.allTask().get(position);

        //2. bind data into view
        holder.bind(task);
    }

    @Override
    public int getItemCount() {
        return DbContext.instance.allTask().size();
    }
}
