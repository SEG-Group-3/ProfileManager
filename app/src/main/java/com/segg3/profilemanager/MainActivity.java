package com.segg3.profilemanager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.blongho.country_data.Country;
import com.blongho.country_data.World;
import com.segg3.profilemanager.databinding.ActivityMainBinding;
import com.segg3.profilemanager.ui.ProfileEditFragment;

public class MainActivity extends AppCompatActivity {

    private static MainActivity instance;
    private Country country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setInstance(this);

        World.init(getApplicationContext()); // Initializes the libray and loads all data

        com.segg3.profilemanager.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        FragmentManager fragmentManager = this.getSupportFragmentManager();
        swapViews(fragmentManager, new ProfileEditFragment());
    }

    public static MainActivity getInstance(){
        return instance;
    }

    public static void setInstance(MainActivity activity){
        instance = activity;
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

}