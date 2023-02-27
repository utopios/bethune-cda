package com.example.cours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.cours.model.Contact;
import com.example.cours.model.Person;
import com.example.cours.service.PersonService;
import com.example.cours.util.RetrofitClient;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        //Créer le service

        PersonService personService = RetrofitClient.getInstance().getRetrofit().create(PersonService.class);
        personService.getPersons().enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                List<Person> personList = response.body();
            }

            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {

            }
        });
    }
}