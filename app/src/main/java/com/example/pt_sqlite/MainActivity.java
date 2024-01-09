package com.example.pt_sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     ListView listView;
    mySQLite  sql = new mySQLite(this);
     Button button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Recharch");
        Toolbar toolbar1 = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar1);
       listView = findViewById(R.id.listview);
       button = findViewById(R.id.button);
        ArrayList<String> listdata= sql.getvetements();
        ArrayAdapter adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,listdata);
        listView.setAdapter(adapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String selectedMenu = listdata.get(position);
//                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
//                intent.putExtra("key", selectedMenu);
//                startActivity(intent);
//            }
//        });
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
               startActivity(intent);
           }
       });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menurecharech, menu);
        MenuItem menuItem =menu.findItem(R.id.app_bar_recharche);
        SearchView searchView =(SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<String> listrecharche= sql.Recharche(newText);
                ArrayAdapter adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,listrecharche);
                listView.setAdapter(adapter);
                return true;
            }
        });
        return true;
    }

}