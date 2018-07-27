package nima.test.com.websockettest.Login;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import Tools.LoginResponse;
import Tools.SharePrefrencesManager;
import Tools.WebService;
import nima.test.com.websockettest.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginIntractorLmpl implements LoginIntractor {

    private final static String TAG = "LoginIntractor";

    @Override
    public void validate(final Context context, String username, String password, final LoginStateListiner stateListiner) {
        Map<String, String> param = new HashMap<>();
        param.put("username", username);
        param.put("password", password);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(context.getResources().getString(R.string.baseURL))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WebService service = retrofit.create(WebService.class);

        Call<LoginResponse> call = service.getResponse(param);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if(response.body() == null) {
                    stateListiner.onNetworkError();
                    return;
                }

                if(response.body().getMessage() != null) {
                    String res = response.body().getMessage();
                    String data = response.body().getData().getToken();

                    Log.e("response", data);

                    if(res.equals("invalid_credentials"))
                        stateListiner.onUsernameError();
                    else {
                        SharePrefrencesManager.setToken(context, data);
                        stateListiner.onSuccess();

                    }
                }
                else
                    Log.e(TAG, "Can't parse Json");

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                stateListiner.onNetworkError();
            }
        });
    }
}
