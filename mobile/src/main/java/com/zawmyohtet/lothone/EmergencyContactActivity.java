package com.zawmyohtet.lothone;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zawmyohtet.lothone.adapter.EmergencyContactAdapter;
import com.zawmyohtet.lothone.model.EmergencyContact;
import com.zawmyohtet.lothone.utility.Divider;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EmergencyContactActivity extends AppCompatActivity {

    private static final String TAG = "EmergencyContactActivity";

    @BindView(R.id.rcv_emergency)
    RecyclerView rcvEmergency;

    private Context context;
    private EmergencyContactAdapter emergencyContactAdapter;
    private List<EmergencyContact> emergencyContactList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_contact);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context = this;
        ButterKnife.bind(this);

        emergencyContactAdapter = new EmergencyContactAdapter(emergencyContactList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        rcvEmergency.setLayoutManager(layoutManager);
        rcvEmergency.setItemAnimator(new DefaultItemAnimator());
        rcvEmergency.addItemDecoration(new Divider(this, LinearLayoutManager.VERTICAL));
        rcvEmergency.setAdapter(emergencyContactAdapter);

        prepareDummy();
    }

    private void prepareDummy(){
        for (int i = 0; i < 10; i++){
            emergencyContactList.add(new EmergencyContact(i, getString(R.string.fake_name), getString(R.string.fake_ph_number), getString(R.string.fake_address), getString(R.string.police_station)));
        }

        emergencyContactAdapter.notifyDataSetChanged();
    }
}
