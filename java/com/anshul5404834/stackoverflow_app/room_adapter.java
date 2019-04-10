package com.anshul5404834.stackoverflow_app;

import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import static android.support.v4.content.ContextCompat.startActivity;

public class room_adapter extends ArrayAdapter<question_identity> {



     private List<question_identity> question_identities;
    private   Context context;

    public room_adapter(Context context, List<question_identity>question_identities) {
        super(context,0,question_identities);
        this.context=context;
        this.question_identities=question_identities;
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View m;
        if(convertView!=null){
            m=convertView;
        }else {
            m=LayoutInflater.from(context).inflate(R.layout.raw1,parent,false);
        }
        question_identity a = question_identities.get(position);
        TextView t1 = (TextView)m.findViewById(R.id.textView1);
        TextView t2 = (TextView)m.findViewById(R.id.textView2);
        t1.setText(a.getTitles());
        t2.setText(a.getLink_stack());

        return m;

    }
}
