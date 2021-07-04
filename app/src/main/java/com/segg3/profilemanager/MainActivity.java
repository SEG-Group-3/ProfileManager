package com.segg3.profilemanager;

import android.os.Bundle;

import com.blongho.country_data.Country;
import com.blongho.country_data.World;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.segg3.profilemanager.databinding.ActivityMainBinding;
import com.segg3.profilemanager.ui.FlagListFragment;
import com.segg3.profilemanager.ui.ProfileEditFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FragmentManager fragmentManager;
    private static MainActivity instance;
    private Country country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        instance = this;

        World.init(getApplicationContext()); // Initializes the libray and loads all data

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        fragmentManager = this.getSupportFragmentManager();
        swapViews(fragmentManager, new ProfileEditFragment());
    }

    public static MainActivity getInstance(){
        return instance;
    }


    public static void swapViews(FragmentManager manager, Fragment next) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, next);
        transaction.commit();
    }

    public Country getCountry() {
        if (country != null)
            return country;
        country = World.getCountryFrom("CA");
        return  country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

//    public static void swipeFragmentLeft(FragmentManager manager, Fragment next) {
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
//        transaction.replace(R.id.fragment_container, next);
//        transaction.commit();
//    }
//
//    public static void swipeFragmentRight(FragmentManager manager, Fragment next) {
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
//        transaction.replace(R.id.fragment_container, next);
//        transaction.commit();
//    }

}