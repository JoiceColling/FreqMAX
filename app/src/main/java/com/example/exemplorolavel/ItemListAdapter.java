package com.example.exemplorolavel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Comparator;
import java.util.List;

public class ItemListAdapter  extends BaseAdapter {
    List<Item> itens;
    Context ctx;

    public ItemListAdapter(List<Item> itens, Context ctx){
        this.itens = itens;
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Object getItem(int i) {
        return itens.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(ctx);

        View itemLayout = inflater.inflate(R.layout.item, null);
        TextView txtItemNome = itemLayout.findViewById(R.id.txtItemNome);
        TextView txtItemFrequencia = itemLayout.findViewById(R.id.txtItemFrequencia);

        itens.sort(Comparator.comparing(Item::getFrequenciaCardiaca).reversed());
        txtItemNome.setText(itens.get(i).getNome());
        txtItemFrequencia.setText("FCM: " + itens.get(i).getFrequenciaCardiaca());
        return itemLayout;
    }
}
