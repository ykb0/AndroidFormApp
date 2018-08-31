package com.myzob.lab41;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    String first;
    String last;
    String count;
    String occ;
    String gen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        first = getIntent().getExtras().getString("firstName");
        last = getIntent().getExtras().getString("lastName");
        count = getIntent().getExtras().getString("country");
        occ = getIntent().getExtras().getString("occupation");
        gen = getIntent().getExtras().getString("radio");

        TextView textView = findViewById(R.id.text);
        textView.setText("First Name - "+first+"\n\n"
                +"Last Name - "+last+"\n\n"
                +"Gender - "+gen+"\n\n"
                +"Country - "+count+"\n\n"
                +"Occupation - "+occ);
    }
}
