package com.arabin.luanchdarkly_arabin_sse.ui.adapter;

import androidx.recyclerview.widget.RecyclerView;

import com.arabin.luanchdarkly_arabin_sse.databinding.DataCellBinding;
import com.arabin.roomdb.model.MainData;

public class MainDataViewHolder extends RecyclerView.ViewHolder {

    private final DataCellBinding cellBinding;

    public MainDataViewHolder(DataCellBinding binding) {
        super(binding.getRoot());
        cellBinding = binding;
    }

    public void setDetails(MainData data){
        cellBinding.setData(data);
    }

}
