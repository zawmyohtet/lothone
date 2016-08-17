package com.zawmyohtet.lothone;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.zawmyohtet.lothone.action.EmergencyContactListInterface;
import com.zawmyohtet.lothone.adapter.EmergencyContactAdapter;
import com.zawmyohtet.lothone.dao.EmergencyContactStore;
import com.zawmyohtet.lothone.model.EmergencyContact;
import com.zawmyohtet.lothone.utility.Caller;
import com.zawmyohtet.lothone.utility.Divider;
import com.zawmyohtet.lothone.utility.Helper;
import com.zawmyohtet.lothone.utility.ProgressDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EmergencyContactActivity extends AppCompatActivity implements EmergencyContactListInterface {

    private static final String TAG = "ECActivity";
    public static final String FILTER = "filter";

    @BindView(R.id.rcv_emergency)
    RecyclerView rcvEmergency;

    private Context context;
    private EmergencyContactAdapter emergencyContactAdapter;
    private List<EmergencyContact> emergencyContactList = new ArrayList<>();
    private String filter = "Police";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_contact);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        if (intent != null) {
            filter = intent.getStringExtra(FILTER);
        }

        context = this;
        ButterKnife.bind(this);

        emergencyContactAdapter = new EmergencyContactAdapter(emergencyContactList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        rcvEmergency.setLayoutManager(layoutManager);
        rcvEmergency.setItemAnimator(new DefaultItemAnimator());
        rcvEmergency.addItemDecoration(new Divider(this, LinearLayoutManager.VERTICAL));
        rcvEmergency.setAdapter(emergencyContactAdapter);

        new DataLoader().execute();
    }

    private List<EmergencyContact> prepareDummy() {

        for (int i = 0; i < 200; i++) {
            emergencyContactList.add(new EmergencyContact(i, getString(R.string.fake_name), getString(R.string.fake_address), "South Okkalapa", "Yangon", getString(R.string.fake_ph_number), "OOO", "0000", getString(R.string.police_station)));
        }

        return emergencyContactList;
    }

    private class DataLoader extends AsyncTask<Void, Void, Boolean> {

        ProgressDialog progressDialog = new ProgressDialog();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show(context);
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            return prepareDummy().size() > 0;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            if (aBoolean) {
                emergencyContactAdapter.notifyDataSetChanged();
            }

            progressDialog.dismiss();
        }
    }

    @Override
    public void onCall(String number) {
        new Caller().make(context, number);
    }
}


























