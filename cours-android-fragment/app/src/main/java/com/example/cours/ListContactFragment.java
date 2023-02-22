package com.example.cours;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.cours.databinding.FragmentListContactBinding;
import com.example.cours.model.Contact;
import com.example.cours.service.ContactService;


public class ListContactFragment extends Fragment {

    private Contact contact;

    private FragmentListContactBinding binding;

    private ContactService contactService;

    public ListContactFragment() {
        // Required empty public constructor
        contactService  = new ContactService();
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            ListContactFragmentArgs args = ListContactFragmentArgs.fromBundle(getArguments());
            contact = new Contact(args.getFirstname(), args.getLastname(), args.getPhone());
            contactService.add(contact);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentListContactBinding.inflate(inflater, container, false);
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ArrayAdapter<Contact> contactArrayAdapter = new ArrayAdapter<Contact>(getContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,contactService.getContacts());
        binding.listContactsView.setAdapter(contactArrayAdapter);
        binding.listContactsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(l + " "+i);
            }
        });
    }
}