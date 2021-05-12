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

public class RubanCategoryActivity extends AppCompatActivity {

    private ListView listViewRubanok;

    private ArrayList<ObjectInstrums> ruban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruban_category);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        ruban = new ArrayList<>();
        ruban.add(new ObjectInstrums(getString(R.string.rubanok_INTERTOOL_title), getString(R.string.rubanok_INTERTOOL_info), R.drawable.rubanok_mastertool));
        ruban.add(new ObjectInstrums(getString(R.string.rubanok_STANLEY_title), getString(R.string.rubanok_STANLEY_info), R.drawable.rubanok_stanley));
        ruban.add(new ObjectInstrums(getString(R.string.rubanok_VERTO_title), getString(R.string.rubanok_VERTO_info), R.drawable.rubanok_verto));
        listViewRubanok = findViewById(R.id.listViewRubaok);
        ArrayAdapter<ObjectInstrums> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, ruban);
        listViewRubanok.setAdapter(adapter);
        listViewRubanok.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ObjectInstrums objektInstrum = ruban.get(position);
                Intent intent = new Intent(getApplicationContext(), InstrumDetailActivity.class);
                intent.putExtra("title", objektInstrum.getTitle());
                intent.putExtra("info", objektInstrum.getInfo());
                intent.putExtra("resId", objektInstrum.getImageResourceId());
                startActivity(intent);
            }
        });
    }
}



