package com.example.homework3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.homework3.Moon;

import java.util.List;

public class MoonAdapter extends RecyclerView.Adapter<MoonAdapter.ViewHolder> {

    interface OnStateClickListener {
        void onStateClick(Moon moon, int position);
    }

    private final OnStateClickListener onClickListener;

    private final LayoutInflater inflater;
    private final List<Moon> moons;

    MoonAdapter(Context context, List<Moon> moons, OnStateClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.moons = moons;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public MoonAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.moon_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoonAdapter.ViewHolder holder, int position) {
        Moon moon = moons.get(position);
        holder.landView.setImageResource(moon.getLandResources());
        holder.nameView.setText(moon.getName());
        holder.moonView.setText(moon.getMoon());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onStateClick(moon, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return moons.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView landView;
        final TextView nameView, moonView;

        ViewHolder(View view) {
            super(view);
            landView = (ImageView) view.findViewById(R.id.land);
            nameView = (TextView) view.findViewById(R.id.txt_name);
            moonView = (TextView) view.findViewById(R.id.txt_moon);
        }
    }
}
