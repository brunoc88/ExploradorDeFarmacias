package com.softulp.exploradordefarmacias.ui.listaDeFarmacias;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softulp.exploradordefarmacias.R;
import com.softulp.exploradordefarmacias.databinding.FragmentGalleryBinding;
import com.softulp.exploradordefarmacias.modelo.Farmacia;

import java.util.List;

public class GalleryFragment extends Fragment implements FarmaciaAdapter.FarmaciaItemClickListener {

    private FragmentGalleryBinding binding;
    private GalleryViewModel vm;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vm = new ViewModelProvider(this).get(GalleryViewModel.class);
        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        vm.getListaMutable().observe(getViewLifecycleOwner(), farmacias -> {
            RecyclerView rv = binding.rvlista;
            GridLayoutManager glm = new GridLayoutManager(getContext(), 2);
            rv.setLayoutManager(glm);
            FarmaciaAdapter farmaciaAdapter = new FarmaciaAdapter(farmacias, getContext(), getLayoutInflater(), this);
            rv.setAdapter(farmaciaAdapter);
        });

        vm.crearLista();

        return root;
    }

    @Override
    public void onMasClicked(Bundle bundle) {
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.detallesFragment, bundle);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}


