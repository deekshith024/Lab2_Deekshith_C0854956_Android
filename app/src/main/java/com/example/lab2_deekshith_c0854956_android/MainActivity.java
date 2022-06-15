package com.example.lab2_deekshith_c0854956_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DbHelper myDB;
    ArrayList<String> product_id, product_name, product_description, product_price;

    RecyclerView recyclerView;
    FloatingActionButton add_button;

    CustomAdaptor customAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener((view) -> {

                    Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                    startActivity(intent);

            });

        myDB = new DbHelper (MainActivity.this);
        product_id = new ArrayList<>();
        product_name = new ArrayList<>();
        product_description = new ArrayList<>();
        product_price =  new ArrayList<>();


        storeDataInArrays();
        customAdaptor = new CustomAdaptor(MainActivity.this, product_id, product_name, product_description, product_price);
        recyclerView.setAdapter(customAdaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    void storeDataInArrays() {

        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0) {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()) {
                product_id.add(cursor.getString(0));
                product_name.add(cursor.getString(1));
                product_description.add(cursor.getString(2));
                product_price.add(cursor.getString(3));

            }
        }
    }







}







