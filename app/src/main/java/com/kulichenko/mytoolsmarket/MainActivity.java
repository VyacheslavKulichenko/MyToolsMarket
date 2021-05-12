package com.kulichenko.mytoolsmarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView listViewTools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        listViewTools = findViewById(R.id.listViewTools);
        listViewTools.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent0 = new Intent(getApplicationContext(), DrillCategoryActivity.class);
                        startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getApplicationContext(), PerfCategoryActivity.class);
                        startActivity(intent1);
                        break;

                    case 2:
                        Intent intent2 = new Intent(getApplicationContext(), BolgarCategoryActivity.class);
                        startActivity(intent2);
                        break;

                    case 3:
                        Intent intent3 = new Intent(getApplicationContext(), PilCategoryActivity.class);
                        startActivity(intent3);
                        break;

                    case 4:
                        Intent intent4 = new Intent(getApplicationContext(), ShlifmashCategoryActivity.class);
                        startActivity(intent4);
                        break;

                    case 5:
                        Intent intent5 = new Intent(getApplicationContext(), RubanCategoryActivity.class);
                        startActivity(intent5);
                        break;

                    case 6:
                        Intent intent6 = new Intent(getApplicationContext(), FenCategoryActivity.class);
                        startActivity(intent6);
                        break;
                }
            }
        });
    }
}