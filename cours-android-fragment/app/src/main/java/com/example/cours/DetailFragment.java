package com.example.cours;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cours.databinding.FragmentDetailBinding;
import com.example.cours.model.Contact;
import com.example.cours.service.ContactService;


public class DetailFragment extends Fragment {



    private ContactService contactService;
    private Contact contact;
    private int id;

    private FragmentDetailBinding binding;
    public DetailFragment() {
        contactService = new ContactService();
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            DetailFragmentArgs args = DetailFragmentArgs.fromBundle(getArguments());
            contact = contactService.getContactById(args.getId());
            id = args.getId();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        binding.firstnameTextView.setText(contact.getFirstName());
        binding.lastnameTextView.setText(contact.getLastName());
        binding.phoneTextView.setText(contact.getPhone());
        binding.editButton.setOnClickListener((e) -> {
            DetailFragmentDirections.ActionDetailToForm action = DetailFragmentDirections.actionDetailToForm().setContactId(String.valueOf(id));
            NavHostFragment.findNavController(DetailFragment.this).navigate(action);
        } );
    }
}