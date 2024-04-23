package com.softulp.exploradordefarmacias.ui.listaDeFarmacias;

import android.content.Context;
import android.content.Intent;
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
    private Context context;
    private LayoutInflater li;

    public FarmaciaAdapter(List<Farmacia> listaDeFarmacias, Context context, LayoutInflater layoutInflater) {
        this.listaDeFarmacias = listaDeFarmacias;
        this.context = context;  // Asignar el parámetro al campo
        this.li = layoutInflater; // Usar el parámetro
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombre.setText(listaDeFarmacias.get(position).getNombre());
        holder.foto.setImageResource(listaDeFarmacias.get(position).getFoto());
        holder.horario.setText(listaDeFarmacias.get(position).getHorario());
        holder.mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondActivity.class);
                Farmacia farmacia = listaDeFarmacias.get(holder.getAdapterPosition());

                intent.putExtra("TITULO", farmacia.getNombre());
                intent.putExtra("DIRECCION", farmacia.getDireccion());
                intent.putExtra("FOTO", farmacia.getFoto());
                intent.putExtra("Horario", farmacia.getHorario());


                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaDeFarmacias.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nombre;
        private ImageView foto;
        private TextView horario;
        private Button mas;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tvNombre);
            foto = itemView.findViewById(R.id.ivFoto);
            horario = itemView.findViewById(R.id.tvHorario);
            mas = itemView.findViewById(R.id.btMas);
        }
    }
}
