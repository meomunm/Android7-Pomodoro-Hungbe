package techkids.vn.android7pomodoro.networks.services;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import techkids.vn.android7pomodoro.networks.jsonmodels.GetAllTaskBodyJson;

/**
 * Created by PT-LS on 2/21/2017.
 */

public interface AddNewTaskService {
    @POST("task")
    Call<GetAllTaskBodyJson> addNewTask(@Header("Content-Type") String type
            , @Header("Authorization") String jwtToken
            , @Body RequestBody body);
}
