package com.example.zepto;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SnacksActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProductAdapter productAdapter;
    List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);

        recyclerView = findViewById(R.id.recyclerViewSnacks);

        recyclerView.setLayoutManager(
                new GridLayoutManager(this, 3)
        );

        productList = new ArrayList<>();


        productList.add(new Product(
                "Lay's Chips",
                R.drawable.lays,
                "₹20",
                "MRP ₹25",
                "52 gm"
        ));

        productList.add(new Product(
                "Maggi",
                R.drawable.maggi,
                "₹14",
                "MRP ₹18",
                "1 Pack"
        ));
        productList.add(new Product(
                "Oreo Biscuit",
                R.drawable.oreo,
                "₹30",
                "MRP ₹40",
                "120 gm"
        ));

        productList.add(new Product(
                "KitKat",
                R.drawable.kitkat,
                "₹25",
                "MRP ₹35",
                "1 Pack"
        ));

        productList.add(new Product(
                "Perk Chocolate",
                R.drawable.perk,
                "₹15",
                "MRP ₹20",
                "1 Pack"
        ));

        productList.add(new Product(
                "Hide & Seek",
                R.drawable.hideandseek,
                "₹40",
                "MRP ₹50",
                "200 gm"
        ));

        productList.add(new Product(
                "Nachos",
                R.drawable.nachos,
                "₹50",
                "MRP ₹65",
                "150 gm"
        ));

        productList.add(new Product(
                "Popcorn",
                R.drawable.popcorn,
                "₹60",
                "MRP ₹80",
                "250 gm"
        ));

        productList.add(new Product(
                "Choco Pie",
                R.drawable.chocopie,
                "₹120",
                "MRP ₹150",
                "6 pcs"
        ));

        productList.add(new Product(
                "Pringles",
                R.drawable.pringles,
                "₹110",
                "MRP ₹140",
                "110 gm"
        ));

        productList.add(new Product(
                "Munch",
                R.drawable.munch,
                "₹20",
                "MRP ₹25",
                "1 Pack"
        ));

        productList.add(new Product(
                "Good Day Biscuit",
                R.drawable.goodday,
                "₹35",
                "MRP ₹45",
                "150 gm"
        ));

        productList.add(new Product(
                "Dairy Milk",
                R.drawable.dairymilk,
                "₹45",
                "MRP ₹50",
                "100 gm"
        ));

        productAdapter = new ProductAdapter(this, productList);

        recyclerView.setAdapter(productAdapter);
    }
}