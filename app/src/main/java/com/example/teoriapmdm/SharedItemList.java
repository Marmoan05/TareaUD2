package com.example.teoriapmdm;

import java.util.ArrayList;
import java.util.List;

public class SharedItemList {
    // Lista estática de ItemData
    public static List<ItemData> itemList = new ArrayList<>();

    static {
        // Usamos una ruta o nombre de imagen en lugar del recurso directo
        itemList.add(new ItemData("Anonimo 1", R.drawable.imagenusuario, "99", "anonimo1@example.com"));
        itemList.add(new ItemData("Anonimo 2", R.drawable.imagenusuario, "99", "anonimo2@example.com"));
        itemList.add(new ItemData("Anonimo 3", R.drawable.imagenusuario, "99", "anonimo3@example.com"));
    }
}
