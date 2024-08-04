package com.example.phonestoreapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    private ListView productListView;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        productListView = findViewById(R.id.product_list);
        dbHelper = new DatabaseHelper(this);

        loadProducts();
    }

    private void loadProducts() {
        List<Product> products = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("products", null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String description = cursor.getString(cursor.getColumnIndex("description"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));
                String imageUrl = cursor.getString(cursor.getColumnIndex("image_url"));
                String whatsappContact = cursor.getString(cursor.getColumnIndex("whatsapp_contact"));
                String phoneContact = cursor.getString(cursor.getColumnIndex("phone_contact"));
                products.add(new Product(id, name, description, price, imageUrl, whatsappContact, phoneContact));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        ProductAdapter adapter = new ProductAdapter(this, products);
        productListView.setAdapter(adapter);

        productListView.setOnItemClickListener((parent, view, position, id) -> {
            Product product = products.get(position);
            Intent intent = new Intent(ProductListActivity.this, ProductDetailActivity.class);
            intent.putExtra("product", product);
            startActivity(intent);
        });
    }
}
