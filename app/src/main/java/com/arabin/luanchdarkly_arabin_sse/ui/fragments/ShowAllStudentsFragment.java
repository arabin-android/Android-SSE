package com.arabin.luanchdarkly_arabin_sse.ui.fragments;

import android.os.Bundle;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.arabin.luanchdarkly_arabin_sse.databinding.MainFragmentBinding;
import com.arabin.luanchdarkly_arabin_sse.ui.fragments.base.BaseFragment;
import com.arabin.roomdb.model.MainData;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Arabin
 * Shows all students
 * with at least 1 exam score
 * */
public class ShowAllStudentsFragment extends BaseFragment {

    protected MainFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = MainFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        intiView(binding.search.searchBar, binding.progressBar, "Enter student id.");
        mainViewModel.getMapOfExams().observe(getViewLifecycleOwner(), dataMap->{
            ArrayMap<String, MainData> items = dataMap.getContentIfNotHandled();
            if (items != null && !items.isEmpty() && !isSearching){
                setAdapter(new ArrayList<>(items.values()),
                        this, binding.resultList);
                hideProgressBar();
                hideShowAllButton(binding.noResults);
            }
        });
    }

    @Override
    public void onItemClicked(MainData data) {
        isSearching = true;
        handleSearch(data.getStudentId());
    }

    @Override
    protected void handleSearch(String query) {
        List<MainData> newItems = new ArrayList<>();
        if (query != null && !query.isEmpty()){
            for (MainData data: mainViewModel.getListOfData()) {
                if (query.equalsIgnoreCase(data.getStudentId()))
                    newItems.add(data);
            }
        }
        setAdapter(newItems, null, binding.resultList);
        hideProgressBar();
        if (newItems.isEmpty())
            showNoResults(binding.noResults);
        else
            hideShowAllButton(binding.noResults);
    }
}
