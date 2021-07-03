package com.segg3.profilemanager.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.segg3.profilemanager.adapters.FlagListAdapter;
import com.segg3.profilemanager.databinding.FragmentFlagsListBinding;

import java.util.ArrayList;
import java.util.List;

public class FlagListFragment extends Fragment {
    private FragmentFlagsListBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentFlagsListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        List<String> stuff = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            stuff.add("123");
        }

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.scrollToPosition(0);


        FlagListAdapter flagListAdapter = new FlagListAdapter(stuff, this::onFlagClicked);
        binding.recyclerView.setAdapter(flagListAdapter);

        return root;
    }

    private void onFlagClicked(View view) {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}