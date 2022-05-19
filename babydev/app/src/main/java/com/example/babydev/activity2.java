package com.example.babydev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

public class activity2 extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    Button btn;
    TextView t;
    EditText date1, date2, date3, date4, date5;
    RadioButton r1, r2, r3, r4, r5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);

        date1 = findViewById(R.id.date1);
        date2 = findViewById(R.id.date2);
        date3 = findViewById(R.id.date3);
        date4 = findViewById(R.id.date4);
        date5 = findViewById(R.id.date5);

        r1 = findViewById(R.id.radioButton1);
        r2 = findViewById(R.id.radioButton2);
        r3 = findViewById(R.id.radioButton3);
        r4 = findViewById(R.id.radioButton4);
        r5 = findViewById(R.id.radioButton5);


        btn = findViewById(R.id.button2);
        t = findViewById(R.id.textView3);
        String s = "Hi " + sharedPreferences.getString("GUARDIAN NAME", "Guardian") + " Enter Your Baby's Vaccination Details!!";
        t.setText(s);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Date1 = date1.getText().toString();
                String Date2 = date2.getText().toString();
                String Date3 = date3.getText().toString();
                String Date4 = date4.getText().toString();
                String Date5 = date5.getText().toString();

                String s1, s2, s3, s4, s5;
                s1 = s2 = s3 = s4 = s5 = null;

                if(r1.isChecked()) {
                    s1 = r1.getText().toString();
                    saveVaccine(Date1, s1);
                }
                if(r2.isChecked()) {
                    s2 = r2.getText().toString();
                    saveVaccine(Date2, s2);
                }
                if(r3.isChecked()) {
                    s3 = r3.getText().toString();
                    saveVaccine(Date3, s3);
                }
                if(r4.isChecked()){
                    s4 = r4.getText().toString();
                    saveVaccine(Date4, s4);
                }
                if(r5.isChecked()){
                    s5 = r5.getText().toString();
                    saveVaccine(Date5, s5);
                }


                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("DATE1", Date1);
                editor.putString("DATE2", Date2);
                editor.putString("DATE3", Date3);
                editor.putString("DATE4", Date4);
                editor.putString("DATE5", Date5);

                editor.putString("VAC1", s1);
                editor.putString("VAC2", s2);
                editor.putString("VAC3", s3);
                editor.putString("VAC4", s4);
                editor.putString("VAC5", s5);

                editor.clear();
                editor.apply();

                Intent i = new Intent(activity2.this, activity3.class);
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