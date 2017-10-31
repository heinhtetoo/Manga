package heinhtetoo.manga.events;

import java.util.ArrayList;

import heinhtetoo.manga.data.vos.MangaVO;

/**
 * Created by Hein Htet Oo on 10/30/2017.
 */

public class DataEvents {

    public static class MangaListLoadedEvent {
        private ArrayList<MangaVO> mangaVOList;

        public MangaListLoadedEvent(ArrayList<MangaVO> mangaVOs) {
            this.mangaVOList = mangaVOs;
        }

        public ArrayList<MangaVO> getMangaVOList() {
            return mangaVOList;
        }
    }

    public static class MangaDetailLoadedEvent {

    }

    public static class MangaListAdapterDataSetChangedEvent {

    }
}
