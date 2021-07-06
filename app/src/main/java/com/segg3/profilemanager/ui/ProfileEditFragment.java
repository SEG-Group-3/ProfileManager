package com.segg3.profilemanager.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.segg3.profilemanager.MainActivity;
import com.segg3.profilemanager.databinding.FragmentHomeBinding;

public class ProfileEditFragment extends Fragment {
    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.avatarImage.setImageResource(MainActivity.getInstance().getCountry().getFlagResource());


        binding.avatarImage.setOnClickListener(v-> MainActivity.swapViews(getParentFragmentManager(), new FlagListFragment()));

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