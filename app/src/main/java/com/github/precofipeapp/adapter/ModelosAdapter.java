package com.github.precofipeapp.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.github.precofipeapp.R;
import com.github.precofipeapp.api.model.Modelos;

import java.util.List;

public class ModelosAdapter extends BaseAdapter {

    private Activity activity;
    private List<Modelos.Itens> arlModelos;

    public ModelosAdapter(final Activity activity, final List<Modelos.Itens> arlVeiculos) {
        this.activity = activity;
        this.arlModelos = arlVeiculos;
    }

    @Override
    public int getCount() {
        return arlModelos.size();
    }

    @Override
    public Object getItem(int i) {
        return arlModelos.get(i);
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
        textNome.setText(arlModelos.get(i).getNome());

        TextView textCodigo= view.findViewById(R.id.textCodigo);
        textCodigo.setText("" + arlModelos.get(i).getCodigo());

        return view;
    }
}