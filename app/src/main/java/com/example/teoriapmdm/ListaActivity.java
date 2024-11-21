package com.example.teoriapmdm;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import android.widget.ImageButton;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListaAdapter listaAdapter;
    private List<ItemData> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        ImageButton btnBack = findViewById(R.id.btnAtras);
        btnBack.setOnClickListener(v -> finish());

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemList = SharedItemList.itemList;
        listaAdapter = new ListaAdapter(itemList, new ListaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ItemData item) {
                Intent intent = new Intent(ListaActivity.this, DetalleActivity.class);
                intent.putExtra("item_texto", item.getTexto());
                intent.putExtra("item_imagen", item.getImagenRId());
                intent.putExtra("item_edad", item.getEdad());
                intent.putExtra("item_correo", item.getCorreo());
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(ItemData item, int posicion) {
                new AlertDialog.Builder(ListaActivity.this)
                        .setTitle("Confirmar eliminación")
                        .setMessage("¿Estás seguro de que quieres eliminar este elemento?")
                        .setPositiveButton("Eliminar", (dialog, which) -> {
                            SharedItemList.itemList.remove(posicion);
                            listaAdapter.notifyItemRemoved(posicion);
                            Toast.makeText(ListaActivity.this, "Elemento eliminado", Toast.LENGTH_SHORT).show();
                        })
                        .setNegativeButton("Cancelar", (dialog, which) -> {
                            Toast.makeText(ListaActivity.this, "Acción cancelada", Toast.LENGTH_SHORT).show();
                        })
                        .show();
            }

        });

        recyclerView.setAdapter(listaAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listaAdapter.notifyDataSetChanged();
    }
}


