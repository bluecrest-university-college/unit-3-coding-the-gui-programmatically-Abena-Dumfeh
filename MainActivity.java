package com.maame.change;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner dropdownmenu;
    private EditText amountindollars;
    private Button gotosecondactivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Creating Button
        gotosecondactivity = (Button) findViewById(R.id.convertID);
        gotosecondactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                //Conversion Logic

                //The different currencies
                double yen,yuan,singdollar,won,peso;
                yen = 109.99;
                yuan = 6.70962;
                singdollar = 1.35075;
                won = 1132.98;
                peso = 41.8120;

                //Result holders
                double yen1,yuan1,singdollar1,won1,peso1;

                double value;


                //Take value user enters in the amountindollars,parse as a double and store in resultvalue
                Double resultvalue = Double.parseDouble(amountindollars.getText().toString());
                yen1 = resultvalue*yen;
                yuan1 = resultvalue*yuan;
                singdollar1 = resultvalue*singdollar;
                won1 = resultvalue*won;
                peso1 = resultvalue*peso;

               // amountindollars.setText(resultvalue);

               // Double value = Double.parseDouble(amountindollars.getText().toString());
                Intent intent = new Intent(MainActivity.this,ShowCurrency.class);
                intent.putExtra("show", resultvalue);
                startActivity(intent );
            }
        });

        //Getting Amount in Dollars
        amountindollars = (EditText) findViewById(R.id.amountID);


        //Creating the SPINNER
        //Creating the list of currencies to be displayed
        dropdownmenu = (Spinner) findViewById(R.id.currenciesID);



        ArrayAdapter<CharSequence>  adapter = ArrayAdapter.createFromResource(this,R.array.currencies,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownmenu.setAdapter(adapter );
        dropdownmenu.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String itemvalue = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),itemvalue, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
