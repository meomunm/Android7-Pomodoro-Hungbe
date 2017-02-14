package helloworld.techkids.meomunm.android7pomodoro.databases;

import java.util.ArrayList;
import java.util.List;

import helloworld.techkids.meomunm.android7pomodoro.databases.models.Task;

/**
 * Created by PT-LS on 2/8/2017.
 */

public class DbContext {
    public static final DbContext instance = new DbContext();

    public List<Task> allTask(){
        //Create array list
        ArrayList<Task> task = new ArrayList<>();

        //2: add some task and return
        task.add(new Task("Study recycelview", "#FFC107"));
        task.add(new Task("Study recycelview","#2E7D32" ));
        task.add(new Task("Study recycelview", "#64DD17"));
        task.add(new Task("Study recycelview","#303F9F" ));
        task.add(new Task("Study recycelview","#D50000" ));

        return task;
    }
}
