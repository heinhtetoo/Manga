package heinhtetoo.manga;

import android.util.Log;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hein Htet Oo on 10/30/2017.
 */

public class RetrofitDataAgent implements MangaDataAgent {

    private static RetrofitDataAgent objInstance;

    private static String BASE_API_URL = "https://www.mangaeden.com/api/";

    private final API api;

    private RetrofitDataAgent() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();

        api = retrofit.create(API.class);
    }

    public static RetrofitDataAgent getObjInstance() {
        if (objInstance == null) {
            objInstance = new RetrofitDataAgent();
        }
        return objInstance;
    }

    @Override
    public void loadMangaList() {

        Call<MangaListResponse> loadMangaListCall = api.loadMangaList();
        loadMangaListCall.enqueue(new Callback<MangaListResponse>() {
            @Override
            public void onResponse(Call<MangaListResponse> call, Response<MangaListResponse> response) {
                MangaListResponse mangaListResponse = response.body();
                Log.d("Manga List Response", response.message());
                if (mangaListResponse != null) {
                    EventBus.getDefault().post(new DataEvents.MangaListLoadedEvent(mangaListResponse.getMangaList()));
                } {

                }
            }

            @Override
            public void onFailure(Call<MangaListResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadMangaDetail(String id) {

    }
}
