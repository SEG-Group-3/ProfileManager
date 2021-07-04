package com.segg3.profilemanager.ui;

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
import com.segg3.profilemanager.adapters.FlagListAdapter;
import com.segg3.profilemanager.databinding.FragmentFlagsListBinding;

import java.util.List;

public class FlagListFragment extends Fragment {
    private FragmentFlagsListBinding binding;
    List<Country> countries;
    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO Get a list of ONLY EUROPEAN countries
        countries = World.getAllCountries();

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentFlagsListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(calculateNoOfColumns(200), StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);


        binding.recyclerView.setLayoutManager(layoutManager);

        FlagListAdapter adapter = new FlagListAdapter(countries, null);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.scrollToPosition(0);



        return root;
    }

    public int calculateNoOfColumns(float columnWidthDp) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (screenWidthDp / columnWidthDp + 0.5); // +0.5 for correct rounding to int.
        return noOfColumns;
    }

    private void onFlagClicked(View view) {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}