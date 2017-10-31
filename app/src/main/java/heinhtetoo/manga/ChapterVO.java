package heinhtetoo.manga;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hein Htet Oo on 10/31/2017.
 */

public class ChapterVO {

    @SerializedName("total_chapter")
    private Integer total;

    @SerializedName("date_chapter")
    private double date;

    @SerializedName("title_chapter")
    private String title;

    @SerializedName("id_chapter")
    private String id;

    public Integer getTotal() {
        return total;
    }

    public double getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }
}
