package com.example.s175561andreasgalgelej;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class SpilVundet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spil_vundet);

        ArrayList <String> brugteBogstaver = Spil.gl.getBrugteBogstaver();

        int forsøg = brugteBogstaver.size();

        String forsøgString = String.valueOf(forsøg);

        TextView antalForsøg = (TextView) findViewById(R.id.textView8);

        antalForsøg.setText("Antal forsøg: " + forsøgString);
    }
}
