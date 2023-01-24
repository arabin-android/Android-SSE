package com.arabin.luanchdarkly_arabin_sse.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.arabin.luanchdarkly_arabin_sse.databinding.ActivityMainBinding;
import com.arabin.luanchdarkly_arabin_sse.utils.NetWorkUtil;
import com.arabin.luanchdarkly_arabin_sse.viewmodel.MainViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ActivityMainBinding.inflate(getLayoutInflater()).getRoot());
        initViewModel();
    }

    private void initViewModel() {
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (NetWorkUtil.hasInternetConnection(this)){
            mainViewModel.startServerEvent();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mainViewModel.stopServerEvent();
    }
}