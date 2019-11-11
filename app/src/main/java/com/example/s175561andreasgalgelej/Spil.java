package com.example.s175561andreasgalgelej;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Spil extends AppCompatActivity{

    public static final Galgelogik gl = new Galgelogik();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spil);



        final TextView ordet = (TextView) findViewById(R.id.textView3);
        ordet.setText("Ordet: " + gl.getSynligtOrd());

        final TextView tv = (TextView) findViewById(R.id.textView4);

        Button b = (Button) findViewById(R.id.button4);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TextView gæt = findViewById(R.id.editText);
                gl.gætBogstav(gæt.getText().toString());

                ArrayList<String> bogstav = gl.getBrugteBogstaver();
                tv.setText("Brugte bogstaver: ");
                for (int i = 0;i < gl.getBrugteBogstaver().size();i++){
                    tv.setText(tv.getText().toString() + bogstav.get(i) + ", ");
                }

                ordet.setText("Ordet: " + gl.getSynligtOrd());

                if (gl.erSpilletTabt() == true){
                    Intent startIntent = new Intent(getApplicationContext(), SpilTabt.class);
                    startActivity(startIntent);
                }

                if (gl.erSpilletVundet() == true){
                    Intent startIntent = new Intent(getApplicationContext(), SpilVundet.class);
                    startActivity(startIntent);
                }

            }
        });
    }
}
