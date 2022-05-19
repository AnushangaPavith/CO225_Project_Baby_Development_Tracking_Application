package com.example.babydev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;

import java.util.List;

public class viewdata extends AppCompatActivity {
    private userAdapter useradapter;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdata);
        initRecyclerView();
        loadUser();

        btn = findViewById(R.id.infoButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadUser();
            }
        });

    }

    private void loadUser(){
        babyDB db = babyDB.getDbInstance(this.getApplicationContext());
        List <userData> user = db.USERDAO().getUser();
        useradapter.setUserList(user);

    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        useradapter = new userAdapter(this);
        recyclerView.setAdapter(useradapter);
    }
}