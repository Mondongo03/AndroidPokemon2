package com.example.recyclerview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerview.databinding.FragmentNuevoElementoBinding;

public class NuevoElementoFragment extends Fragment {

    private FragmentNuevoElementoBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentNuevoElementoBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ElementosViewModel elementosViewModel = new ViewModelProvider(requireActivity()).get(ElementosViewModel.class);
        NavController navController = Navigation.findNavController(view);

        binding.crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = binding.nombre.getText().toString();
                String descripcion = binding.descripcion.getText().toString();
                String tipo1 = binding.tipo1.getText().toString();
                String tipo2 = binding.tipo2.getText().toString();
                int atq = Integer.parseInt(binding.atq.getText().toString());
                int imagenPorDefectoResource = R.drawable.defecto;

                Elemento nuevoElemento = new Elemento(titulo, descripcion, tipo1, tipo2, atq, imagenPorDefectoResource);

                elementosViewModel.insertar(nuevoElemento);
                navController.popBackStack();
            }
        });
    }
}