package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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

    }

    public void read(View view) {

    }
    public void write(View view) {
        //String[] json = gson.toJson(new String[]{editText1.getText(),editText2.getText(),editText3.getText()};
        //Log.d("asdasdasdasd","\neditText1: "+editText1.getText()+"\neditText2: "+editText2.getText()+"\neditText3: "+editText3.getText() );
        //String json =
    }

}

