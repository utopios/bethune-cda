package com.example.cours;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cours.databinding.FragmentFirstBinding;
import com.example.cours.databinding.FragmentFormBinding;


public class FormFragment extends Fragment {

    public FragmentFormBinding binding;


    //Construction du fragment
    public FormFragment() {
        // Required empty public constructor
    }


    //Après la création de l'objet
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

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
        binding.validButton.setOnClickListener((e) -> {
            FormFragmentDirections.ActionFormToList action = FormFragmentDirections.actionFormToList(binding.firstnameEdittext.getText().toString(), binding.lastnameEdittext.getText().toString(), binding.phoneEdittext.getText().toString());
            NavHostFragment.findNavController(FormFragment.this).navigate(action);
            binding.firstnameEdittext.setText(null);
            binding.lastnameEdittext.setText(null);
            binding.phoneEdittext.setText(null);
        });
    }
}