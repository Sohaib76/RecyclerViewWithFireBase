package com.khf.sohaib.studentportal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Assignments extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignments);

       textView =  (TextView) findViewById(R.id.textView);
       textView.setMovementMethod(LinkMovementMethod.getInstance());
       textView.setText(Html.fromHtml(getResources().getString(R.string.a1)));
    }
}
