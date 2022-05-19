package com.example.babydev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activity4 extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    EditText weight, height;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);

        weight = findViewById(R.id.Cweight);
        height = findViewById(R.id.Cheight);
        btn = findViewById(R.id.submit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float Weight = Float.parseFloat(weight.getText().toString().trim());
                float Height = Float.parseFloat(height.getText().toString().trim());

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putFloat("WEIGHT", Weight);
                editor.putFloat("HEIGHT", Height);

                editor.clear();
                editor.apply();

                Intent i = new Intent(activity4.this, viewdata.class);
                startActivity(i);
                finish();
            }
        });



    }
}