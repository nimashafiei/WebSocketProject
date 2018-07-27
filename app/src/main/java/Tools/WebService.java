package Tools;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface WebService {
    @POST("/login")
    Call<LoginResponse> getResponse(@QueryMap Map<String, String> params);

    @GET("/list")
    Call<ArrayList<ListItems>> getList(@Query("token") String token);
}
