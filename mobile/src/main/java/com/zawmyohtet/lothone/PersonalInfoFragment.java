package com.zawmyohtet.lothone;


import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        return view;
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
