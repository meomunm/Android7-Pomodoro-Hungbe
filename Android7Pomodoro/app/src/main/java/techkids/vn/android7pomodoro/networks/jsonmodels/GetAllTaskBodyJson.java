package techkids.vn.android7pomodoro.networks.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by PT-LS on 2/21/2017.
 */

public class GetAllTaskBodyJson {
    @SerializedName("done")
    private String isDone;

    @SerializedName("id")
    private String id;

    @SerializedName("payment_per_hour")
    private String paymentPerHour;

    @SerializedName("name")
    private String name;

    @SerializedName("color")
    private String color;

    public String getIsDone() {
        return isDone;
    }

    public void setIsDone(String isDone) {
        this.isDone = isDone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaymentPerHour() {
        return paymentPerHour;
    }

    public void setPaymentPerHour(String paymentPerHour) {
        this.paymentPerHour = paymentPerHour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "GetAllTaskBodyJson{" +
                "isDone='" + isDone + '\'' +
                ", id='" + id + '\'' +
                ", paymentPerHour='" + paymentPerHour + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
