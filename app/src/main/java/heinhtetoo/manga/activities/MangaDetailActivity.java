package heinhtetoo.manga.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import heinhtetoo.manga.data.model.MangaDetailModel;
import heinhtetoo.manga.data.vos.MangaDetailVO;
import heinhtetoo.manga.R;
import heinhtetoo.manga.events.DataEvents;

public class MangaDetailActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.iv_manga_cover)
    ImageView ivCover;

    @Bind(R.id.tv_title)
    TextView tvTitle;

    @Bind(R.id.tv_author)
    TextView tvAuthor;

    @Bind(R.id.tv_categories)
    TextView tvCategories;

    @Bind(R.id.tv_description)
    TextView tvDescription;

    private MangaDetailVO mangaDetailVO;

    public static Intent newIntent(Context context, String id, String title, String image) {
        Intent intent = new Intent(context, MangaDetailActivity.class);
        intent.putExtra("mangaId", id);
        intent.putExtra("mangaTitle", title);
        intent.putExtra("mangaImage", image);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manga_detail);
        ButterKnife.bind(this, this);

        String mangaId = getIntent().getStringExtra("mangaId");
        String mangaTitle = getIntent().getStringExtra("mangaTitle");
        String mangaImage = getIntent().getStringExtra("mangaImage");


        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(mangaTitle);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Glide.with(ivCover.getContext())
                .load(mangaImage)
                .placeholder(R.drawable.manga_image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(ivCover);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ivCover.setTransitionName("manga image animation");
        }

        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }

        MangaDetailModel.getObjInstance().loadMangaDetail(mangaId);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void bindData() {

        String title = "unavailable";
        String author = "unavailable";
        String categoriesStr = "";
        String description = "unavailable";
        if (mangaDetailVO.getCategories().size() > 0) {
            List<String> categoriesArray = mangaDetailVO.getCategories();
            for (int i=0; i<categoriesArray.size(); i++) {
                categoriesStr += categoriesArray.get(i) + ", ";
            }
            categoriesStr = categoriesStr.trim();
            categoriesStr = categoriesStr.substring(0, categoriesStr.length()-1);
        } else {
            categoriesStr = "unavailable";
        }

        if (mangaDetailVO.getTitle() != null && !mangaDetailVO.getTitle().isEmpty()) {
            title = mangaDetailVO.getTitle();
        }

        if (mangaDetailVO.getAuthor() != null && !mangaDetailVO.getAuthor().isEmpty()) {
            author = mangaDetailVO.getAuthor();
        }

        if (mangaDetailVO.getDescription() != null && !mangaDetailVO.getDescription().isEmpty()) {
            description = mangaDetailVO.getDescription();
        }

        tvTitle.setText(title);
        tvAuthor.setText(author);
        tvCategories.setText(categoriesStr);
        tvDescription.setText(description);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void OnMangaDetailDataChanged(DataEvents.MangaDetailDataChangedEvent event) {
        mangaDetailVO = MangaDetailModel.getObjInstance().getMangaDetail();
        Log.e("get", mangaDetailVO.getTitle());
        bindData();
    }
}
