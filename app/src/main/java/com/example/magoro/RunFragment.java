package com.example.magoro;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class RunFragment extends Fragment {

    Button playButton;
    Button pauseButtn;
    Button stopButton;
    public boolean pause = true;



    public RunFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();

        View rootView = inflater.inflate(R.layout.fragment_run, container, false);

        playButton = (Button)rootView.findViewById(R.id.start);
        stopButton = (Button)rootView.findViewById(R.id.stop);
        pauseButtn = (Button)rootView.findViewById(R.id.pause);

        playButton.setVisibility(View.VISIBLE);
        stopButton.setVisibility(View.GONE);
        pauseButtn.setVisibility(View.GONE);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //when play is clicked show stop button and hide play button
                playButton.setVisibility(View.GONE);
                stopButton.setVisibility(View.VISIBLE);
                pauseButtn.setVisibility(View.VISIBLE);
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //when play is clicked show stop button and hide play button
                playButton.setVisibility(View.GONE);
                stopButton.setVisibility(View.GONE);
                pauseButtn.setVisibility(View.GONE);

                RunRelatorio fragment1 = new RunRelatorio();
                FragmentManager fragmentManager1 = getFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                fragmentTransaction1.replace(R.id.frame_layout, fragment1);
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();

            }
        });
        pauseButtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pause == true)
                {
                    pauseButtn.setBackgroundColor(Color.GREEN);
                    pauseButtn.setText("Resume");
                    pause = false;
                }
                else if(pause == false)
                {
                    pauseButtn.setBackgroundColor(Color.parseColor("#00BCD4"));
                    pauseButtn.setText("Pause");
                    pause = true;
                }

            }
        });




        return rootView;
    }

}