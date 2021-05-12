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

public class BolgarCategoryActivity extends AppCompatActivity {

    private ListView listViewShlifmas;

    private ArrayList<ObjectInstrums> shlifmas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolgar_category);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        shlifmas = new ArrayList<>();
        shlifmas.add(new ObjectInstrums(getString(R.string.shlifmash_intertool_title), getString(R.string.shlifmash_intertool_info), R.drawable.shlifintertool));
        shlifmas.add(new ObjectInstrums(getString(R.string.shlifmash_verto_title), getString(R.string.shlifmash_verto_info), R.drawable.shlifmashinaverto));
        shlifmas.add(new ObjectInstrums(getString(R.string.shlifmash_graphite_title), getString(R.string.shlifmash_graphite_info), R.drawable.shlifmashinagraphite));
        listViewShlifmas = findViewById(R.id.listViewShlifmash);
        ArrayAdapter<ObjectInstrums> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, shlifmas);
        listViewShlifmas.setAdapter(adapter);
        listViewShlifmas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ObjectInstrums objektInstrum = shlifmas.get(position);
                Intent intent = new Intent(getApplicationContext(), InstrumDetailActivity.class);
                intent.putExtra("title", objektInstrum.getTitle());
                intent.putExtra("info", objektInstrum.getInfo());
                intent.putExtra("resId", objektInstrum.getImageResourceId());
                startActivity(intent);
            }
        });
    }
}



