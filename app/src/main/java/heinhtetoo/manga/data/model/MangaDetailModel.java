package heinhtetoo.manga.data.model;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import heinhtetoo.manga.data.restapi.MangaDataAgent;
import heinhtetoo.manga.data.restapi.RetrofitDataAgent;
import heinhtetoo.manga.data.vos.MangaDetailVO;
import heinhtetoo.manga.events.DataEvents;

/**
 * Created by Hein Htet Oo on 11/1/2017.
 */

public class MangaDetailModel {

    private static MangaDetailModel objInstance;
    protected MangaDataAgent mMangaAgent;

    private static MangaDetailVO mangaDetailVO;

    private MangaDetailModel() {
        mMangaAgent = RetrofitDataAgent.getObjInstance();
        mangaDetailVO = new MangaDetailVO();

        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
    }

    public static MangaDetailModel getObjInstance() {
        if (objInstance == null) {
            objInstance = new MangaDetailModel();
        }
        return objInstance;
    }

    public void loadMangaDetail(String id) {
        mMangaAgent.loadMangaDetail(id);
    }

    public MangaDetailVO getMangaDetail() {
        return mangaDetailVO;
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void OnMangaDetailLoaded(DataEvents.MangaDetailLoadedEvent event) {
        mangaDetailVO = event.getMangaDetailVO();
        EventBus.getDefault().post(new DataEvents.MangaDetailDataChangedEvent());
    }
}
