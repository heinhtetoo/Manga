package heinhtetoo.manga.data.restapi;

/**
 * Created by Hein Htet Oo on 10/30/2017.
 */

public interface MangaDataAgent {
    void loadMangaList();

    void loadMangaDetail(String id);
}
