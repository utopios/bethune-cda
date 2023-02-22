package com.example.cours;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cours.databinding.FragmentDemoBinding;
import com.example.cours.databinding.FragmentFirstBinding;


public class DemoFragment extends Fragment {

    private FragmentDemoBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDemoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        if(getArguments() != null) {
            DemoFragmentArgs args = DemoFragmentArgs.fromBundle(getArguments());
            binding.argumentTextView.setText(args.getTitle());
        }

    }
}