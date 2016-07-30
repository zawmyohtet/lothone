package com.zawmyohtet.lothone;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends Fragment {

    public static final String TAG = "HomeFragment";

    private Context context;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        context = getActivity();
        return view;
    }

    @OnClick({R.id.cv_police, R.id.cv_fire_brigade, R.id.cv_ambulance, R.id.cv_ministry, R.id.cv_area, R.id.cv_zip})
    public void handleClick(View v) {
        switch (v.getId()) {
            case R.id.cv_police:
                context.startActivity(new Intent(context, PersonalInfoActivity.class));
                break;
            case R.id.cv_fire_brigade:
                Log.d(TAG, "It is on click.");
                break;
            case R.id.cv_ambulance:
                break;
            case R.id.cv_ministry:
                break;
            case R.id.cv_area:
                break;
            case R.id.cv_zip:
                break;
        }
    }

    public void onButtonPressed(Uri uri) {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
