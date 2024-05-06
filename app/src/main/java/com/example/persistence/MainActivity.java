package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity { // implements JsonTask.JsonTaskListener

    private SQLiteDatabase database;
    private DatabaseHelper databaseHelper;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;


    private Button read;
    private Button write;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create
        databaseHelper = new DatabaseHelper(this);
        database = databaseHelper.getWritableDatabase();


        editText1 = findViewById(R.id.editTextText1);
        editText2 = findViewById(R.id.editTextText2);
        editText3 = findViewById(R.id.editTextText3);

        read = findViewById(R.id.Read);

        write = findViewById(R.id.Write);
        textView = findViewById(R.id.textView1);





    }
    private long addMountain(String name, int height) {
        ContentValues values = new ContentValues();
        values.put(DatabaseTables.Mountain.COLUMN_NAME_NAME, name);
        values.put(DatabaseTables.Mountain.COLUMN_NAME_HEIGHT, height);
        return database.insert(DatabaseTables.Mountain.TABLE_NAME, null, values);
    }


    public void read(View view) {

    }
    public void write(View view){
        Gson gson = new Gson();
        List<String> jsonlist = new ArrayList<>();
        jsonlist.add(""+editText1.getText());
        jsonlist.add(""+editText2.getText());
        jsonlist.add(""+editText3.getText());


        String json = gson.toJson(jsonlist);
        Log.d("asdasdasdasd",""+json);
    }

}

