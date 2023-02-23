package com.example.cours.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cours.R;
import com.example.cours.model.Contact;

import org.w3c.dom.Text;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    private TextView firstNameTextView;
    private TextView lastNameTextView;
    private TextView phoneTextView;
    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        firstNameTextView = itemView.findViewById(R.id.firstname_textView_item);
        lastNameTextView = itemView.findViewById(R.id.lastname_textView_item);
        phoneTextView = itemView.findViewById(R.id.phone_textView_item);

    }

    public void display(Contact contact) {
        firstNameTextView.setText(contact.getFirstName());
        lastNameTextView.setText(contact.getLastName());
        phoneTextView.setText(contact.getPhone());
    }

    public static ContactViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        return new ContactViewHolder(view);
    }
}
