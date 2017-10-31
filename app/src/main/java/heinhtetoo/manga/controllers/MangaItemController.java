package heinhtetoo.manga.controllers;

import android.view.View;

import heinhtetoo.manga.data.vos.MangaVO;

/**
 * Created by Hein Htet Oo on 10/31/2017.
 */

public interface MangaItemController extends BaseController {
    void onClickManga(View view, MangaVO manga);
}
