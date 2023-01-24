package com.arabin.luanchdarkly_arabin_sse.ui.fragments.base;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.arabin.luanchdarkly_arabin_sse.ui.adapter.MainDataAdapter;
import com.arabin.luanchdarkly_arabin_sse.viewmodel.MainViewModel;
import com.arabin.roomdb.model.MainData;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * @author Arabin
 * BaseFragment handles all common operations
 * */
@AndroidEntryPoint
public abstract class BaseFragment extends Fragment implements
        SearchView.OnQueryTextListener, MainDataAdapter.IPassOnItemClick {

    protected MainViewModel mainViewModel;
    protected boolean isSearching = false;
    private ProgressBar progressBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
    }

    protected void intiView(SearchView searchView,
                            ProgressBar progressBar, String queryHint) {
        searchView.setOnQueryTextListener(this);
        this.progressBar = progressBar;
        searchView.setQueryHint(queryHint);
    }

    protected abstract void handleSearch(String query);

    @Override
    public boolean onQueryTextSubmit(String query) {
        isSearching = true;
        handleSearch(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText.isEmpty()) {
            showProgressBar();
            handleSearch(null);
        }
        return false;
    }

    protected void setAdapter(List<MainData> items,
                              MainDataAdapter.IPassOnItemClick aIpIPassOnItemClick,
                              RecyclerView recyclerView){
        MainDataAdapter adapter = new MainDataAdapter(items, aIpIPassOnItemClick);
        recyclerView.setAdapter(adapter);
    }

    protected void hideProgressBar(){
        if (progressBar != null)
            progressBar.setVisibility(View.GONE);
    }

    protected void showProgressBar(){
        if (progressBar != null)
            progressBar.setVisibility(View.VISIBLE);
    }

    protected void showNoResults(AppCompatButton showAll){
        Toast.makeText(requireContext(), "No results found", Toast.LENGTH_SHORT).show();
        showAll.setVisibility(View.VISIBLE);
        showAll.setOnClickListener(v -> {
            isSearching = false;
            showAll.setVisibility(View.GONE);
            showProgressBar();
        });
    }

    protected void hideShowAllButton(AppCompatButton button){
        button.setVisibility(View.GONE);
    }

}
