package com.github.precofipeapp.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.github.precofipeapp.R;
import com.github.precofipeapp.api.model.Marcas;
import com.github.precofipeapp.model.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class MarcasAdapter extends BaseAdapter {

    private Activity activity;
    private List<Marcas> arlVeiculos;

    public MarcasAdapter(final Activity activity, final List<Marcas> arlVeiculos) {
        this.activity = activity;
        this.arlVeiculos = arlVeiculos;
    }

    @Override
    public int getCount() {
        return arlVeiculos.size();
    }

    @Override
    public Object getItem(int i) {
        return arlVeiculos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view ==null) {
            view = activity.getLayoutInflater().inflate(R.layout.item_lista, viewGroup, false);
        }

        TextView textNome = view.findViewById(R.id.textNome);
        textNome.setText(arlVeiculos.get(i).getNome());

        TextView textCodigo= view.findViewById(R.id.textCodigo);
        textCodigo.setText("" + arlVeiculos.get(i).getCodigo());

        return view;
    }
}