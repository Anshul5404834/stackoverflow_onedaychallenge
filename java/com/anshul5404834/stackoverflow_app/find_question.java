package com.anshul5404834.stackoverflow_app;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class find_question extends AsyncTask<String,String,List<stack_pojo>> {
    HttpURLConnection connection;
    URL url;
    ListView l ;
    InputStream stream = null;
    String tag1,tag2,tag3,tag4;
    List<stack_pojo> stack_pojos = new ArrayList<>();
    StringBuffer data;

     public find_question(ListView listView){
     this.l=listView;
     }
     List<question_identity>question_identities =new ArrayList<>();

   //   public void find_question(String a,String b,String c,String d){
   //       tag1=a;
   //       tag2=b;
   //       tag3=c;
   //       tag4=d;
   //
   //   }

    @Override
    protected void onPreExecute() {
        Toast.makeText(l.getContext(),"TOUCH LINK FOR MORE INFO",Toast.LENGTH_LONG).show();

        super.onPreExecute();
    }
    //"https://api.stackexchange.com/2.2/questions?order=desc&sort=activity&tagged="+tag1+";"+tag2+";"+tag3+";"+tag4+";"+"&site=stackoverflow"
    Database  db;
    @Override
    protected  List<stack_pojo> doInBackground(String... strings) {
db= Room.databaseBuilder(l.getContext(),Database.class,"stackoverflow_databse").fallbackToDestructiveMigration().build();

        try {
            try {
                url = new URL(strings[0]);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                connection = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                connection.connect();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                stream = connection.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            BufferedReader reader;
            reader = new BufferedReader(new InputStreamReader(stream));

            data = new StringBuffer();
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    data.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            {
                try {
                    JSONObject parentobject;
                    JSONArray parentarray;
                    parentobject = new JSONObject(data.toString());
                    parentarray = parentobject.getJSONArray("items");
                    for (int i = 0; i < parentarray.length(); i++) {
                        JSONObject mainblocks = parentarray.getJSONObject(i);
                        stack_pojos.add(new stack_pojo(mainblocks.optString("title").toString(), mainblocks.optString("link").toString()));
                        Log.e("hello world", "doInBackground: "+mainblocks.optString("title") );
                        Log.e("hello world", "doInBackground: "+mainblocks.optString("link") );
              //
              //       //     // for dao
                     String Local = mainblocks.optString("title");
              //       int b = Local.indexOf('T');
              //       String date1 = Local.substring(0, b);
                    question_identity a = new question_identity();
                    a.setLink_stack(mainblocks.optString("link"));
                    a.setTitles(mainblocks.optString("title"));
                    question_identities.add(a);

                    }
                    db.stack_overflow().addentityList(question_identities);
                    question_identities = db.stack_overflow().getAll();

                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }

        }catch (Exception e){}
if (stack_pojos!=null){
    Log.e("hello world", "doInBackground:  we are doing good" );
}
        return stack_pojos;

    }

    @Override
    protected void onPostExecute(final List<stack_pojo> stack_pojos) {
             super.onPostExecute(stack_pojos);

        Log.e("hello world", "doInBackground: "+stack_pojos.toString());
                adapter a =  new adapter(l.getContext(),stack_pojos);
                l.setAdapter(a);

    }
}