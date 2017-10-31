package heinhtetoo.manga;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hein Htet Oo on 10/29/2017.
 */

public class MangaVO {

    @SerializedName("a")
    private String alias;

    @SerializedName("c")
    private String[] category;

    @SerializedName("h")
    private Integer hits;

    @SerializedName("i")
    private String id;

    @SerializedName("im")
    private String image;

    @SerializedName("ld")
    private Float last_chapter_date;

    @SerializedName("s")
    private Integer status;

    @SerializedName("t")
    private String title;

    public String getAlias() {
        return alias;
    }

    public String[] getCategory() {
        return category;
    }

    public Integer getHits() {
        return hits;
    }

    public String getId() {
        return id;
    }

    public String getImage() {
        return "https://cdn.mangaeden.com/mangasimg/" + image;
    }

    public Float getLast_chapter_date() {
        return last_chapter_date;
    }

    public Integer getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }
}
