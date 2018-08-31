package com.myzob.lab41;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private Spinner country;
    private AutoCompleteTextView occupation;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.country_spinner);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        //create instance of array adapter for spinner

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Country,R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //create instance of array adapter for autoCompleteTextView

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,
                R.array.Occupation,R.layout.support_simple_spinner_dropdown_item);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(arrayAdapter);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        country = findViewById(R.id.country_spinner);
        occupation = findViewById(R.id.autoCompleteTextView);

    }

    public void submit(View view){
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rg);
        String string1 = firstName.getText().toString();
        String string2 = lastName.getText().toString();
        String string3 = country.getSelectedItem().toString();
        String string4 = occupation.getText().toString();
        String string5 = ((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("firstName",string1);
        intent.putExtra("lastName",string2);
        intent.putExtra("country",string3);
        intent.putExtra("occupation",string4);
        intent.putExtra("radio",string5);
        startActivity(intent);
    }

    public void reset(View view){
        finish();
        startActivity(new Intent(this,MainActivity.class));
    }

}
