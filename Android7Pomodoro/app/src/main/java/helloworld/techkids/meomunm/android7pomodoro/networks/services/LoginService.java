package helloworld.techkids.meomunm.android7pomodoro.networks.services;

import helloworld.techkids.meomunm.android7pomodoro.networks.jsonmodel.LoginResponseJson;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by PT-LS on 2/5/2017.
 */

public interface LoginService {
    @POST("login")
    Call<LoginResponseJson> login(@Body RequestBody body); //phương thức login có kiểu trả về là Call
                                                           //Call là 1 phương thức request để bắn tới Server
}
