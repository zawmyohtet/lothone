package com.zawmyohtet.lothone;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zawmyohtet.lothone.model.User;
import com.zawmyohtet.lothone.services.LothoneService;
import com.zawmyohtet.lothone.utility.Credential;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends Fragment {

    public static final String TAG = "HomeFragment";

    @BindView(R.id.txv_name)
    TextView txvName;
    @BindView(R.id.txv_emergency_one)
    TextView txvEmergencyOne;
    @BindView(R.id.txv_emergency_two)
    TextView txvEmergencyTwo;
    @BindView(R.id.txv_emergency_three)
    TextView txvEmergencyThree;

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
        showUserInfo();
        return view;
    }

    private void showUserInfo() {
        if (context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE).getBoolean("setup_profile", false)) {
            User user = Credential.getInstance(context).getActiveUser();
            txvName.setText(user.getName());
            txvEmergencyOne.setText(user.getEmergencyNumberOne());
            txvEmergencyTwo.setText(user.getEmergencyNumberTwo());
            txvEmergencyThree.setText(user.getEmergencyNumberThree());
        }
    }

    @OnClick({R.id.btn_info_edit, R.id.btn_police, R.id.btn_fire_brigade, R.id.btn_ambulance, R.id.btn_ministry, R.id.btn_area_code, R.id.btn_zip_code})
    public void handleTap(View v) {
        switch (v.getId()) {
            case R.id.btn_info_edit:
                startActivity(new Intent(context, PersonalInfoActivity.class));
                break;
            case R.id.btn_police:
                Log.d(TAG, "Tap on police.");
                startActivity(new Intent(context, EmergencyContactActivity.class));
                break;
            case R.id.btn_fire_brigade:
                Log.d(TAG, "Tap on fire brigade.");
                context.startService(new Intent(context, LothoneService.class));
                break;
            case R.id.btn_ambulance:
                Log.d(TAG, "Tap on ambulance.");
                Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                if(vibrator.hasVibrator()){
                    vibrator.vibrate(500);
                } else {
                    Log.d(TAG, "No Vibrator");
                }
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
