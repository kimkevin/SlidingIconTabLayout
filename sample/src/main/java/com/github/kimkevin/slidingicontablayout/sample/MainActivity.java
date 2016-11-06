package com.github.kimkevin.slidingicontablayout.sample;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.github.kimkevin.slidingicontablayout.wigets.SlidingIconTabLayout;

public class MainActivity extends ActionBarActivity {
  private static final String TAG = MainActivity.class.getSimpleName();

  public enum MENU_TYPE {
    TAB_IMAGE,
    TAB_TEXT
  }

  private ViewPager mViewPager;
  private MainTabAdapter mAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    mAdapter = new MainTabAdapter(this);
    mViewPager = (ViewPager) findViewById(R.id.pager);
    mViewPager.setAdapter(mAdapter);

    initViews(MENU_TYPE.TAB_IMAGE);
  }

  private void initViews(MENU_TYPE type) {
    mAdapter.setMenuType(type);

    SlidingIconTabLayout mSlidingTabLayout = (SlidingIconTabLayout) findViewById(R.id.tabs);
    if (type == MENU_TYPE.TAB_IMAGE) {
      mSlidingTabLayout.setCustomTabView(R.layout.tab_img_layout, R.id.tab_name_img);
    } else if (type == MENU_TYPE.TAB_TEXT) {
      mSlidingTabLayout.setCustomTabView(R.layout.tab_txt_layout, R.id.tab_name_txt);
    }

    mSlidingTabLayout.setCustomTabColorizer(new SlidingIconTabLayout.TabColorizer() {
      @Override
      public int getIndicatorColor(int position) {
        return getResources().getColor(R.color.white);
      }
    });
    mSlidingTabLayout.setViewPager(mViewPager);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    final int id = item.getItemId();

    if (id == R.id.action_tab_img) {
      initViews(MENU_TYPE.TAB_IMAGE);
      return true;
    } else if (id == R.id.action_tab_txt) {
      initViews(MENU_TYPE.TAB_TEXT);
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
