package com.example.pt_sqlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
   EditText editText1 ,editText2 ;
   Button button ;
    mySQLite  sql = new mySQLite(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setTitle("pageAjouter");
        setContentView(R.layout.activity_main2);
        editText1 = findViewById(R.id.editTextText1);
        editText2= findViewById(R.id.editTextText2);
        Toolbar toolbar1 = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.app_bar_seve) {

            String Article = editText1.getText().toString();
            String Prix = editText2.getText().toString();
            boolean resulte = sql.Ajouter(Article,Prix);
            if (resulte== true) {
                Toast.makeText(MainActivity2.this, "Ajouer", Toast.LENGTH_SHORT).show();
                editText1.setText("");
                editText2.setText("");

            }
            return true;
        }
        if (itemId == R.id.app_bar_retun) {
            Intent intent = new Intent( getApplicationContext(),MainActivity.class);
            startActivity(intent);
            return  true;
        }

        else {
            return super.onOptionsItemSelected(item);
        }
    }
}