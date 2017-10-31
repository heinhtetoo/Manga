package heinhtetoo.manga.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import heinhtetoo.manga.views.viewholders.MangaVH;
import heinhtetoo.manga.data.vos.MangaVO;
import heinhtetoo.manga.R;
import heinhtetoo.manga.controllers.MangaItemController;

/**
 * Created by Hein Htet Oo on 10/29/2017.
 */

public class MangaListAdapter extends BaseRecyclerAdapter<MangaVH, MangaVO> {

    private MangaItemController mMangaItemController;

    public MangaListAdapter(Context context, MangaItemController mMangaItemController) {
        super(context);
        this.mMangaItemController = mMangaItemController;
    }

    @Override
    public MangaVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_manga, parent, false);
        return new MangaVH(view, mMangaItemController);
    }

    @Override
    public void onBindViewHolder(MangaVH holder, int position) {
        holder.bind(mData.get(position));
    }
}
