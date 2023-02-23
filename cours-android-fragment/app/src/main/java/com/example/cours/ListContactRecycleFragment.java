package com.example.cours;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.cours.adapter.ContactsAdapter;
import com.example.cours.databinding.FragmentListContactBinding;
import com.example.cours.databinding.FragmentListContactRecycleBinding;
import com.example.cours.model.Contact;
import com.example.cours.service.ContactService;


public class ListContactRecycleFragment extends Fragment {

    private Contact contact;

    private FragmentListContactRecycleBinding binding;

    private ContactService contactService;

    private ContactsAdapter contactsAdapter;

    public ListContactRecycleFragment() {
        // Required empty public constructor
        contactService  = new ContactService();
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            /*ListContactFragmentArgs args = ListContactFragmentArgs.fromBundle(getArguments());
            contact = new Contact(args.getFirstname(), args.getLastname(), args.getPhone());
            contactService.add(contact);*/
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentListContactRecycleBinding.inflate(inflater, container, false);
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        contactsAdapter = new ContactsAdapter(new ContactsAdapter.ContactDiff());
        binding.recyclerListContacts.setAdapter(contactsAdapter);
        binding.recyclerListContacts.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerListContacts.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        contactsAdapter.submitList(contactService.getContacts());
    }
}