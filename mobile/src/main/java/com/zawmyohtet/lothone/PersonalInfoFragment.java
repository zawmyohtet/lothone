package com.zawmyohtet.lothone;


import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zawmyohtet.lothone.model.User;
import com.zawmyohtet.lothone.utility.Credential;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class PersonalInfoFragment extends Fragment {

    public static final String TAG = "PersonalInfoFragment";

    @BindView(R.id.txv_name)
    TextView txvName;
    @BindView(R.id.txv_blood_type)
    TextView txvBloodType;
    @BindView(R.id.txv_gender)
    TextView txvGender;
    @BindView(R.id.txv_address)
    TextView txvAddress;
    @BindView(R.id.txv_emergency_one)
    TextView txvEmergencyOne;
    @BindView(R.id.txv_emergency_two)
    TextView txvEmergencyTwo;
    @BindView(R.id.txv_emergency_three)
    TextView txvEmergencyThree;

    private Context context;

    public PersonalInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_personal_info, container, false);
        ButterKnife.bind(this, view);
        context = getActivity();
        showUserInfo();
        return view;
    }

    private void showUserInfo() {
        if (context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE).getBoolean("setup_profile", false)) {
            User user = Credential.getInstance(context).getActiveUser();
            txvName.setText(user.getName());
            txvGender.setText(user.getGender());
            txvBloodType.setText(user.getBloodType());
            txvAddress.setText(user.getAddress());
            txvEmergencyOne.setText(user.getEmergencyNumberOne());
            txvEmergencyTwo.setText(user.getEmergencyNumberTwo());
            txvEmergencyThree.setText(user.getEmergencyNumberThree());
        }
    }

    @OnClick(R.id.btn_info_edit)
    public void edit(View view){
        switch (view.getId()){
            case R.id.btn_info_edit:
                startActivity(new Intent(context, PersonalInfoActivity.class));
                break;
        }
    }

}
