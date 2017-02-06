package helloworld.techkids.meomunm.android7pomodoro.networks.jsonmodel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by PT-LS on 2/5/2017.
 */

public class LoginResponseJson {
    @SerializedName("access_token")
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }
    


}
