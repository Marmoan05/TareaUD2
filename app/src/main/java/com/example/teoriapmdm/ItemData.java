package com.example.teoriapmdm;

public class ItemData {
    private String texto;
    private int imagenRId;
    private String edad;
    private String correo;

    public ItemData(String texto, int imagenRId, String edad, String correo) {
        this.texto = texto;
        this.imagenRId = imagenRId;
        this.edad = edad;
        this.correo = correo;
    }

    public String getTexto() {
        return texto;
    }

    public int getImagenRId() {
        return imagenRId;
    }

    public String getEdad() {
        return edad;
    }

    public String getCorreo() {
        return correo;
    }
}



