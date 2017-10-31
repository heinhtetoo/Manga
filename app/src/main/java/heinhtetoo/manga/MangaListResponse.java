package heinhtetoo.manga;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Hein Htet Oo on 10/30/2017.
 */

public class MangaListResponse {

    @SerializedName("end")
    private int end;

    @SerializedName("manga")
    private ArrayList<MangaVO> mangaList;

    @SerializedName("page")
    private int page;

    @SerializedName("start")
    private int start;

    @SerializedName("total")
    private int total;

    public int getEnd() {
        return end;
    }

    public ArrayList<MangaVO> getMangaList() {
        return mangaList;
    }

    public int getPage() {
        return page;
    }

    public int getStart() {
        return start;
    }

    public int getTotal() {
        return total;
    }
}
