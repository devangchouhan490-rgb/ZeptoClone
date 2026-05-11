package com.example.zepto;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView tvTotalPrice;
    private Button btnCheckout;
    private CartAdapter cartAdapter;
    private List<Product> cartItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.cart_list);
        tvTotalPrice = findViewById(R.id.total_price);
        btnCheckout = findViewById(R.id.btn_checkout);

        cartItems = CartManager.cartItems;

        Toast.makeText(
                this,
                "Cart Size = " + cartItems.size(),
                Toast.LENGTH_LONG
        ).show();

        cartAdapter = new CartAdapter(this, cartItems);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cartAdapter);

        calculateTotal();

        btnCheckout.setOnClickListener(v -> {

            if (cartItems.isEmpty()) {

                tvTotalPrice.setText("Your cart is empty. Add products to continue.");

            } else {

                Intent intent = new Intent(
                        CartActivity.this,
                        PaymentActivity.class
                );
                startActivity(intent);
            }
        });
    }

    private int calculateTotal() {

        int total = 0;

        for (Product product : cartItems) {
            total += Integer.parseInt(product.getPrice().replace("₹", ""));
        }

        tvTotalPrice.setText("Total: ₹" + total);

        return total;
    }
}