package com.arabin.luanchdarkly_arabin_sse.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.arabin.luanchdarkly_arabin_sse.R;
import com.arabin.luanchdarkly_arabin_sse.databinding.OptionsFragmentBinding;
import com.arabin.luanchdarkly_arabin_sse.ui.fragments.helper.NavigationHelper;

/**
 * @author Arabin
 * A fragment that shows
 * the options to choose
 * */
public class OptionsFragment extends Fragment implements View.OnClickListener{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                requireActivity().finish();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return OptionsFragmentBinding.inflate(inflater, container, false).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        view.findViewById(R.id.show_all_students).setOnClickListener(this);
        view.findViewById(R.id.show_all_exams).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.show_all_students:
                launchFragment(R.id.student_fragment_by_score);
                break;
            case R.id.show_all_exams:
                launchFragment(R.id.fragment_by_exam);
                break;
        }
    }

    public void launchFragment(int fragmentId){
        NavController controller = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        controller.navigate(fragmentId, null, NavigationHelper.getNavigationOption());
    }

}
