package com.arabin.luanchdarkly_arabin_sse.ui.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.arabin.roomdb.model.MainData;

import java.util.ArrayList;
import java.util.List;

public class ShowAllExamsFragment extends ShowAllStudentsFragment{

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.intiView(binding.search.searchBar, binding.progressBar, "Enter exam id.");
        mainViewModel.getListOfAllData().observe(getViewLifecycleOwner(), mainData->{
            List<MainData>data = mainData.getContentIfNotHandled();
            if (data != null && !data.isEmpty() && !isSearching) {
                setAdapter(data, this, binding.resultList);
                hideProgressBar();
                hideShowAllButton(binding.noResults);
            }
        });
    }

    @Override
    protected void handleSearch(String query) {
        List<MainData> newItems = new ArrayList<>();
        if (query != null && !query.isEmpty()){
            for (MainData data: mainViewModel.getListOfData()) {
                if (query.equalsIgnoreCase(data.getExam()))
                    newItems.add(data);
            }
        }
        setAdapter(newItems, null, binding.resultList);
        hideProgressBar();
        if (newItems.isEmpty()) {
            showNoResults(binding.noResults);
        } else
            hideShowAllButton(binding.noResults);
    }

    @Override
    public void onItemClicked(MainData data) {
        isSearching = true;
        handleSearch(data.getExam());
    }

}
