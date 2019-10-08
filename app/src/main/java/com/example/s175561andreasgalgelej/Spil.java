package com.example.s175561andreasgalgelej;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Spil extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spil);

        final Galgelogik gl = new Galgelogik();

        TextView ordet = (TextView) findViewById(R.id.textView3);
        ordet.setText("Ordet: " + gl.getSynligtOrd());

        final TextView tv = (TextView) findViewById(R.id.textView4);

        Button b = (Button) findViewById(R.id.button4);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TextView gæt = findViewById(R.id.editText);
                gl.gætBogstav(gæt.getText().toString());

                ArrayList<String> bogstav = gl.getBrugteBogstaver();
                tv.setText("Forkerte: ");
                for (int i = 0;i < gl.getBrugteBogstaver().size();i++){
                    tv.setText(tv.getText().toString() + bogstav.get(i));
                }
            }
        });
    }
}
