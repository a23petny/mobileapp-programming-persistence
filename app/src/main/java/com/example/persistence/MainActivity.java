package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

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
    private final String JSON_FILE = "mountains.json";

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
        editText1 = findViewById(R.id.editTextText1);
        editText2 = findViewById(R.id.editTextText2);
        editText3 = findViewById(R.id.editTextText3);

        read = findViewById(R.id.Read);

        write = findViewById(R.id.Write);
        textView = findViewById(R.id.textView1);



        //new JsonFile(this, this).execute(JSON_FILE);

    }

/*
    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", "" + json);
        Gson gson = new Gson();
        // Unmarshall JSON -> list of objects
        Type type = new TypeToken<List<Mountain>>() {
        }.getType();

        mountains = gson.fromJson(json, type);
    }*/



    public void read(View view) {

    }
    public void write(View view){
        Gson gson = new Gson();
        List<String> json = new ArrayList<>();
        json.add(""+editText1.getText());
        json.add(""+editText2.getText());
        json.add(""+editText3.getText());

        Log.d("asdasdasdasd",""+json);
        //String[] json = gson.toJson("asd");
        //Log.d("asdasdasdasd","\neditText1: "+editText1.getText()+"\neditText2: "+editText2.getText()+"\neditText3: "+editText3.getText() );
        //String json =
        //implementation com.google.andr
    }

}

