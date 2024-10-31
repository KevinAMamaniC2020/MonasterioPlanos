package com.example.monasterioplanos;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class MainActivity extends AppCompatActivity implements plano.OnAreaClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plano planoView = findViewById(R.id.plano);
        planoView.setOnAreaClickListener(this);
    }

    @Override
    public void onAreaClicked(String areaName) {
        // Muestra el fragmento según el área seleccionada
        Fragment fragment = new AreaFragment();
        Bundle args = new Bundle();
        args.putString("areaName", areaName);
        fragment.setArguments(args);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}