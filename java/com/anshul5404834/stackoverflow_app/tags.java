package com.anshul5404834.stackoverflow_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class tags extends AppCompatActivity {
    String tag1,tag2,tag3,tag4;
    public void find_question(String a,String b,String c,String d){
        tag1=a;
        tag2=b;
        tag3=c;
        tag4=d;

    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        Toast.makeText(getApplicationContext(),"Enter Relevant Tags for Result",Toast.LENGTH_SHORT).show();
        final EditText editText=(EditText)findViewById(R.id.taga);
        final EditText editText2=(EditText)findViewById(R.id.tagb);
        final EditText editText3=(EditText)findViewById(R.id.tagc);
        final EditText editText4=(EditText)findViewById(R.id.tagd);

        Button submit =findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i =new Intent(getApplicationContext(),search_question.class);
                tag1= editText.getText().toString();
                tag2= editText2.getText().toString();
                tag3= editText3.getText().toString();
                tag4= editText4.getText().toString();
                Bundle B= new Bundle();
                B.putString("taga",tag1);
                B.putString("tagb",tag2);
                B.putString("tagc",tag3);
                B.putString("tagd",tag4);
                i.putExtra("extras",B);
                if(tag1.trim().length()==0 || tag2.trim().length()==0||tag3.trim().length()==0||tag4.trim().length()==0){
                    Toast.makeText(getApplicationContext(),"Enter all 4 TAGs",Toast.LENGTH_SHORT).show();
                }else {startActivity(i);}


            }
        });
    }
}
