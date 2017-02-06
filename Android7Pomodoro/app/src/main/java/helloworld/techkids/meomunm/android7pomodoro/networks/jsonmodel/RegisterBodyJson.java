package helloworld.techkids.meomunm.android7pomodoro.networks.jsonmodel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by PT-LS on 2/6/2017.
 */

public class RegisterBodyJson {
    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    public RegisterBodyJson(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegisterBodyJson{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
