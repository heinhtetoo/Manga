package heinhtetoo.manga;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Hein Htet Oo on 10/31/2017.
 */

public class MangaDetailVO {

    @SerializedName("aka")
    public List<String> aka = null;

    @SerializedName("aka-alias")
    public List<String> akaAlias = null;

    @SerializedName("alias")
    public String alias;

    @SerializedName("artist")
    public String artist;

    @SerializedName("artist_kw")
    public List<String> artistKw = null;

    @SerializedName("author")
    public String author;

    @SerializedName("author_kw")
    public List<String> authorKw = null;

    @SerializedName("autoManga")
    public Boolean autoManga;

    @SerializedName("baka")
    public Boolean baka;

    @SerializedName("categories")
    public List<String> categories = null;

    @SerializedName("chapters")
    public List<List<Integer>> chapters = null;

    @SerializedName("chapters_len")
    public Integer chaptersLen;

    @SerializedName("created")
    public Float created;

    @SerializedName("description")
    public String description;

    @SerializedName("hits")
    public Integer hits;

    @SerializedName("image")
    public String image;

    @SerializedName("imageURL")
    public String imageURL;

    @SerializedName("language")
    public Integer language;

    @SerializedName("last_chapter_date")
    public Float lastChapterDate;

    @SerializedName("released")
    public Integer released;

    @SerializedName("startsWith")
    public String startsWith;

    @SerializedName("status")
    public Integer status;

    @SerializedName("title")
    public String title;

    @SerializedName("title_kw")
    public List<String> titleKw = null;

    @SerializedName("type")
    public Integer type;

    @SerializedName("updatedKeywords")
    public Boolean updatedKeywords;

    @SerializedName("url")
    public String url;

    public List<String> getAka() {
        return aka;
    }

    public List<String> getAkaAlias() {
        return akaAlias;
    }

    public String getAlias() {
        return alias;
    }

    public String getArtist() {
        return artist;
    }

    public List<String> getArtistKw() {
        return artistKw;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getAuthorKw() {
        return authorKw;
    }

    public Boolean getAutoManga() {
        return autoManga;
    }

    public Boolean getBaka() {
        return baka;
    }

    public List<String> getCategories() {
        return categories;
    }

    public List<List<Integer>> getChapters() {
        return chapters;
    }

    public Integer getChaptersLen() {
        return chaptersLen;
    }

    public Float getCreated() {
        return created;
    }

    public String getDescription() {
        return description;
    }

    public Integer getHits() {
        return hits;
    }

    public String getImage() {
        return image;
    }

    public String getImageURL() {
        return imageURL;
    }

    public Integer getLanguage() {
        return language;
    }

    public Float getLastChapterDate() {
        return lastChapterDate;
    }

    public Integer getReleased() {
        return released;
    }

    public String getStartsWith() {
        return startsWith;
    }

    public Integer getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getTitleKw() {
        return titleKw;
    }

    public Integer getType() {
        return type;
    }

    public Boolean getUpdatedKeywords() {
        return updatedKeywords;
    }

    public String getUrl() {
        return url;
    }
}
