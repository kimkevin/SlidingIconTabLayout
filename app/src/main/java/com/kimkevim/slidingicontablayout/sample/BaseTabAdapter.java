package com.kimkevim.slidingicontablayout.sample;

import android.database.DataSetObserver;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.ActionBarActivity;
import com.kimkevim.slidingicontablayout.R;
import com.kimkevim.slidingicontablayout.widgets.SlidingTabLayout;

public class BaseTabAdapter extends FragmentPagerAdapter implements SlidingTabLayout.TabIconProvider {
    private static final String TAG = BaseTabAdapter.class.getSimpleName();

    private static final int iconRes[] = {
            R.drawable.ic_action_camera,
            R.drawable.ic_action_video
    };

    private static final String iconTxt[] = {
            "Camera",
            "Viedeo"
    };

    private BaseActivity.MENU_TYPE menuType;

    public BaseTabAdapter(ActionBarActivity activity) {
        super(activity.getSupportFragmentManager());
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        super.registerDataSetObserver(observer);
    }

    @Override
    public Fragment getItem(int position) {
        return BaseFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        if (menuType == BaseActivity.MENU_TYPE.TAB_IMAGE) {
            return iconRes.length;
        } else {
            return iconTxt.length;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return iconTxt[position];
    }

    @Override
    public int getPageIconResId(int position) {
        return iconRes[position];
    }

    public void setMenuType(BaseActivity.MENU_TYPE menuType) {
        this.menuType = menuType;
    }
}

