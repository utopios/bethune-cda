package com.example.cours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.cours.model.Contact;

public class FormActivity extends AppCompatActivity {

    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText phoneEditText;
    private Button validButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        firstNameEditText = findViewById(R.id.firstname_edittext);
        lastNameEditText = findViewById(R.id.lastname_edittext);
        phoneEditText = findViewById(R.id.phone_edittext);
        validButton =findViewById(R.id.valid_button);

        validButton.setOnClickListener((e) -> {
            Intent intent = new Intent(this, DisplayActivity.class);
            Contact contact = new Contact(firstNameEditText.getText().toString(), lastNameEditText.getText().toString(), phoneEditText.getText().toString());
            intent.putExtra("contact", contact);
            startActivity(intent);
        });
    }
}