package com.segg3.profilemanager;

import android.os.Bundle;

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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FragmentManager fragmentManager;
    // Hello

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        fragmentManager = this.getSupportFragmentManager();
        swapViews(fragmentManager, new FlagListFragment());



    }


    public static void swapViews(FragmentManager manager, Fragment next) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, next);
        transaction.commit();
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