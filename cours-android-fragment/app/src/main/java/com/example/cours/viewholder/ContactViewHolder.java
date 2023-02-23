package com.example.cours.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cours.R;
import com.example.cours.model.Contact;

import org.w3c.dom.Text;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    private TextView firstNameTextView;
    private TextView lastNameTextView;
    private TextView phoneTextView;
    private Button itemButton;
    private View view;
    private Fragment fragment;

    public ContactViewHolder(@NonNull View itemView, Fragment fragment){
        this(itemView);
        this.fragment = fragment;
    }
    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        firstNameTextView = itemView.findViewById(R.id.firstname_textView_item);
        lastNameTextView = itemView.findViewById(R.id.lastname_textView_item);
        phoneTextView = itemView.findViewById(R.id.phone_textView_item);
        itemButton = itemView.findViewById(R.id.item_button);
        view = itemView;
    }

    public void display(Contact contact) {
        firstNameTextView.setText(contact.getFirstName());
        lastNameTextView.setText(contact.getLastName());
        phoneTextView.setText(contact.getPhone());
        itemButton.setOnClickListener((e) -> {
            System.out.println(contact.getFirstName());
            itemButton.setText("Done");
            NavHostFragment.findNavController(fragment).navigate(R.id.action_list_to_detail);
        });
    }

    public static ContactViewHolder create(ViewGroup parent, Fragment fragment) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        return new ContactViewHolder(view, fragment);
    }
}
