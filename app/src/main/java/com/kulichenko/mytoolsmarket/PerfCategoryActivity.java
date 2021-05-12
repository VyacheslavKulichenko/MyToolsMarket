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

public class PerfCategoryActivity extends AppCompatActivity {

    private ListView listViewPerf;

    private ArrayList<ObjectInstrums> perf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perf_category);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        perf = new ArrayList<>();
        perf.add(new ObjectInstrums(getString(R.string.perf_GRAPHITE_title), getString(R.string.perf_GRAPHITE_info), R.drawable.betonolom_graphite));
        perf.add(new ObjectInstrums(getString(R.string.perf_INTERTOOL_title), getString(R.string.perf_INTERTOOL_info), R.drawable.perforator_intertool));
        perf.add(new ObjectInstrums(getString(R.string.perf_STANLEY_title), getString(R.string.perf_STANLEY_info), R.drawable.perforator_stanley));
        listViewPerf = findViewById(R.id.listViewPerf);
        ArrayAdapter<ObjectInstrums> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, perf);
        listViewPerf.setAdapter(adapter);
        listViewPerf.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ObjectInstrums objektInstrum = perf.get(position);
                Intent intent = new Intent(getApplicationContext(), InstrumDetailActivity.class);
                intent.putExtra("title", objektInstrum.getTitle());
                intent.putExtra("info", objektInstrum.getInfo());
                intent.putExtra("resId", objektInstrum.getImageResourceId());
                startActivity(intent);
            }
        });
    }
}



