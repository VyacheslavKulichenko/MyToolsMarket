package com.kulichenko.mytoolsmarket;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PilCategoryActivity extends AppCompatActivity {

    private ListView listViewPila;

    private ArrayList<ObjectInstrums> saws;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pil_category);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        saws = new ArrayList<>();
        saws.add(new ObjectInstrums(getString(R.string.pila_BOSCH_title), getString(R.string.pila_BOSCH_info), R.drawable.pila_bosh));
        saws.add(new ObjectInstrums(getString(R.string.pila_GRAPHITE_title), getString(R.string.pila_GRAPHITE_info), R.drawable.pila_graphite));
        saws.add(new ObjectInstrums(getString(R.string.pila_STANLEY_title), getString(R.string.pila_STANLEY_info), R.drawable.pila_stanley));
        listViewPila = findViewById(R.id.listViewPila);
        ArrayAdapter<ObjectInstrums> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, saws);
        listViewPila.setAdapter(adapter);
        listViewPila.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ObjectInstrums objektInstrum = saws.get(position);
                Intent intent = new Intent(getApplicationContext(), InstrumDetailActivity.class);
                intent.putExtra("title", objektInstrum.getTitle());
                intent.putExtra("info", objektInstrum.getInfo());
                intent.putExtra("resId", objektInstrum.getImageResourceId());
                startActivity(intent);
            }
        });
    }
}



