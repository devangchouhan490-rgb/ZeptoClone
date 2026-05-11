package com.example.zepto;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrdersActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        recyclerView = findViewById(R.id.ordersRecycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Order> list = new ArrayList<>();

        list.add(new Order("Amul Milk", "Delivered", R.mipmap.ic_launcher));

        list.add(new Order("Bread", "Shipped", R.mipmap.ic_launcher));

        OrderAdapter adapter = new OrderAdapter(list);

        recyclerView.setAdapter(adapter);
    }
}