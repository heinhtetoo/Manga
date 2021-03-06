package heinhtetoo.manga.data.restapi;

import heinhtetoo.manga.data.vos.MangaDetailVO;
import heinhtetoo.manga.data.restapi.response.MangaListResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Hein Htet Oo on 10/30/2017.
 */

public interface API {

    @GET("list/0/?p=0&l=50")
    Call<MangaListResponse> loadMangaList();

    @GET("manga/5372389645b9ef5a0b1d20d8/")
    Call<MangaDetailVO> loadMangaDetail();
}
