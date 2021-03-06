package com.example.lab2_deekshith_c0854956_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProductActivity extends AppCompatActivity {

    EditText name_input, description_input, price_input;
    Button add_button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        name_input = findViewById(R.id. name_input);
        description_input = findViewById(R.id. description_input);
        price_input = findViewById(R.id. price_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                DbHelper myDB = new DbHelper(ProductActivity.this);
                myDB.addProduct(name_input.getText().toString().trim(),
                        description_input.getText().toString().trim(),
                      Integer.valueOf(price_input.getText().toString().trim()));

            }
        });





    }
}