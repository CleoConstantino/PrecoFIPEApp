package com.github.precofipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.github.precofipeapp.activities.ModelosActivity;
import com.github.precofipeapp.adapter.MarcasAdapter;
import com.github.precofipeapp.api.Api;
import com.github.precofipeapp.api.model.Marcas;
import com.github.precofipeapp.util.DialogUtil;
import com.github.precofipeapp.util.KeyUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listaMarcas;
    private MarcasAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaMarcas = findViewById(R.id.listaVeiculos);
        listaMarcas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent it = new Intent(MainActivity.this, ModelosActivity.class);
                it.putExtra(KeyUtil.KEY_CODIGO_MARCA, ((Marcas)adapter.getItem(i)).getCodigo());
                startActivity(it);
            }
        });

        Toast.makeText(MainActivity.this, "Buscando marcas de veículos", Toast.LENGTH_LONG).show();

        Api.getMarcas(new Callback<List<Marcas>>() {
            @Override
            public void onResponse(Call<List<Marcas>> call, Response<List<Marcas>> response) {
                if (response.isSuccessful()) {
                    adapter = new MarcasAdapter(MainActivity.this, response.body());
                    listaMarcas.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
                else {
                    DialogUtil.showError(MainActivity.this, "Erro", "Falha ao buscar as marcas de veículo!");
                }
            }

            @Override
            public void onFailure(Call<List<Marcas>> call, Throwable t) {
                t.printStackTrace();
                DialogUtil.showError(MainActivity.this, "Erro", "Falha ao buscar as marcas de veículo![001]");
            }
        });
    }
}