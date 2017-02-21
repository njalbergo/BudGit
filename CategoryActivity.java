package com.example.malakagunawardena.loginregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        final TextView amount1 = (TextView) findViewById(R.id.amount1);
        final TextView amount2 = (TextView) findViewById(R.id.amount2);
        final TextView category1 = (TextView) findViewById(R.id.category1);
        final TextView category2 = (TextView) findViewById(R.id.category2);

    }
}