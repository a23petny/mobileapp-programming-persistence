package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity { // implements JsonTask.JsonTaskListener


    private DatabaseTables databaseTables;

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;


    private Button read;
    private Button write;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseTables = new DatabaseTables();

        // Create
        databaseTables.databaseHelper = new DatabaseHelper(this);
        // databaseTables

        databaseTables.database = databaseTables.databaseHelper.getWritableDatabase();

        //databaseTables.databaseHelper.onCreate(databaseTables.database);

        editText1 = findViewById(R.id.flavour_of_ball_1);
        editText2 = findViewById(R.id.flavour_of_ball_2);
        editText3 = findViewById(R.id.flavour_of_ball_3);
        editText4 = findViewById(R.id.size);

        read = findViewById(R.id.Read);

        write = findViewById(R.id.Write);
        textView = findViewById(R.id.textView1);





    }



    public void read(View view) {
        List<DatabaseTables.Mountain> mountains = databaseTables.getMountains();


        for (DatabaseTables.Mountain mountain : mountains){
            databaseTables.deleteMountain(mountain.id);
        }
    }
    public void write(View view){

        List<DatabaseTables.Mountain> mountains = databaseTables.getMountains();
        for (DatabaseTables.Mountain mountain : mountains){
            databaseTables.deleteMountain(mountain.id);
        }

        String flavour_of_ball_1 = editText1.getText().toString();
        String flavour_of_ball_2 = editText2.getText().toString();
        String flavour_of_ball_3 = editText3.getText().toString();
        int size = Integer.valueOf(editText4.getText().toString());

        databaseTables.addMountain(flavour_of_ball_1, 1);

        //String json = gson.toJson(jsonlist);
        //Log.d("asdasdasdasd",""+json);*/
        // "CREATE TABLE mountain (id INTEGER PRIMARY KEY, name TEXT, height INT)"

    }

}

