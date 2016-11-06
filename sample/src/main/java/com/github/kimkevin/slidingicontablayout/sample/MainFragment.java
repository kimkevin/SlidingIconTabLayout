package com.github.kimkevin.slidingicontablayout.sample;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainFragment extends Fragment {
  private static final String ARG_POSITION = "position";

  public static MainFragment newInstance(int position) {
    MainFragment fragment = new MainFragment();
    Bundle args = new Bundle();
    args.putInt(ARG_POSITION, position);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    int position = getArguments().getInt(ARG_POSITION);

    View view = inflater.inflate(R.layout.fragment_main, null);
    TextView posTxt = (TextView) view.findViewById(R.id.pos_txt);
    posTxt.setText("Framgent " + position);
    return view;
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }
}
