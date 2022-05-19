package com.example.babydev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.List;

public class activity3 extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    EditText date6, date7, date8, date9, date10, date11;
    RadioButton r6, r7, r8, r9, r10, r11;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);

        date6 = findViewById(R.id.date6);
        date7 = findViewById(R.id.date7);
        date8 = findViewById(R.id.date8);
        date9 = findViewById(R.id.date9);
        date10 = findViewById(R.id.date10);
        date11 = findViewById(R.id.date11);

        r6 = findViewById(R.id.radioButton6);
        r7 = findViewById(R.id.radioButton7);
        r8 = findViewById(R.id.radioButton8);
        r9 = findViewById(R.id.radioButton9);
        r10 = findViewById(R.id.radioButton10);
        r11 = findViewById(R.id.radioButton11);

        btn = findViewById(R.id.button3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Date6 = date6.getText().toString();
                String Date7 = date7.getText().toString();
                String Date8 = date8.getText().toString();
                String Date9 = date9.getText().toString();
                String Date10 = date10.getText().toString();
                String Date11 = date11.getText().toString();

                String s6, s7, s8, s9, s10, s11;
                s6 = s7 = s8 = s9 = s10 = s11 = null;

                if(r6.isChecked()){
                    s6 = r6.getText().toString();
                    saveVaccine(Date6, s6);
                }
                if(r7.isChecked()) {
                    s7 = r7.getText().toString();
                    saveVaccine(Date7, s7);
                }
                if(r8.isChecked()) {
                    s8 = r8.getText().toString();
                    saveVaccine(Date8, s8);
                }
                if(r9.isChecked()) {
                    s9 = r9.getText().toString();
                    saveVaccine(Date9, s9);
                }
                if(r10.isChecked()) {
                    s10 = r10.getText().toString();
                    saveVaccine(Date10, s10);
                }
                if(r11.isChecked()) {
                    s11 = r11.getText().toString();
                    saveVaccine(Date11, s11);
                }

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("DATE6", Date6);
                editor.putString("DATE7", Date7);
                editor.putString("DATE8", Date8);
                editor.putString("DATE9", Date9);
                editor.putString("DATE10", Date10);
                editor.putString("DATE11", Date11);

                editor.putString("VAC6", s6);
                editor.putString("VAC7", s7);
                editor.putString("VAC8", s8);
                editor.putString("VAC9", s9);
                editor.putString("VAC10", s10);
                editor.putString("VAC11", s11);

                editor.clear();
                editor.apply();

                Intent i = new Intent(activity3.this, activity4.class);
                startActivity(i);
                finish();

            }
        });


    }

    private void saveVaccine(String date, String vaccine){
        babyDB db = babyDB.getDbInstance(this.getApplicationContext());
        vaccineData Vaccine = new vaccineData();
        Vaccine.vaccine = vaccine;
        Vaccine.DOV = date;

        List<userData> userList = db.USERDAO().getUser();
        String dateOfBirth = userList.get(0).DOB;

        Vaccine.age = ageDifferent(dateOfBirth, date);


        finish();
    }

    public int ageDifferent(String date1, String date2) {
        // 21/05/2022
        String[] subStrings1 = date1.split("/", 3);
        String[] subStrings2 = date2.split("/", 3);

        int yearsDiff = Integer.parseInt(subStrings2[2]) - Integer.parseInt(subStrings1[2]);
        int monthDiff = Integer.parseInt(subStrings2[1]) - Integer.parseInt(subStrings1[1]);

        return Math.abs(yearsDiff * 12 + monthDiff);
    }

}