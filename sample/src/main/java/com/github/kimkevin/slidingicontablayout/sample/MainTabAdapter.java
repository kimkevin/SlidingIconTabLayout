package com.github.kimkevin.slidingicontablayout.sample;

import android.database.DataSetObserver;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.ActionBarActivity;

import com.github.kimkevin.slidingicontablayout.wigets.SlidingIconTabLayout;

public class MainTabAdapter extends FragmentPagerAdapter implements SlidingIconTabLayout.TabIconProvider {
  private static final String TAG = MainTabAdapter.class.getSimpleName();

  private static final int iconRes[] = {
      R.drawable.ic_action_camera,
      R.drawable.ic_action_video
  };

  private static final String iconTxt[] = {
      "Camera",
      "Viedeo"
  };

  private MainActivity.MENU_TYPE menuType;

  public MainTabAdapter(ActionBarActivity activity) {
    super(activity.getSupportFragmentManager());
  }

  @Override
  public void registerDataSetObserver(DataSetObserver observer) {
    super.registerDataSetObserver(observer);
  }

  @Override
  public Fragment getItem(int position) {
    return MainFragment.newInstance(position);
  }

  @Override
  public int getCount() {
    if (menuType == MainActivity.MENU_TYPE.TAB_IMAGE) {
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

  public void setMenuType(MainActivity.MENU_TYPE menuType) {
    this.menuType = menuType;
  }
}

