package com.example.android.gestor01;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Android on 14/09/2016.
 */

@DatabaseTable//indica que la clase Contacto mapee una tabla
public class Contacto {
    @DatabaseField(generatedId = true)// inica que id es un campo de la tabla y genera automaticamente
    private int id;

    @DatabaseField
    private String nombre;

    @DatabaseField
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
