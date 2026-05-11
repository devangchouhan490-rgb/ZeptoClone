package com.example.zepto;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FruitsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProductAdapter productAdapter;
    List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);

        recyclerView = findViewById(R.id.recyclerViewFruits);

        recyclerView.setLayoutManager(
                new GridLayoutManager(this, 3)
        );

        productList = new ArrayList<>();


        productList.add(new Product(
                "Apple",
                R.drawable.apple,
                "₹120",
                "MRP ₹150",
                "1 Kg"
        ));

        productList.add(new Product(
                "Tomato",
                R.drawable.tomato,
                "₹40",
                "MRP ₹55",
                "1 Kg"
        ));

        productList.add(new Product(
                "Potato",
                R.drawable.potato,
                "₹35",
                "MRP ₹50",
                "1 Kg"
        ));

        productList.add(new Product(
                "Onion",
                R.drawable.onion,
                "₹83",
                "MRP ₹111",
                "1 Kg"
        ));
        productList.add(new Product(
                "Banana",
                R.drawable.banana,
                "₹50",
                "MRP ₹70",
                "12 pcs"
        ));

        productList.add(new Product(
                "Orange",
                R.drawable.orange,
                "₹80",
                "MRP ₹100",
                "1 Kg"
        ));

        productList.add(new Product(
                "Mango",
                R.drawable.mango,
                "₹120",
                "MRP ₹150",
                "1 Kg"
        ));

        productList.add(new Product(
                "Papaya",
                R.drawable.papaya,
                "₹60",
                "MRP ₹80",
                "1 Piece"
        ));

        productList.add(new Product(
                "Watermelon",
                R.drawable.watermelon,
                "₹90",
                "MRP ₹120",
                "1 Piece"
        ));

        productList.add(new Product(
                "Grapes",
                R.drawable.grapes,
                "₹70",
                "MRP ₹95",
                "500 gm"
        ));

        productList.add(new Product(
                "Pineapple",
                R.drawable.pineapple,
                "₹85",
                "MRP ₹110",
                "1 Piece"
        ));

        productList.add(new Product(
                "Carrot",
                R.drawable.carrot,
                "₹40",
                "MRP ₹55",
                "1 Kg"
        ));

        productList.add(new Product(
                "Cabbage",
                R.drawable.cabbage,
                "₹35",
                "MRP ₹50",
                "1 Piece"
        ));

        productList.add(new Product(
                "Cauliflower",
                R.drawable.cauliflower,
                "₹45",
                "MRP ₹60",
                "1 Piece"
        ));

        productList.add(new Product(
                "Brinjal",
                R.drawable.brinjal,
                "₹55",
                "MRP ₹75",
                "1 Kg"
        ));

        productList.add(new Product(
                "Green Chilli",
                R.drawable.greenchilli,
                "₹20",
                "MRP ₹30",
                "250 gm"
        ));

        productList.add(new Product(
                "Capsicum",
                R.drawable.capsicum,
                "₹65",
                "MRP ₹90",
                "500 gm"
        ));

        productList.add(new Product(
                "Beetroot",
                R.drawable.beetroot,
                "₹40",
                "MRP ₹60",
                "1 Kg"
        ));

        productList.add(new Product(
                "Cucumber",
                R.drawable.cucumber,
                "₹30",
                "MRP ₹45",
                "1 Kg"
        ));

        productAdapter = new ProductAdapter(this, productList);

        recyclerView.setAdapter(productAdapter);
    }
}