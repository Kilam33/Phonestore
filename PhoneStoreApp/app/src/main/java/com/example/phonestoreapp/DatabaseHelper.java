package com.example.phonestoreapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "phonestore.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUsersTable = "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT)";
        String createProductsTable = "CREATE TABLE products (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, description TEXT, price REAL, image_url TEXT, whatsapp_contact TEXT, phone_contact TEXT)";
        db.execSQL(createUsersTable);
        db.execSQL(createProductsTable);

        // Insert sample products
        db.execSQL("INSERT INTO products (name, description, price, image_url, whatsapp_contact, phone_contact) VALUES ('Phone 1', 'Description 1', 100.0, 'https://example.com/image1.jpg', '1234567890', '0987654321')");
        db.execSQL("INSERT INTO products (name, description, price, image_url, whatsapp_contact, phone_contact) VALUES ('Phone 2', 'Description 2', 200.0, 'https://example.com/image2.jpg', '1234567891', '0987654322')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS products");
        onCreate(db);
    }
}
