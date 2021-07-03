package com.segg3.profilemanager.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.segg3.profilemanager.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FlagListAdapter extends RecyclerView.Adapter<FlagListAdapter.FlagViewHolder> {

    private final List<String> flagsList;
    private View.OnClickListener onClickListener;

    public FlagListAdapter(List<String> flags, View.OnClickListener onClickListener) {
        this.flagsList = flags;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @NotNull
    @Override
    public FlagViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.flag_card_layout,parent,false);
        v.setOnClickListener(onClickListener);
        return new FlagViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FlagViewHolder holder, int position) {
        String flagName = flagsList.get(position);
        //holder.flagImage.setImageResource();
    }

    @Override
    public int getItemCount() {
        return flagsList.size();
    }

    class FlagViewHolder extends RecyclerView.ViewHolder {
        public final ImageView flagImage;

        public FlagViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            flagImage = itemView.findViewById(R.id.flag_view);
        }
    }
}