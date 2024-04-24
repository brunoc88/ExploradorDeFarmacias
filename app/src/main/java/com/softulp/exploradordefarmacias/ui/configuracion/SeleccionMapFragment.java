package com.softulp.exploradordefarmacias.ui.configuracion;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;
import com.softulp.exploradordefarmacias.R;

public class SeleccionMapFragment extends Fragment {

    private TipoDeMapaViewModel viewModel;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(TipoDeMapaViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seleccion_map, container, false);
        Button btNormal = view.findViewById(R.id.btNormal);
        Button btHybrido = view.findViewById(R.id.btHybrido);
        Button btSatellital = view.findViewById(R.id.btSatellital);
        Button btTerranio = view.findViewById(R.id.btTerranio);

        btNormal.setOnClickListener(v -> viewModel.setMapType(GoogleMap.MAP_TYPE_NORMAL));
        btHybrido.setOnClickListener(v -> viewModel.setMapType(GoogleMap.MAP_TYPE_HYBRID));
        btSatellital.setOnClickListener(v -> viewModel.setMapType(GoogleMap.MAP_TYPE_SATELLITE));
        btTerranio.setOnClickListener(v -> viewModel.setMapType(GoogleMap.MAP_TYPE_TERRAIN));

        return view;
    }
}
