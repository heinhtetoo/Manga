package heinhtetoo.manga.views.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.Bind;
import heinhtetoo.manga.R;
import heinhtetoo.manga.controllers.MangaItemController;
import heinhtetoo.manga.data.vos.MangaVO;

/**
 * Created by Hein Htet Oo on 10/29/2017.
 */

public class MangaVH extends BaseViewHolder<MangaVO> {

    @Bind(R.id.iv_image)
    ImageView ivImage;

    @Bind(R.id.tv_title)
    TextView tvTitle;

    private MangaVO mMangaVO;
    private MangaItemController mMangaItemController;

    public MangaVH(View itemView, MangaItemController mMangaItemController) {
        super(itemView);
        this.mMangaItemController = mMangaItemController;
    }

    @Override
    public void bind(MangaVO data) {
        mMangaVO = data;
        Glide.with(ivImage.getContext())
                .load(mMangaVO.getImage())
                .placeholder(R.drawable.manga_image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(ivImage);
        tvTitle.setText(mMangaVO.getTitle());
    }

    @Override
    public void onClick(View view) {
        mMangaItemController.onClickManga(view, mMangaVO);
    }
}
