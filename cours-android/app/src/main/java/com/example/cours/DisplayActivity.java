package com.example.cours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.cours.model.Contact;

import org.w3c.dom.Text;

public class DisplayActivity extends AppCompatActivity {

    private Contact contact;
    private TextView firstNameTextView;
    private TextView lastNameTextView;
    private TextView phoneTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent intent = getIntent();
        contact = (Contact) intent.getSerializableExtra("contact");
        firstNameTextView = findViewById(R.id.firstname_textView);
        lastNameTextView = findViewById(R.id.lastname_textView);
        phoneTextView = findViewById(R.id.phone_textView);
        firstNameTextView.setText(contact.getFirstName());
        lastNameTextView.setText(contact.getLastName());
        phoneTextView.setText(contact.getPhone());
    }
}