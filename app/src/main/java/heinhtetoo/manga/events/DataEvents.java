package heinhtetoo.manga.events;

import java.util.ArrayList;

import heinhtetoo.manga.data.vos.MangaDetailVO;
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
        private MangaDetailVO mangaDetailVO;

        public MangaDetailLoadedEvent(MangaDetailVO mangaDetailVO) {
            this.mangaDetailVO = mangaDetailVO;
        }

        public MangaDetailVO getMangaDetailVO() {
            return mangaDetailVO;
        }
    }

    public static class MangaListAdapterDataSetChangedEvent {

    }

    public static class MangaDetailDataChangedEvent {

    }
}
