package com.segg3.profilemanager.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.blongho.country_data.Country;
import com.blongho.country_data.World;
import com.google.android.flexbox.AlignContent;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.segg3.profilemanager.R;
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





        final List<Country> countries = World.getAllCountries();


        binding.recyclerView.setFlexDirection(FlexDirection.ROW);
        binding.recyclerView.setFlexWrap(FlexWrap.WRAP);
        binding.recyclerView.setJustifyContent(JustifyContent.SPACE_EVENLY);
        binding.recyclerView.setAlignItems(AlignItems.CENTER);
        binding.recyclerView.setAlignContent(AlignContent.CENTER);




        for (Country c: countries) {
            View itemView= View.inflate(getContext(), R.layout.flag_card_layout, null);
            ImageView flagImage = itemView.findViewById(R.id.flag_view);
            TextView countryName = itemView.findViewById(R.id.country_name);
            flagImage.setImageResource(c.getFlagResource());
            countryName.setText(c.getName());
            binding.recyclerView.addView(itemView);
        }

        binding.recyclerView.scrollTo(0, 0);


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