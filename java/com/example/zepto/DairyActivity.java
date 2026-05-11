package com.example.zepto;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DairyActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProductAdapter productAdapter;
    List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy);

        recyclerView = findViewById(R.id.recyclerViewDairy);

        recyclerView.setLayoutManager(
                new GridLayoutManager(this, 3)
        );

        productList = new ArrayList<>();


        productList.add(new Product(
                "Amul Milk",
                R.drawable.amul_milk,
                "₹28",
                "MRP ₹35",
                "500 ml"
        ));

        productList.add(new Product(
                "Amul Butter",
                R.drawable.amul_butter,
                "₹60",
                "MRP ₹90",
                "50 gm"
        ));

        productList.add(new Product(
                "Bread",
                R.drawable.bread,
                "₹40",
                "MRP ₹50",
                "1 Pack"
        ));

        productList.add(new Product(
                "Eggs",
                R.drawable.eggs,
                "₹75",
                "MRP ₹90",
                "12 pcs"
        ));

        productList.add(new Product(
                "Cheese",
                R.drawable.cheese,
                "₹120",
                "MRP ₹150",
                "200 gm"
        ));

        productList.add(new Product(
                "Paneer",
                R.drawable.paneer,
                "₹90",
                "MRP ₹110",
                "250 gm"
        ));

        productList.add(new Product(
                "Curd",
                R.drawable.curd,
                "₹35",
                "MRP ₹45",
                "400 gm"
        ));

        productList.add(new Product(
                "Brown Bread",
                R.drawable.bread,
                "₹50",
                "MRP ₹65",
                "1 Pack"
        ));

        productList.add(new Product(
                "Chocolate Milk",
                R.drawable.amul_milk,
                "₹40",
                "MRP ₹55",
                "180 ml"
        ));

        productList.add(new Product(
                "Greek Yogurt",
                R.drawable.yogurt,
                "₹80",
                "MRP ₹100",
                "250 gm"
        ));

        productAdapter = new ProductAdapter(this, productList);

        recyclerView.setAdapter(productAdapter);
    }
}