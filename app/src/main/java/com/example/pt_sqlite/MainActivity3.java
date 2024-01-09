//package com.example.pt_sqlite;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//
//import java.util.ArrayList;
//
//public class MainActivity3 extends AppCompatActivity {
// EditText editText1 ,editText2;
// mySQLite  sql = new mySQLite(this);
// Button button;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main3);
//        editText1 = findViewById(R.id.editTextModification1);
//        editText2= findViewById(R.id.editTextModification2);
//        button = findViewById(R.id.button3);
//        Intent intent = getIntent();
//        if (intent.hasExtra("key")) {
//            String selectedMenu = (String) intent.getSerializableExtra("key");
//            editText1.setText(selectedMenu);
//            editText1.setText("");
//
//        }
//
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String name = editText1.getText().toString();
//                String prix =editText2.getText().toString();
//                ArrayList<String> listrecharche= sql.modification(Integer.parseInt(name),prix);
////                ArrayAdapter adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,listrecharche);
//                Intent intent = new Intent( getApplicationContext(), MainActivity.class);
//                startActivity(intent);
//
//            }
//        });
//    }
//}