package com.example.magoro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity{

    private BottomNavigationView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentManager fm = getSupportFragmentManager();
        RunFragment fragment = new RunFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();

        menu = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        menu.getMenu().findItem(R.id.Run).setChecked(true);


        menu = findViewById(R.id.bottom_navigation);


       menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               Fragment selectedFragment = null;

               switch (item.getItemId()){
                   case R.id.Run:
                       selectedFragment = new RunFragment();
                       break;
                   case R.id.Settings:
                       selectedFragment = new SettingsFragment();
                       break;
                   case R.id.Home:
                       selectedFragment = new HomeFragment();
                       break;
                   case R.id.Games:
                       selectedFragment = new GameFragment();
                       break;
                   case R.id.Shop:
                       selectedFragment = new LojaFragment();
                       break;
               }

               getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, selectedFragment).commit();
               return true;
           }
       });


    }

}