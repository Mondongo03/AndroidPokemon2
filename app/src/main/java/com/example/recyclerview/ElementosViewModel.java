package com.example.recyclerview;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import java.util.List;

import kotlin.jvm.functions.Function1;

public class ElementosViewModel extends AndroidViewModel {

    ElementosRepositorio elementosRepositorio;


    MutableLiveData<Elemento> elementoSeleccionado = new MutableLiveData<>();
    MutableLiveData<String> terminoBusqueda = new MutableLiveData<>();

    LiveData<List<Elemento>> resultadoBusqueda = Transformations.switchMap(terminoBusqueda, new Function1<String, LiveData<List<Elemento>>>() {
        @Override
        public LiveData<List<Elemento>> invoke(String input) {
            return elementosRepositorio.buscar(input);
        }
    });


    public ElementosViewModel(@NonNull Application application) {
        super(application);

        elementosRepositorio = new ElementosRepositorio(application);
    }

    LiveData<List<Elemento>> obtener(){
        return elementosRepositorio.obtener();
    }

    void insertar(Elemento elemento){
        elementosRepositorio.insertar(elemento);
    }

    void eliminar(Elemento elemento){
        elementosRepositorio.eliminar(elemento);
    }

    void actualizar(Elemento elemento){
        elementosRepositorio.actualizar(elemento);
    }

    void seleccionar(Elemento elemento){
        elementoSeleccionado.setValue(elemento);
    }

    MutableLiveData<Elemento> seleccionado(){
        return elementoSeleccionado;
    }
    LiveData<List<Elemento>> buscar(){
        return resultadoBusqueda;
    }

    void establecerTerminoBusqueda(String t){
        terminoBusqueda.setValue(t);
    }
}
