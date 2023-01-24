package com.arabin.luanchdarkly_arabin_sse.ui.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.arabin.luanchdarkly_arabin_sse.R;
import com.arabin.luanchdarkly_arabin_sse.databinding.WelcomeScreenBinding;
import com.arabin.luanchdarkly_arabin_sse.ui.fragments.helper.NavigationHelper;
import com.arabin.luanchdarkly_arabin_sse.utils.NetWorkUtil;

public class WelcomeScreen extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return WelcomeScreenBinding.inflate(inflater, container, false).getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (NetWorkUtil.hasInternetConnection(requireContext())) {
                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.list_fragment, null, NavigationHelper.getNavigationOption());
            } else {
                Toast.makeText(requireContext(), "No Internet connection. Please try again later.", Toast.LENGTH_SHORT).show();
                requireActivity().finish();
            }
        }, 1500);
    }
}
