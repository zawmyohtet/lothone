package com.zawmyohtet.lothone;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.zawmyohtet.lothone.dao.UserStore;
import com.zawmyohtet.lothone.model.User;
import com.zawmyohtet.lothone.utility.Credential;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PersonalInfoActivity extends AppCompatActivity {

    private static final String TAG = "PersonalInfoActivity";

    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.edt_address)
    EditText edtAddress;
    @BindView(R.id.sp_gender)
    Spinner spGender;
    @BindView(R.id.sp_blood_type)
    Spinner spBloodType;
    @BindView(R.id.edt_e_contact_one)
    EditText edtEContactOne;
    @BindView(R.id.edt_e_contact_two)
    EditText edtEContactTwo;
    @BindView(R.id.edt_e_contact_three)
    EditText edtEContactThree;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.btn_update)
    Button btnUpdate;

    private Context context;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_personal_info);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);

        context = this;

        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(context,
                R.array.gender, R.layout.layout_spinner_item);
        spGender.setAdapter(genderAdapter);

        ArrayAdapter<CharSequence> bloodAdapter = ArrayAdapter.createFromResource(context,
                R.array.blood_type, R.layout.layout_spinner_item);
        spBloodType.setAdapter(bloodAdapter);

        showValueIfSetUp();
    }

    private void showValueIfSetUp(){
        SharedPreferences mPref = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        if (mPref.getBoolean("setup_profile", false)) {

            User user = Credential.getInstance(context).getActiveUser();
            edtName.setText(user.getName());
            edtAddress.setText(user.getAddress());

            spGender.setSelection(user.getGender());
            spBloodType.setSelection(user.getBloodType());

            edtEContactOne.setText(user.getEmergencyNumberOne());
            edtEContactTwo.setText(user.getEmergencyNumberTwo());
            edtEContactThree.setText(user.getEmergencyNumberThree());
            btnSubmit.setVisibility(View.GONE);
            btnUpdate.setVisibility(View.VISIBLE);

        } else {

            btnSubmit.setVisibility(View.VISIBLE);
            btnUpdate.setVisibility(View.GONE);

        }
    }

    @OnClick({R.id.btn_submit, R.id.btn_update})
    public void submission(View view) {
        switch (view.getId()) {
            case R.id.btn_submit:
                runValidator();
                break;
            case R.id.btn_update:
                runValidator();
                break;
        }
    }

    private void runValidator() {
        Boolean status = false;

        if (user == null) {
            user = new User();
        }

        if (!edtName.getText().toString().isEmpty()) {
            user.setName(edtName.getText().toString());
            status = true;
        }

        user.setGender(spGender.getSelectedItemPosition());
        user.setBloodType(spBloodType.getSelectedItemPosition());

        if (!edtAddress.getText().toString().isEmpty()) {
            user.setAddress(edtAddress.getText().toString());
            status = true;
        }

        if (!edtEContactOne.getText().toString().isEmpty()) {
            user.setEmergencyNumberOne(edtEContactOne.getText().toString());
            status = true;
        }

        if (!edtEContactTwo.getText().toString().isEmpty()) {
            user.setEmergencyNumberTwo(edtEContactTwo.getText().toString());
            status = true;
        }

        if (!edtEContactThree.getText().toString().isEmpty()) {
            user.setEmergencyNumberThree(edtEContactThree.getText().toString());
            status = true;
        }

        if (status) {
            new UserHandler().execute();
        } else {
            Log.d(TAG, "Need to show error message!");
        }

    }

    private class UserHandler extends AsyncTask<Void, Void, Boolean> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d(TAG, "Hello I am on pre execute!");
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            Log.d(TAG, "Hello I am doing in background!");
            Credential.getInstance(context).reset();
            UserStore userStore = new UserStore(context);
            return userStore.push(user) != -1;
        }

        @Override
        protected void onPostExecute(Boolean success) {
            super.onPostExecute(success);
            Log.d(TAG, "Hello I am on post execute!");
            if (success) {
                getSharedPreferences(getPackageName(), MODE_PRIVATE).edit().putBoolean("setup_profile", true).apply();
                startActivity(new Intent(PersonalInfoActivity.this, HomeActivity.class));
            } else {
                Log.d(TAG, "Storage failed!");
            }
        }
    }
}

















