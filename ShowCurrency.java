package com.maame.change;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowCurrency extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_currency);

        TextView Display = findViewById(R.id.chosencurrencyID);
        Bundle bn = getIntent().getExtras();
        Double name = bn.getDouble("show");
        Display.setText(String.valueOf(name));
    }
}
