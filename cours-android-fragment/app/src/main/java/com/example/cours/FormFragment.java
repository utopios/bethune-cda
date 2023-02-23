package com.example.cours;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cours.databinding.FragmentFirstBinding;
import com.example.cours.databinding.FragmentFormBinding;
import com.example.cours.model.Contact;
import com.example.cours.service.ContactService;


public class FormFragment extends Fragment {

    public FragmentFormBinding binding;
    private String stringContactId;
    private Contact contact = null;
    private ContactService contactService;
    //Construction du fragment
    public FormFragment() {
        // Required empty public constructor
        contactService = new ContactService();
    }


    //Après la création de l'objet
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            FormFragmentArgs args = FormFragmentArgs.fromBundle(getArguments());
            stringContactId = args.getContactId();
        }
    }
    //La création de la vue du fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFormBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    //Après la création de la view du fragment
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        if(!stringContactId.equals("null")) {
            contact = contactService.getContactById(Integer.valueOf(stringContactId));
            if(contact != null) {
                binding.firstnameEdittext.setText(contact.getFirstName());
                binding.lastnameEdittext.setText(contact.getLastName());
                binding.phoneEdittext.setText(contact.getPhone());
            }
        }

        binding.validButton.setOnClickListener((e) -> {
            if(contact == null) {
                contact = new Contact(binding.firstnameEdittext.getText().toString(), binding.lastnameEdittext.getText().toString(), binding.phoneEdittext.getText().toString());
                contactService.add(contact);
                contact = null;
            }
            else {
                contactService.update(binding.firstnameEdittext.getText().toString(), binding.lastnameEdittext.getText().toString(), binding.phoneEdittext.getText().toString(), Integer.valueOf(stringContactId));
            }
            binding.firstnameEdittext.setText(null);
            binding.lastnameEdittext.setText(null);
            binding.phoneEdittext.setText(null);
            NavDirections action = FormFragmentDirections.actionFormToList();
            NavHostFragment.findNavController(FormFragment.this).navigate(action);
        });
    }
}