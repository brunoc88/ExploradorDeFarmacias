package com.softulp.exploradordefarmacias.ui.listaDeFarmacias;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.softulp.exploradordefarmacias.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        String nombre = getIntent().getStringExtra("TITULO");
        String direccion = getIntent().getStringExtra("DIRECCION");
        int foto = getIntent().getIntExtra("FOTO", 0); // 0 es un valor por defecto
        String horario = getIntent().getStringExtra("HORARIO");




        TextView tvNombre = findViewById(R.id.tvFarmacia);
        ImageView ivFoto = findViewById(R.id.ivFarmacia);
        TextView tvDireccion = findViewById(R.id.tvDireccion);
        TextView tvHorario = findViewById(R.id.tvHorario);

        tvNombre.setText(nombre);
        ivFoto.setImageResource(foto);
        tvDireccion.setText(direccion);
        tvHorario.setText(horario);

        Button volver = findViewById(R.id.btVolver);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}