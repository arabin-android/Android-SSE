package com.arabin.luanchdarkly_arabin_sse.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.arabin.luanchdarkly_arabin_sse.R;
import com.arabin.roomdb.model.MainData;

import java.util.List;

public class MainDataAdapter extends RecyclerView.Adapter<MainDataViewHolder> {


    private final List<MainData>items;
    private IPassOnItemClick iPassOnItemClick;

    public MainDataAdapter(List<MainData> data, IPassOnItemClick aIPassOnItemClickInterface){
        items = data;
        iPassOnItemClick = aIPassOnItemClickInterface;
    }


    @NonNull
    @Override
    public MainDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainDataViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.data_cell, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainDataViewHolder holder, int position) {
        holder.setDetails(items.get(position));
        if (iPassOnItemClick != null)
            holder.itemView.setOnClickListener(v ->{
                iPassOnItemClick.onItemClicked(items.get(position));
            });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface IPassOnItemClick{
        void onItemClicked(MainData data);
    }

}
