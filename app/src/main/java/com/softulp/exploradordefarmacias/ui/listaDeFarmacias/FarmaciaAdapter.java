package com.softulp.exploradordefarmacias.ui.listaDeFarmacias;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softulp.exploradordefarmacias.R;
import com.softulp.exploradordefarmacias.modelo.Farmacia;

import java.util.List;

public class FarmaciaAdapter extends RecyclerView.Adapter<FarmaciaAdapter.ViewHolder> {

    private List<Farmacia> listaDeFarmacias;
    private LayoutInflater li;
    private FarmaciaItemClickListener listener;

    public interface FarmaciaItemClickListener {
        void onMasClicked(Bundle bundle);
    }

    public FarmaciaAdapter(List<Farmacia> listaDeFarmacias, Context context, LayoutInflater layoutInflater, FarmaciaItemClickListener listener) {
        this.listaDeFarmacias = listaDeFarmacias;
        this.li = layoutInflater;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Farmacia farmacia = listaDeFarmacias.get(position);
        holder.nombre.setText(farmacia.getNombre());
        holder.horario.setText(farmacia.getHorario());
        holder.mas.setOnClickListener(view -> {
            if (listener != null) {
                Bundle bundle = new Bundle();
                bundle.putString("TITULO", farmacia.getNombre());
                bundle.putString("DIRECCION", farmacia.getDireccion());
                bundle.putInt("FOTO", farmacia.getFoto());
                bundle.putString("HORARIO", farmacia.getHorario());
                listener.onMasClicked(bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaDeFarmacias.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, horario;
        ImageView foto;
        Button mas;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tvNombre);
            horario = itemView.findViewById(R.id.tvHorario);
            mas = itemView.findViewById(R.id.btMas);
            //foto = itemView.findViewById(R.id.ivFoto); // Descomenta si vas a usar la imagen
        }
    }
}
