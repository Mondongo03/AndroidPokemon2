package com.example.recyclerview;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RecyclerBusquedaFragment extends RecyclerElementosFragment{
    LiveData<List<Elemento>> obtenerElementos() {
        return elementosViewModel.buscar();
    }
}

