package com.example.cours;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cours.databinding.FragmentDetailBinding;
import com.example.cours.model.Contact;


public class DetailFragment extends Fragment {



    private Contact contact;

    private FragmentDetailBinding binding;
    public DetailFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            DetailFragmentArgs args = DetailFragmentArgs.fromBundle(getArguments());
            contact = new Contact(args.getFirstname(), args.getLastname(), args.getPhone());
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
    }
}