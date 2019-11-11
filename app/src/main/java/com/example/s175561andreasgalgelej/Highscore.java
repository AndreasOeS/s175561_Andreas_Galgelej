package com.example.s175561andreasgalgelej;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class Highscore extends AppCompatActivity {


    public static final String HighscoreFile = "HighscoreFile";
    private SharedPreferences mpreference;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        mpreference = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mpreference.edit();

        ListView listView = (ListView) findViewById(R.id.listView1);

        ArrayList <String> brugteBogstaver = Spil.gl.getBrugteBogstaver();

        int forsøg = brugteBogstaver.size();

        String ord = Spil.gl.getOrdet();

        int bogstaverIOrd = ord.length();

        int score = (((forsøg + 1) * 1000) / ((bogstaverIOrd + 1) * 1000)) * 100;




        ArrayList<String> highscores = new ArrayList<>();
        ArrayList<Integer> highscoreSomInt = new ArrayList<>();


        highscores.add(mpreference.getString("1", "1"));
        highscores.add(mpreference.getString("2", "2"));
        highscores.add(mpreference.getString("3", "3"));
        highscores.add(mpreference.getString("4", "4"));
        highscores.add(mpreference.getString("5", "5"));
        //highscores.add(mpreference.getString("6", "6"));


        if (Spil.gl.erSpilletVundet()){

            highscores.add(String.valueOf(score));

            for (int i = 0; i < 5; i++){
                highscoreSomInt.add(Integer.parseInt(highscores.get(i)));
            }

            Collections.sort(highscoreSomInt);



            for (int i = 0;i < 5 ; i++){
                highscores.set(i, String.valueOf(highscoreSomInt.get(i)));
            }

            mEditor.putString("1", highscores.get(5));
            mEditor.putString("2", highscores.get(1));
            mEditor.putString("3", highscores.get(2));
            mEditor.putString("4", highscores.get(3));
            mEditor.putString("5", highscores.get(4));
            mEditor.putString("6", highscores.get(5));

            mEditor.commit();
        }


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.highscore_layout, R.id.textView10, highscores);
        listView.setAdapter(arrayAdapter);


    }
}
