package com.github.precofipeapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.precofipeapp.MainActivity;
import com.github.precofipeapp.R;
import com.github.precofipeapp.adapter.ModelosAdapter;
import com.github.precofipeapp.api.Api;
import com.github.precofipeapp.api.model.Anos;
import com.github.precofipeapp.api.model.Marcas;
import com.github.precofipeapp.api.model.Modelos;
import com.github.precofipeapp.util.DialogUtil;
import com.github.precofipeapp.util.KeyUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelosActivity extends AppCompatActivity {

    private ListView listaModelos;
    private ModelosAdapter adapter;
    private int codigo_marca;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modelos);

        listaModelos = findViewById(R.id.listaModelo);
        listaModelos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(ModelosActivity.this, AnosActivity.class);
                it.putExtra(KeyUtil.KEY_CODIGO_MODELO, ((Modelos.Itens)adapter.getItem(i)).getCodigo());
                it.putExtra(KeyUtil.KEY_CODIGO_MARCA, codigo_marca);
                startActivity(it);
            }
        });

        Toast.makeText(ModelosActivity.this, "Buscando modelos dos veículos", Toast.LENGTH_LONG).show();

        codigo_marca = getIntent().getIntExtra(KeyUtil.KEY_CODIGO_MARCA, 0);
        Api.getModelos(getIntent().getIntExtra(KeyUtil.KEY_CODIGO_MARCA, 0), new Callback<Modelos>() {
            @Override
            public void onResponse(Call<Modelos> call, Response<Modelos> response) {
                if (response.isSuccessful()) {
                    adapter = new ModelosAdapter(ModelosActivity.this, response.body().getModelos());
                    listaModelos.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
                else {
                    DialogUtil.showError(ModelosActivity.this, "Erro", "Falha ao buscar os modelos de veículo!");
                }

            }

            @Override
            public void onFailure(Call<Modelos> call, Throwable t) {
                t.printStackTrace();
                DialogUtil.showError(ModelosActivity.this, "Erro", "Falha ao buscar os modelos de veículo![002]");

            }
        });
    }
}
