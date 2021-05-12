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

public class FenCategoryActivity extends AppCompatActivity {

    private ListView listViewFen;

    private ArrayList<ObjectInstrums> fen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fen_category);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        fen = new ArrayList<>();
        fen.add(new ObjectInstrums(getString(R.string.fen_GRAPHITE_title), getString(R.string.fen_GRAPHITE_info), R.drawable.fen_graphite));
        fen.add(new ObjectInstrums(getString(R.string.fen_INTERTOOL_title), getString(R.string.fen_INTERTOOL_info), R.drawable.fen_intertool));
        fen.add(new ObjectInstrums(getString(R.string.fen_VERTO_title), getString(R.string.fen_VERTO_info), R.drawable.fen_verto));
        listViewFen = findViewById(R.id.listViewFen);
        ArrayAdapter<ObjectInstrums> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, fen);
        listViewFen.setAdapter(adapter);
        listViewFen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ObjectInstrums objektInstrum = fen.get(position);
                Intent intent = new Intent(getApplicationContext(), InstrumDetailActivity.class);
                intent.putExtra("title", objektInstrum.getTitle());
                intent.putExtra("info", objektInstrum.getInfo());
                intent.putExtra("resId", objektInstrum.getImageResourceId());
                startActivity(intent);
            }
        });
    }
}



