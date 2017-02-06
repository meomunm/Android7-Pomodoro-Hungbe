package helloworld.techkids.meomunm.android7pomodoro.networks.services;

import helloworld.techkids.meomunm.android7pomodoro.networks.jsonmodel.RegisterReponseJson;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by PT-LS on 2/6/2017.
 */

public interface RegisterService {
    @POST("register")
    Call<RegisterReponseJson> register(@Body RequestBody body);
}
