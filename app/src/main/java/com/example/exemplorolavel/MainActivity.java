package com.example.exemplorolavel;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText txtNome;
    EditText txtIdade;
    ListView listItems;
    ItemListAdapter adapter;
    List<Item> itens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNome = findViewById(R.id.txtNome);
        txtIdade = findViewById(R.id.txtIdade);
        listItems = findViewById(R.id.listItems);

        adapter = new ItemListAdapter(itens, getBaseContext());
        listItems.setAdapter(adapter);
    }

    public void addItem(View v){
        String nome = txtNome.getText().toString();
        String idade = txtIdade.getText().toString();

        if( nome == null || nome.isEmpty() || idade == null || idade.isEmpty())
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Os campos nome e idade são obrigatórios");
            builder.setTitle("Atenção!");
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        else
        {
            Item it = new Item();

            it.setNome(nome);
            it.setIdade(Integer.parseInt(idade));
            it.setFrequenciaCardiaca();

            txtNome.setText("");
            txtIdade.setText("");

            itens.add(it);
            adapter.notifyDataSetChanged();
        }
    }
}