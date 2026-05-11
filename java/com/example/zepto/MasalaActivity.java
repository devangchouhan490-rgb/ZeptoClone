package com.example.zepto;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MasalaActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProductAdapter productAdapter;
    List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masala);

        recyclerView = findViewById(R.id.recyclerViewMasala);

        recyclerView.setLayoutManager(
                new GridLayoutManager(this, 3)
        );

        productList = new ArrayList<>();


        productList.add(new Product(
                "Almonds",
                R.drawable.almonds,
                "₹450",
                "MRP ₹520",
                "500 gm"
        ));

        productList.add(new Product(
                "Cashew",
                R.drawable.cashew,
                "₹520",
                "MRP ₹600",
                "500 gm"
        ));

        productList.add(new Product(
                "Raisins",
                R.drawable.raisins,
                "₹180",
                "MRP ₹220",
                "250 gm"
        ));

        productList.add(new Product(
                "Black Pepper",
                R.drawable.blackpepper,
                "₹90",
                "MRP ₹120",
                "100 gm"
        ));

        productList.add(new Product(
                "Turmeric Powder",
                R.drawable.turmeric,
                "₹70",
                "MRP ₹90",
                "200 gm"
        ));

        productList.add(new Product(
                "Red Chilli Powder",
                R.drawable.redchilli,
                "₹85",
                "MRP ₹110",
                "200 gm"
        ));

        productList.add(new Product(
                "Garam Masala",
                R.drawable.garammasala,
                "₹120",
                "MRP ₹150",
                "100 gm"
        ));

        productList.add(new Product(
                "Cardamom",
                R.drawable.cardamom,
                "₹250",
                "MRP ₹300",
                "100 gm"
        ));

        productList.add(new Product(
                "Pistachio",
                R.drawable.pistachio,
                "₹600",
                "MRP ₹720",
                "500 gm"
        ));

        productList.add(new Product(
                "Cloves",
                R.drawable.cloves,
                "₹140",
                "MRP ₹180",
                "100 gm"
        ));

        productAdapter = new ProductAdapter(this, productList);

        recyclerView.setAdapter(productAdapter);
    }
}