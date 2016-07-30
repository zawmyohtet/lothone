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

    @OnClick({R.id.btn_police, R.id.btn_fire_brigade, R.id.btn_ambulance, R.id.btn_ministry, R.id.btn_area_code, R.id.btn_zip_code})
    public void handleTap(View v) {
        switch (v.getId()) {
            case R.id.btn_police:
                Log.d(TAG, "Tap on police.");
                break;
            case R.id.btn_fire_brigade:
                Log.d(TAG, "Tap on fire brigade.");
                break;
            case R.id.btn_ambulance:
                Log.d(TAG, "Tap on ambulance.");
                break;
            case R.id.btn_area_code:
                Log.d(TAG, "Tap on area code.");
                break;
            case R.id.btn_zip_code:
                Log.d(TAG, "Tap on zip code.");
                break;
            case R.id.btn_ministry:
                Log.d(TAG, "Tap on ministry.");
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
