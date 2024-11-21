package com.example.teoriapmdm;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class RegistrarActivity extends Activity {

    private EditText edtNombre, edtAnio, edtEmail;
    private ImageView imgPerfil;
    private Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        edtNombre = findViewById(R.id.edtNombre);
        edtAnio = findViewById(R.id.edtAnio);
        edtEmail = findViewById(R.id.edtEmail);
        imgPerfil = findViewById(R.id.imgPerfil);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        ImageButton btnAtras = findViewById(R.id.btnAtras);

        imgPerfil.setImageResource(R.drawable.imagenusuario);

        btnAtras.setOnClickListener(v -> finish());

        btnRegistrar.setOnClickListener(v -> {
            String nombre = edtNombre.getText().toString().trim();
            String anio = edtAnio.getText().toString().trim();
            String email = edtEmail.getText().toString().trim();

            if (nombre.isEmpty() || anio.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            int edad;
            try {
                edad = Integer.parseInt(anio);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Por favor, ingresa una edad válida", Toast.LENGTH_SHORT).show();
                return;
            }

            if (edad < 18) {
                Toast.makeText(this, "Debes tener al menos 18 años para registrarte", Toast.LENGTH_SHORT).show();
                return;
            }

            int imagenResId = R.drawable.imagenusuario;

            ItemData newItem = new ItemData(nombre, imagenResId, anio, email);
            SharedItemList.itemList.add(newItem);

            Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
