package com.example.recyclerview;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Elemento {
    @PrimaryKey(autoGenerate = true)
    int id;
    String nombre;
    String descripcion;
    String tipo1;
    String tipo2;
    String habilidad;
    String habilidadOculta;
    String movimiento1;
    String movimiento2;
    String movimiento3;
    String movimiento4;

    int hp;
    int atq;
    int def;
    int sDef;
    int sAtq;
    int vel;
    int imageResource; // Agregar campo para el recurso de imagen
    public int imagenPorDefectoResource;

    public Elemento(String nombre, String descripcion, String tipo1, String tipo2,int atq, int imagenPorDefectoResource) {


        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.atq = atq;
        this.imageResource = imagenPorDefectoResource; // Asignar imagen por defecto
        this.imagenPorDefectoResource = imagenPorDefectoResource; // Asignar imagen por defecto
    }
}
