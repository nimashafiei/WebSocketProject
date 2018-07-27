package nima.test.com.websockettest.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;

import Tools.ListItems;
import Tools.SharePrefrencesManager;
import Tools.WebService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListIntractorLmpl implements ListIntractor {

    public static final String TAG = "ListIntractor";

    private SharedPreferences preferences;

    @Override
    public void getData(Context context, final ListStateListiner listiner) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dbdb2ad2.ngrok.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WebService service = retrofit.create(WebService.class);

        String token = SharePrefrencesManager.getToken(context);

        Call<ArrayList<ListItems>> itemsCall = service.getList(token);

        itemsCall.enqueue(new Callback<ArrayList<ListItems>>() {


            @Override
            public void onResponse(Call<ArrayList<ListItems>> call, Response<ArrayList<ListItems>> response) {
                if(response.body() != null){
                    ArrayList<ListItems> i = response.body();

                    Log.e(TAG, response.body().get(0).getTitle());
                    Log.e(TAG, response.body().get(0).getId() + "");
                    Log.e(TAG, response.body().get(0).getImgUrl());

                    listiner.onSuccess(i);
                }
                else
                    Log.e(TAG, "It's Null");
            }

            @Override
            public void onFailure(Call<ArrayList<ListItems>> call, Throwable t) {
                Log.e(TAG, "Error");
                listiner.onError();
            }
        });
    }

}
