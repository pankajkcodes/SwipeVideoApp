package com.simplifiededtech.swipevideoapp.activities;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.simplifiededtech.swipevideoapp.R;
import com.simplifiededtech.swipevideoapp.databinding.ActivityBottomBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityBottomBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBottomBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_search,
                R.id.navigation_add,  R.id.navigation_notifications,  R.id.navigation_person)
                .build();
        NavController navController = Navigation.findNavController(this,
                R.id.nav_host_fragment_activity_bottom);

        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}