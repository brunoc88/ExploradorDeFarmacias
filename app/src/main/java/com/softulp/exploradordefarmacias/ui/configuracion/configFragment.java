package com.softulp.exploradordefarmacias.ui.configuracion;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softulp.exploradordefarmacias.R;
import com.softulp.exploradordefarmacias.databinding.FragmentConfigBinding;

public class configFragment extends Fragment {
    private FragmentConfigBinding binding;
    private ConfigViewModel mViewModel;

    public static configFragment newInstance() {
        return new configFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentConfigBinding.inflate(inflater, container, false);
        binding.btMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.nav_elegirMap);
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ConfigViewModel.class);
        // TODO: Use the ViewModel
    }

}