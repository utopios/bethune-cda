package com.example.cours;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

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

        //Retrouver les éléments d'un layout
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        TableLayout tableLayout = findViewById(R.id.main_table_layout);
        for(int i = 0; i < tableLayout.getChildCount(); i++) {
            TableRow row = (TableRow) tableLayout.getChildAt(i);
            for(int j=0; j < row.getChildCount(); j++) {
                Button b = (Button) row.getChildAt(j);
                //b.setText("edit button");
                b.setOnClickListener((e) -> {
                   dialogBuilder.setMessage(((Button)e).getText()).create().show();
                });
            }
        }
    }
}