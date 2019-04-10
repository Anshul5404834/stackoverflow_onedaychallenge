package com.anshul5404834.stackoverflow_app;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class offline_question extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_question);
        ListView l=(ListView)findViewById(R.id.listview);
        Toast.makeText(getApplicationContext(),"You are Currently offline",Toast.LENGTH_SHORT).show();
        Database db;
        db= Room.databaseBuilder(l.getContext(),Database.class,"stackoverflow_databse").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        List<question_identity> question_identities= db.stack_overflow().getAll();
        l.setAdapter(new room_adapter(l.getContext(),question_identities));

    }
}
