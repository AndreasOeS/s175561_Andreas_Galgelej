package com.example.s175561andreasgalgelej;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SpilTabt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spil_tabt);

        String ord = Spil.gl.getOrdet();

        TextView visOrd = (TextView) findViewById(R.id.textView7);

        visOrd.setText("Ordet var: " + ord);

    }
}
