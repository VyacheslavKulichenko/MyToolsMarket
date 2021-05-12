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

public class DrillCategoryActivity extends AppCompatActivity {

    private ListView listViewDrills;

    private ArrayList<ObjectInstrums> drills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_category);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        drills = new ArrayList<>();
        drills.add(new ObjectInstrums(getString(R.string.drill_interskol_title), getString(R.string.drill_interskol_info), R.drawable.interskol));
        drills.add(new ObjectInstrums(getString(R.string.drill_makita_title), getString(R.string.drill_makita_info), R.drawable.makita));
        drills.add(new ObjectInstrums(getString(R.string.drill_dewalt_title), getString(R.string.drill_dewalt_info), R.drawable.dewalt));
        listViewDrills = findViewById(R.id.listViewDrill);
        ArrayAdapter<ObjectInstrums> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, drills);
        listViewDrills.setAdapter(adapter);
        listViewDrills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ObjectInstrums objektInstrum = drills.get(position);
                Intent intent = new Intent(getApplicationContext(), InstrumDetailActivity.class);
                intent.putExtra("title", objektInstrum.getTitle());
                intent.putExtra("info", objektInstrum.getInfo());
                intent.putExtra("resId", objektInstrum.getImageResourceId());
                startActivity(intent);
            }
        });
    }
}



