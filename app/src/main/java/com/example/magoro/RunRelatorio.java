package com.example.magoro;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class RunRelatorio extends Fragment {


    public RunRelatorio() {
        // Required empty public constructor
    }

    ImageButton closeBtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
        View rootView = inflater.inflate(R.layout.fragment_run_relatorio, container, false);

        closeBtn = (ImageButton)rootView.findViewById(R.id.closeBtn);


        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RunFragment fragment1 = new RunFragment();
                FragmentManager fragmentManager1 = getFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                fragmentTransaction1.replace(R.id.frame_layout, fragment1);
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();

            }
        });

        return rootView;
    }


}