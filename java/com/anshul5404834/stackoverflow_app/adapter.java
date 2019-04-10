package com.anshul5404834.stackoverflow_app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class adapter extends ArrayAdapter {
    private Context mcontext;
    private List<stack_pojo> stack_pojos;
    public adapter(Context context, List<stack_pojo>stack_pojos) {
        super(context, 0,stack_pojos);
        this.mcontext=context;
        this.stack_pojos=stack_pojos;
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        View m = convertView;
        if (m == null){
            m = LayoutInflater.from(mcontext).inflate(R.layout.raw1,parent,false);
        }
        stack_pojo ab = stack_pojos.get(position);

        TextView t1 = (TextView)m.findViewById(R.id.textView1);
        final TextView t2 = (TextView)m.findViewById(R.id.textView2);
        Button sharing =m.findViewById(R.id.sharing);
        t2.setText(ab.getLink_stack());
        t1.setText(ab.getTITLE());
        sharing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_SEND_MULTIPLE);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, t2.getText());
                Intent chooser = Intent.createChooser(intent,t2.getText());
                v.getContext().startActivity(chooser);
            }
        });
t2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent WEB = new Intent(Intent.ACTION_VIEW);
        WEB.setData(Uri.parse(t2.getText().toString()));
        v.getContext().startActivity(WEB);
    }
});
        return m;
    }
}
