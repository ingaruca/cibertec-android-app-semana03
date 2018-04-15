package com.example.ingarukal11.cibertecsemana03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listUsuarios = (ListView)findViewById(R.id.listUsuarios);

        String equipos[] = {"Seishun Gakuen", "Fudomine", "Yamabuki", "Hyotei", "Rikkai Dai"};
        final String ventanas[] = {"equipo1", "equipo2", "equipo3", "equipo4", "equipo5"};

        ListAdapter adap = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, equipos);

        listUsuarios.setAdapter(adap);

        listUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int y, long l) {
                String nombre = ventanas[y];

                try{
                    Class cls = Class.forName("com.example.ingarukal11.cibertecsemana03." + nombre);
                    Intent i = new Intent(getApplicationContext(), cls);
                    startActivity(i);
                }catch (Exception e){

                }
            }
        });
    }
}
