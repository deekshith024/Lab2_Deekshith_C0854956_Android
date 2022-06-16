package com.example.lab2_deekshith_c0854956_android;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private Context context;
    public static final String DATABASE_NAME = "ProductList.db";
    public static final int DATABASE_VERSION = 1;

    private static final  String TABLE_NAME = "list_Products";
    private static final  String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final  String COLUMN_PRICE = "price";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        this.context = context;


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " +  TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME + " TEXT, " +
                        COLUMN_DESCRIPTION + " TEXT, " +
                        COLUMN_PRICE + " INTEGER); ";
        db.execSQL((query));


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate((db));

    }


    void addProduct(String name, String description, int price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put (COLUMN_NAME, name);
        cv.put (COLUMN_DESCRIPTION, description);
        cv.put (COLUMN_PRICE, price);
        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1) {

            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added successfully", Toast.LENGTH_SHORT).show();
        }

    }

    Cursor readAllData() {

        String query = "SELECT  *  FROM " + TABLE_NAME ;
        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursor = null;
        if (db != null) {

           cursor = db.rawQuery(query, null);
        }

        return cursor;
    }

}




















