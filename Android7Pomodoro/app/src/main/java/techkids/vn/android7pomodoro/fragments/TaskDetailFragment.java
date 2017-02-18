package techkids.vn.android7pomodoro.fragments;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import techkids.vn.android7pomodoro.R;
import techkids.vn.android7pomodoro.activities.TaskActivity;
import techkids.vn.android7pomodoro.adapters.TaskColorAdapter;
import techkids.vn.android7pomodoro.databases.DbContext;
import techkids.vn.android7pomodoro.databases.models.Task;
import techkids.vn.android7pomodoro.decorations.TaskColorDecor;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskDetailFragment extends Fragment {

//    public interface TaskAction {
//        void doIt(Task taskName);
//    }
//
//    public class TaskAddBehavior implements TaskAction {
//
//        @Override
//        public void doIt(Task taskName) {
//            String taskNameDoit = etTaskName.getText().toString();
//            float paymentPerHourDoit = Float.parseFloat(etPaymentPerHour.getText().toString());
//            String colorDoit = taskColorAdapter.getSelectedColor();
//
//            Task newTask = new Task(taskNameDoit, colorDoit, paymentPerHourDoit);
//            DbContext.instance.addTask(newTask);
//            getActivity().onBackPressed();
//            Log.d(TAG, "doIt: OnADDDDDDDDDDDDDDDDDD");
//        }
//    }
//
//    public class TaskEditBehavior implements TaskAction{
//
//        @Override
//        public void doIt(Task taskName) {
//            if (task != null) {
//                etTaskName.setText(task.getName());
//                etPaymentPerHour.setText(String.format("%.1f", task.getPaymentPerHour()));
//                taskColorAdapter.setSelectedColor(task.getColor());
//            }
//            Log.d(TAG, "doIt: OnnnnnnnnnnEDITTTTTTTTT");
//        }
//    }
//
//    public class UseTaskBehavior{
//        private TaskAction taskAction;
//
//        public UseTaskBehavior(TaskAction taskAction) {
//            this.taskAction = taskAction;
//        }
//
//        public void executeTaskBehavior(Task taskName){
//            taskAction.doIt(taskName);
//        }
//    }

    private static String TAG = "TaskDetailFragment";

    @BindView(R.id.rv_task_color)
    RecyclerView rvTaskColor;

    @BindView(R.id.et_task_name)
    EditText etTaskName;

    @BindView(R.id.et_payment_per_hour)
    EditText etPaymentPerHour;

    private TaskColorAdapter taskColorAdapter;

    private String title;
    private Task task;

    public TaskDetailFragment() {


        // Required empty public constructor
        setHasOptionsMenu(true);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task_detail, container, false);
        setupUI(view);
        return view;
    }

    private void setupUI(View view) {
        ButterKnife.bind(this, view);

        taskColorAdapter = new TaskColorAdapter();

        rvTaskColor.setLayoutManager(new GridLayoutManager(this.getContext(), 4));
        rvTaskColor.setAdapter(taskColorAdapter);
        rvTaskColor.addItemDecoration(new TaskColorDecor());

        if (getActivity() instanceof TaskActivity) {
            ((TaskActivity) getActivity()).getSupportActionBar().setTitle(title);
        }

        if (task != null) {
            // Edit
            etTaskName.setText(task.getName());
            etPaymentPerHour.setText(String.format("%.1f", task.getPaymentPerHour()));
            taskColorAdapter.setSelectedColor(task.getColor());
            Log.d(TAG, "setupUI: Edittttttttttttttttttttttt");
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_edit_task, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected: ");

        if (item.getItemId() == R.id.mni_ok) {
            Log.d(TAG, "onOptionsItemSelected: OK clicked");
//            if (task != null){
//            UseTaskBehavior useTaskBehavior = new UseTaskBehavior(new TaskEditBehavior());
//            useTaskBehavior.executeTaskBehavior(task,task.getColor(),task.getPaymentPerHour());
//            }
            if (task != null) {
//                etTaskName.setText(etTaskName.getText());
//                etPaymentPerHour.setText(etPaymentPerHour.getText());
//                taskColorAdapter.setSelectedColor(task.getColor());

                task.setName(etTaskName.getText().toString());
                task.setPaymentPerHour(Float.parseFloat(etPaymentPerHour.getText().toString().replace(",",".")));
                task.setColor(taskColorAdapter.getSelectedColor());

                etTaskName.setText(task.getName());
                etPaymentPerHour.setText(String.format("%.1f", task.getPaymentPerHour()));
                taskColorAdapter.setSelectedColor(task.getColor());

                Log.d(TAG, "onOptionsItemSelected: AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa");
                getActivity().onBackPressed();
            } else {

                // 1: Get data from UI
                String taskName = etTaskName.getText().toString();
                float paymentPerHour = Float.parseFloat(etPaymentPerHour.getText().toString());
                String color = taskColorAdapter.getSelectedColor();

//            // 2: Create new TASK
                Task newTask = new Task(taskName, color, paymentPerHour);

//            // 3: Add to database
                DbContext.instance.addTask(newTask);

                Log.d(TAG, "onOptionsItemSelected: BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
                getActivity().onBackPressed();
            }

        }
        return false;
    }

}
