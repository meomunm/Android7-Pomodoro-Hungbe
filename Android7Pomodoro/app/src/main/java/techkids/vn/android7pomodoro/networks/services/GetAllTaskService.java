package techkids.vn.android7pomodoro.networks.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import techkids.vn.android7pomodoro.networks.jsonmodels.GetAllTaskBodyJson;

/**
 * Created by PT-LS on 2/21/2017.
 */

public interface GetAllTaskService {
    @GET("task")
    Call<List<GetAllTaskBodyJson>> getAllTask(@Header("Authorization") String jwtToken);
}
