package helloworld.techkids.meomunm.android7pomodoro.databases.models;

/**
 * Created by PT-LS on 2/8/2017.
 */

public class Task {
    private String color;
    private String name;

    public Task(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Task{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
