package com.example.babydev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText guardianName, babyName, dob, gender, birthWeight, birthHeight;
    Button btn;
    SharedPreferences sharedPreferences;
    CheckBox remember;
    boolean isRemembered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guardianName = findViewById(R.id.GName);
        babyName = findViewById(R.id.BName);
        dob = findViewById(R.id.dob);
        gender = findViewById(R.id.gender);
        birthWeight = findViewById(R.id.Bweight);
        birthHeight = findViewById(R.id.Bheight);
        remember = findViewById(R.id.checkBox);



        btn = findViewById(R.id.login);

        sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);

        isRemembered = sharedPreferences.getBoolean("CHECKBOX", false);


        if(isRemembered){
            Intent i = new Intent(MainActivity.this, activity2.class);
            startActivity(i);
            finish();

        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String GName = guardianName.getText().toString();
                String BName = babyName.getText().toString();
                String DOB = dob.getText().toString();
                String Gender = gender.getText().toString();
                float BirthWeight = Float.parseFloat(birthWeight.getText().toString().trim());
                float BirthHeight = Float.parseFloat(birthHeight.getText().toString().trim());
                boolean checked = remember.isChecked();

                saveUser(GName, BName, DOB, Gender, BirthWeight, BirthHeight);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("GUARDIAN NAME", GName);
                editor.putString("BABY NAME", BName);
                editor.putString("DOB", DOB);
                editor.putString("GENDER", Gender);
                editor.putFloat("BIRTH WEIGHT", BirthWeight);
                editor.putFloat("BIRTH HEIGHT", BirthHeight);
                editor.putBoolean("CHECKBOX", checked);
                editor.apply();

                Intent i = new Intent(MainActivity.this, activity2.class);
                startActivity(i);
                finish();

            }
        });
    }

    private void saveUser(String Gname, String Bname, String dob, String gender, float Bweight, float Bheight){
        babyDB db = babyDB.getDbInstance(this.getApplicationContext());
        userData user = new userData();
        user.Gname = Gname;
        user.Bname = Bname;
        user.DOB = dob;
        user.gender = gender;
        user.Bweight = Bweight;
        user.Bheight = Bheight;

        db.USERDAO().InsertUser(user);
        finish();
    }

}