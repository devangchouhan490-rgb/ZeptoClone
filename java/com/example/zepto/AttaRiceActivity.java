package com.example.zepto;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AttaRiceActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProductAdapter productAdapter;
    List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atta_rice);

        recyclerView = findViewById(R.id.recyclerViewAttaRice);

        recyclerView.setLayoutManager(
                new GridLayoutManager(this, 3)
        );

        productList = new ArrayList<>();


        productList.add(new Product(
                "Aashirvaad Atta",
                R.drawable.ata,
                "₹320",
                "MRP ₹380",
                "5 Kg"
        ));

        productList.add(new Product(
                "Basmati Rice",
                R.drawable.rice,
                "₹450",
                "MRP ₹520",
                "5 Kg"
        ));

        productList.add(new Product(
                "Fortune Oil",
                R.drawable.fortune,
                "₹156",
                "MRP ₹190",
                "1 L"
        ));

        productList.add(new Product(
                "Toor Dal",
                R.drawable.dal,
                "₹140",
                "MRP ₹170",
                "1 Kg"
        ));

        productList.add(new Product(
                "Moong Dal",
                R.drawable.moongdal,
                "₹130",
                "MRP ₹160",
                "1 Kg"
        ));

        productList.add(new Product(
                "Chana Dal",
                R.drawable.chanadal,
                "₹120",
                "MRP ₹145",
                "1 Kg"
        ));

        productList.add(new Product(
                "Sugar",
                R.drawable.sugar,
                "₹55",
                "MRP ₹70",
                "1 Kg"
        ));

        productList.add(new Product(
                "Salt",
                R.drawable.salt,
                "₹25",
                "MRP ₹35",
                "1 Kg"
        ));

        productList.add(new Product(
                "Besan",
                R.drawable.besan,
                "₹90",
                "MRP ₹110",
                "1 Kg"
        ));

        productList.add(new Product(
                "Poha",
                R.drawable.poha,
                "₹70",
                "MRP ₹90",
                "1 Kg"
        ));

        productAdapter = new ProductAdapter(this, productList);

        recyclerView.setAdapter(productAdapter);
    }
}