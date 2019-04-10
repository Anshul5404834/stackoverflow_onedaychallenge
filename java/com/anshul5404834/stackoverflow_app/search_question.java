package com.anshul5404834.stackoverflow_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class search_question extends AppCompatActivity {
    String tag1,tag2,tag3,tag4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_question);
        ListView l =(ListView)findViewById(R.id.listview);
        find_question a = new find_question(l);
        Bundle b = getIntent().getBundleExtra("extras");
       tag1= b.getString("taga");
        tag2= b.getString("tagb"); tag3= b.getString("tagc"); tag4= b.getString("tagd");

        //"https://api.stackexchange.com/2.2/questions?order=desc&sort=activity&tagged=java%20%3B%20kotlin&site=stackoverflow"
        //"https://api.stackexchange.com/2.2/questions?order=desc&sort=activity&tagged="+tag1+";"+tag2+";"+tag3+";"+tag4+";"+"&site=stackoverflow"
  a.execute("https://api.stackexchange.com/2.2/questions?order=desc&sort=activity&tagged="+tag1+";"+tag2+";"+tag3+";"+tag4+";"+"&site=stackoverflow");
    }

}
