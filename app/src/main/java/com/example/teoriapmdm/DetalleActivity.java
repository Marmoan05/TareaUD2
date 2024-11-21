package com.example.teoriapmdm;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        ImageButton btnAtras = findViewById(R.id.btnAtras);
        btnAtras.setOnClickListener(v -> finish());

        ImageView detalleImage = findViewById(R.id.imagen);
        TextView detalleText = findViewById(R.id.nombre);
        TextView detalleEdad = findViewById(R.id.edad);
        TextView detalleCorreo = findViewById(R.id.correo);

        String nombre = getIntent().getStringExtra("item_text");
        int imagenResId = getIntent().getIntExtra("item_image_res", R.drawable.ic_launcher_foreground);
        String edad = getIntent().getStringExtra("item_edad");
        String correo = getIntent().getStringExtra("item_correo");

        detalleImage.setImageResource(imagenResId);
        detalleText.setText(nombre);
        detalleEdad.setText("Edad: " + edad);
        detalleCorreo.setText("Correo: " + correo);
    }
}

