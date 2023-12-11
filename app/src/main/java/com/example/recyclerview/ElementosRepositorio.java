package com.example.recyclerview;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ElementosRepositorio {


    Executor executor = Executors.newSingleThreadExecutor();

    ElementosBaseDeDatos.ElementosDao elementosDao;

    ElementosRepositorio(Application application){
        elementosDao = ElementosBaseDeDatos.obtenerInstancia(application).obtenerElementosDao();
    }

    LiveData<List<Elemento>> obtener(){
        return elementosDao.obtener();
    }

    LiveData<List<Elemento>> buscar(String t) {
        return elementosDao.buscar(t);
    }

    void insertar(Elemento elemento){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                elemento.imageResource = elemento.imagenPorDefectoResource;
                elementosDao.insertar(elemento);
            }
        });
    }

    void eliminar(Elemento elemento) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                elementosDao.eliminar(elemento);
            }
        });
    }

    public void actualizar(Elemento elemento) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                elementosDao.actualizar(elemento);
            }
        });
    }
}
