package com.example.mobilerattrapage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;

import com.example.mobilerattrapage.adapter.ProductAdapter;
import com.example.mobilerattrapage.model.Product;

import java.util.ArrayList;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter; // Assurez-vous que vous avez importé le bon package pour ProductAdapter
    private List<Product> productList; // Assurez-vous que vous avez importé le bon package pour Product

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configure the button to start DetailActivity
        Button viewDetailsButton = findViewById(R.id.viewDetailsButton);
        viewDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });

        // Configure the RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        productList = new ArrayList<>(); // Populate this list with your products
        Product product1 = new Product("Nom du produit 1", 19.99);
        Product product2 = new Product("Nom du produit 2", 29.99);

        productList.add(product1);
        productList.add(product2);

        productAdapter = new ProductAdapter(productList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(productAdapter);
    }
}