package com.example.teoriapmdm;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRegistrar = findViewById(R.id.btnRegistrar);
        Button btnLista = findViewById(R.id.btnLista);

        btnRegistrar.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, RegistrarActivity.class);
            startActivity(intent);
        });

        btnLista.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ListaActivity.class);
            startActivity(intent);
        });

    }

}
