package com.example.s175561andreasgalgelej;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Spil extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spil);

        Galgelogik gl = new Galgelogik();

        TextView ordet = (TextView) findViewById(R.id.textView3);
        ordet.setText("Ordet: " + gl.getSynligtOrd());

        final TextView tv = (TextView) findViewById(R.id.textView4);
        tv.setText("Forkerte: ");
        Button b = (Button) findViewById(R.id.button4);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView forkert = findViewById(R.id.editText);


                tv.setText(tv.getText().toString() + forkert.getText().toString());
            }
        });
    }
}
