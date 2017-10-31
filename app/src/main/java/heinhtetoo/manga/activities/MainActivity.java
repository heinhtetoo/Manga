package heinhtetoo.manga.activities;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import heinhtetoo.manga.events.DataEvents;
import heinhtetoo.manga.adapters.MangaListAdapter;
import heinhtetoo.manga.data.model.MangaModel;
import heinhtetoo.manga.data.vos.MangaVO;
import heinhtetoo.manga.R;
import heinhtetoo.manga.controllers.MangaItemController;

public class MainActivity extends AppCompatActivity implements MangaItemController {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    /*@Bind(R.id.tv_title)
    TextView tvToolbar;*/

    @Bind(R.id.rv_manga_list)
    RecyclerView mRecycler;

    public MangaListAdapter mMangaListAdapter;
    public ArrayList<MangaVO> mangaVOs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);
        mangaVOs = new ArrayList<>();

        MangaModel.getObjInstance().loadMangaList();

        setupMangaRecyclerView();

        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
    }

    private void setupMangaRecyclerView() {
        mangaVOs = MangaModel.getObjInstance().getmMangaList();
        mMangaListAdapter = new MangaListAdapter(getApplicationContext(), this);
        mRecycler.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));
        mRecycler.setAdapter(mMangaListAdapter);
        mMangaListAdapter.setNewData(mangaVOs);
    }

    @Override
    public void onClickManga(View view, MangaVO manga) {
        Intent intent = MangaDetailActivity.newIntent(this.getApplicationContext(), manga.getId(), manga.getTitle(), manga.getImage());

        //make shared element transition
        overridePendingTransition(R.anim.pop_enter, R.anim.pop_exit);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat
                .makeSceneTransitionAnimation(this, new Pair(view.findViewById(R.id.iv_image), "manga image animation"));
        ActivityCompat.startActivity(this, intent, activityOptionsCompat.toBundle());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void OnMangaListAdapterDataSetChanged(DataEvents.MangaListAdapterDataSetChangedEvent event) {
        mMangaListAdapter.clearData();
        mMangaListAdapter.setNewData(MangaModel.getObjInstance().getmMangaList());
    }
}
