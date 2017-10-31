package heinhtetoo.manga;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

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

    public static Intent newIntent(Context context, String id, String title) {
        Intent intent = new Intent(context, MangaDetailActivity.class);
        intent.putExtra("mangaId", id);
        intent.putExtra("mangaTitle", title);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manga_detail);
        ButterKnife.bind(this, this);

        String mangaId = getIntent().getStringExtra("mangaId");
        String mangaTitle = getIntent().getStringExtra("mangaTitle");

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(mangaTitle);
    }

    /*private void bindData() {

        String categoriesStr = "";
        String[] categoriesArray = mangaDetailVO.getCategories();
        for (int i=0; i<categoriesArray.length; i++) {
            categoriesStr += categoriesArray[i] + ",";
            categoriesStr = categoriesStr.substring(0, categoriesStr.length()-1);
        }

        Glide.with(ivCover.getContext())
                .load(mangaDetailVO.getImageURL())
                .placeholder(R.drawable.manga_image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(ivCover);
        tvTitle.setText(mangaDetailVO.getTitle());
        tvAuthor.setText(mangaDetailVO.getAuthor());
        tvCategories.setText(categoriesStr);
        tvDescription.setText(mangaDetailVO.getDescription());
    }*/
}
