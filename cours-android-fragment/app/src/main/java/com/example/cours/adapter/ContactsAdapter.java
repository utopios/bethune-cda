package com.example.cours.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.cours.model.Contact;
import com.example.cours.viewholder.ContactViewHolder;

public class ContactsAdapter extends ListAdapter<Contact, ContactViewHolder> {


    public ContactsAdapter(@NonNull DiffUtil.ItemCallback<Contact> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ContactViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = getItem(position);
        holder.display(contact);
    }

    public static class ContactDiff extends DiffUtil.ItemCallback<Contact> {

        @Override
        public boolean areItemsTheSame(@NonNull Contact oldItem, @NonNull Contact newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Contact oldItem, @NonNull Contact newItem) {
            return oldItem.getFirstName().equals(newItem.getFirstName()) && oldItem.getLastName().equals(newItem.getLastName()) && oldItem.getPhone().equals(newItem.getPhone());
        }
    }
}
