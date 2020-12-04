package com.example.magoro;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    ImageButton CarinhoB;
    ImageButton FoodB;
    ImageButton SleepB;
    private FragmentActivity fragmentActivity;
    public int j;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();




        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        CarinhoB = (ImageButton)rootView.findViewById(R.id.carinho);
        FoodB = (ImageButton)rootView.findViewById(R.id.food);
        SleepB = (ImageButton)rootView.findViewById(R.id.sleep);

        CarinhoB.setOnClickListener(v -> insertNestedFragment(1));

        FoodB.setOnClickListener(v -> insertNestedFragment(2));

        SleepB.setOnClickListener(v -> insertNestedFragment(3));

        insertNestedFragment(j);

        return rootView;

    }



    private void insertNestedFragment(int j) {
        if( j == 2){

            Fragment childFragment = new FoodFragment();
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(R.id.HFLayout, childFragment).commit();

        }
        else if(j ==3){
            Fragment childFragment = new SleepFragment();
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(R.id.HFLayout, childFragment).commit();

        }else
        {
            Fragment childFragment = new CarinhoFragment();
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(R.id.HFLayout, childFragment).commit();

        }

    }



}