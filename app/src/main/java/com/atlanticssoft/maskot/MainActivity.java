package com.atlanticssoft.maskot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    // Declaración de Variables Globales
    SwipeRefreshLayout sfiMiRefresh;
    ListView lvMiLista;
    Adapter adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        agregarFAB();

        sfiMiRefresh = (SwipeRefreshLayout) findViewById(R.id.sfiMiRefresh);
        lvMiLista = (ListView) findViewById(R.id.lvMiLista);

        String[] planetas = getResources().getStringArray(R.array.planetas);
        lvMiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,planetas));

        sfiMiRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Llamo al metodoque refresca el contenido del ListView
                refrescandoContenido();
            }
        });

    }

    public void refrescandoContenido(){
        // Vuelvo a recargar el contenido de la activity
        String[] planetas = getResources().getStringArray(R.array.planetas);
        lvMiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,planetas));
        sfiMiRefresh.setRefreshing(false);
    }

    public void agregarFAB(){
        // Enlazando el diseño del botón con la Lógica
        FloatingActionButton miFabStar = (FloatingActionButton) findViewById(R.id.miFAB);

        miFabStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Skrpion", "Mensaje es: "+2);
                //Toast.makeText(getApplicationContext(),getText(R.string.mensaje), Toast.LENGTH_SHORT).show();
                Snackbar.make(v,getText(R.string.mensaje), Snackbar.LENGTH_SHORT)

                        // Botón de Acción que aparecerá en el Snackbar de Main Activity
                        .setAction(getText(R.string.texto_accion), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.i("Skrpion", "Click en Acción");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.cyan_500))
                        .show();

            }
        });
    }
}