package com.zawmyohtet.lothone;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    @BindView(R.id.btn_edit)
    Button btnEdit;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        ButterKnife.bind(this);
        context = this;

        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(context,
                    R.array.gender, R.layout.layout_spinner_item);
        spGender.setAdapter(genderAdapter);

        ArrayAdapter<CharSequence> bloodAdapter = ArrayAdapter.createFromResource(context,
                R.array.blood_type, R.layout.layout_spinner_item);
        spBloodType.setAdapter(bloodAdapter);


    }
}
