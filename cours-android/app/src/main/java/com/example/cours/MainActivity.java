package com.example.cours;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ajouter des éléments par le code dans mon activité.
        /*LinearLayout mainLayout  = findViewById(R.id.main_linear_layout);
        for(int i = 1; i < 4; i++) {
            Button b = new Button(this);
            b.setText("contenu button" + i);
            mainLayout.addView(b);
        }*/
    }
}