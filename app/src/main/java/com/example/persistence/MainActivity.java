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

public class MainActivity extends AppCompatActivity {


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

        databaseTables.databaseHelper = new DatabaseHelper(this);
        databaseTables.database = databaseTables.databaseHelper.getWritableDatabase();



        editText1 = findViewById(R.id.flavour_of_ball_1);
        editText2 = findViewById(R.id.flavour_of_ball_2);
        editText3 = findViewById(R.id.flavour_of_ball_3);
        editText4 = findViewById(R.id.size);

        read = findViewById(R.id.Read);

        write = findViewById(R.id.Write);
        textView = findViewById(R.id.textView1);

        // for start with percistance you can remove the bracekets of this
        //read(this.getCurrentFocus());

    }



    public void read(View view) {

        List<DatabaseTables.Icecream> icecreams = databaseTables.getIcecreams();
        DatabaseTables.Icecream icecream = icecreams.get(0);

        String order = "Your Order:\nflavour of ball 1: " + icecream.fob1 + "\nflavour of ball 2: " + icecream.fob2+ "\nflavour of ball 3: " + icecream.fob3+ "\nsize of cone: " + icecream.size+ " cm";

        textView.setText(order);
    }
    public void write(View view){

        List<DatabaseTables.Icecream> icecreams = databaseTables.getIcecreams();
        for (DatabaseTables.Icecream icecream : icecreams){
            databaseTables.deletIceream(icecream.id);
        }

        String flavour_of_ball_1 = editText1.getText().toString();
        String flavour_of_ball_2 = editText2.getText().toString();
        String flavour_of_ball_3 = editText3.getText().toString();
        int size = Integer.valueOf(editText4.getText().toString());

        databaseTables.addIcecream(flavour_of_ball_1,flavour_of_ball_2,flavour_of_ball_3, size);

    }
}

