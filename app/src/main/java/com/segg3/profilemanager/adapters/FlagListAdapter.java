package com.segg3.profilemanager.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blongho.country_data.Country;
import com.segg3.profilemanager.MainActivity;
import com.segg3.profilemanager.R;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.List;

public class FlagListAdapter extends RecyclerView.Adapter<FlagListAdapter.FlagViewHolder> {

    private final List<Country> countries;
    private View.OnClickListener onClickListener;

    public FlagListAdapter(List<Country> countries, View.OnClickListener onClickListener) {
        this.countries = countries;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @NotNull
    @Override
    public FlagViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v= View.inflate(parent.getContext(), R.layout.flag_card_layout, null);
        v.setOnClickListener(onClickListener);
        return new FlagViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FlagViewHolder holder, int position) {
        Country country = countries.get(position);

        holder.flagImage.setImageResource(country.getFlagResource());
        holder.country.setText(country.getName());

    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    class FlagViewHolder extends RecyclerView.ViewHolder {
        public final ImageView flagImage;
        public final TextView country;

        public FlagViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            flagImage = itemView.findViewById(R.id.flag_view);
            country = itemView.findViewById(R.id.country_name);
        }
    }
}