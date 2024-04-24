package com.softulp.exploradordefarmacias.ui.listaDeFarmacias;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softulp.exploradordefarmacias.R;
import com.softulp.exploradordefarmacias.databinding.FragmentDetallesBinding;
import com.softulp.exploradordefarmacias.databinding.FragmentGalleryBinding;

public class DetallesFragment extends Fragment {

    private DetallesViewModel mViewModel;
    private FragmentDetallesBinding binding;
    public static DetallesFragment newInstance() {
        return new DetallesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentDetallesBinding.inflate(inflater, container, false);
        return binding.getRoot(); // Debe devolver la vista inflada por binding
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            String titulo = getArguments().getString("TITULO", "");
            String direccion = getArguments().getString("DIRECCION", "");
            int foto = getArguments().getInt("FOTO");
            String horario = getArguments().getString("HORARIO", "");

            binding.tvFarmacia.setText(titulo);
            binding.tvDireccion.setText(direccion);
            binding.ivFoto.setImageResource(foto);
            binding.tvHorario.setText(horario);
        }
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DetallesViewModel.class);
        // TODO: Use the ViewModel
    }

}