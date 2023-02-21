package com.example.cours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class CalculatriceActivity extends AppCompatActivity {

    private TableLayout calculatriceLayout;
    private String[] elements = {"C", "+/-", "%", "/", "7", "8", "9", "X", "4", "5", "6", "-", "1", "2", "3", "+", "0", ",","="};
    private TableRow row;
    private TextView screen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatrice);
        calculatriceLayout = findViewById(R.id.calculatrice_table);
        screen = findViewById(R.id.screen);
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        setTitle(message);
        generateTable();
    }

    private void generateTable() {
        int x = 0;
        int y = 0;
        for(String s : elements) {
            if(x == 0 || (x) % 4 == 0) {
                row = new TableRow(this);
                calculatriceLayout.addView(row);
                y++;
            }
            Button b = new Button(this);
            b.setText(s);
            TableRow.LayoutParams params =new TableRow.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.weight = 1;
            if(y == 5) {
                params.weight = 1;
                if (s == "0") {
                    params.weight = 10;
                }
            }

            b.setLayoutParams(params);
            b.setOnClickListener((e) -> {
                actionButton((Button) e);
            });
            row.addView(b);
            x++;
        }
    }

    private void actionButton(Button b) {
        screen.setText(screen.getText()+""+b.getText());
    }
}