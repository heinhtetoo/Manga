package heinhtetoo.manga;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

/**
 * Created by Hein Htet Oo on 10/30/2017.
 */

public class MangaModel {

    private static MangaModel objInstance;
    protected MangaDataAgent mMangaAgent;

    private static ArrayList<MangaVO> mMangaList;

    private MangaModel() {
        mMangaAgent = RetrofitDataAgent.getObjInstance();
        mMangaList = new ArrayList<>();

        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
    }

    public static MangaModel getObjInstance() {
        if (objInstance == null) {
            objInstance = new MangaModel();
        }
        return objInstance;
    }

    public void loadMangaList() {
        mMangaAgent.loadMangaList();
    }

    protected ArrayList<MangaVO> getmMangaList() {
        return mMangaList;
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void OnMangaListLoaded(DataEvents.MangaListLoadedEvent event) {
        mMangaList = event.getMangaVOList();
        EventBus.getDefault().post(new DataEvents.MangaListAdapterDataSetChangedEvent());
    }
}
