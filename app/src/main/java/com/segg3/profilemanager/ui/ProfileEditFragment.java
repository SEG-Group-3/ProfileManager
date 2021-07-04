package com.segg3.profilemanager.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.blongho.country_data.Country;
import com.blongho.country_data.World;
import com.segg3.profilemanager.MainActivity;
import com.segg3.profilemanager.adapters.FlagListAdapter;
import com.segg3.profilemanager.databinding.FragmentFlagsListBinding;
import com.segg3.profilemanager.databinding.FragmentHomeBinding;

import java.util.List;

public class ProfileEditFragment extends Fragment {
    private FragmentHomeBinding binding;
    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.avatarImage.setImageResource(MainActivity.getInstance().getCountry().getFlagResource());


        binding.avatarImage.setOnClickListener((v)-> {
            MainActivity.swapViews(getParentFragmentManager(), new FlagListFragment());
        });

        binding.googleMapsButton.setOnClickListener(this::onOpenInMaps);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    public void onOpenInMaps(View v){
        String address = binding.teamAddressInput.getText().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("geo:0,0?q=" + address));
        startActivity(intent);
    }
}