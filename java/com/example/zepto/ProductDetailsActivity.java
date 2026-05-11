package com.example.zepto;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailsActivity extends AppCompatActivity {

    Button btnAddToCart,
            btnIncrease,
            btnDecrease;

    TextView tvItemCount;

    LinearLayout cartContainer;

    ImageView imageView;

    TextView name,
            price,
            mrp,
            quantity,
            description;

    Button addToCart;

    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_product_details);



        imageView = findViewById(R.id.product_image);

        name = findViewById(R.id.product_name);

        price = findViewById(R.id.product_price);

        mrp = findViewById(R.id.product_mrp);

        quantity = findViewById(R.id.product_quantity);

        description = findViewById(R.id.product_description);

        addToCart = findViewById(R.id.btn_add_to_cart);



        // NEW FINDVIEWBYID

        btnAddToCart = findViewById(R.id.btn_add_to_cart);

        btnIncrease = findViewById(R.id.btn_increase);

        btnDecrease = findViewById(R.id.btn_decrease);

        tvItemCount = findViewById(R.id.item_count);

        cartContainer = findViewById(R.id.cart_container);



        String pname = getIntent().getStringExtra("name");

        String pprice = getIntent().getStringExtra("price");

        String pmrp = getIntent().getStringExtra("mrp");

        String pquantity = getIntent().getStringExtra("quantity");

        int image = getIntent().getIntExtra("image", 0);



        name.setText(pname);

        price.setText(pprice);

        mrp.setText(pmrp);

        quantity.setText(pquantity);



        mrp.setPaintFlags(
                mrp.getPaintFlags()
                        | Paint.STRIKE_THRU_TEXT_FLAG
        );



        imageView.setImageResource(image);



        // PRODUCT OBJECT

        product = new Product(
                pname,
                image,
                pprice,
                pmrp,
                pquantity
        );



        // ADD TO CART

        btnAddToCart.setOnClickListener(v -> {

            CartManager.getInstance()
                    .addToCart(product);

            CartManager.getInstance()
                    .saveCart(this);

            Toast.makeText(
                    ProductDetailsActivity.this,
                    "Added to Cart",
                    Toast.LENGTH_SHORT
            ).show();



            btnAddToCart.setVisibility(View.GONE);

            cartContainer.setVisibility(View.VISIBLE);

        });



        // INCREASE

        btnIncrease.setOnClickListener(v -> {

            int count = Integer.parseInt(
                    tvItemCount.getText().toString()
            );

            count++;

            tvItemCount.setText("" + count);

            CartManager.getInstance()
                    .addToCart(product);

        });



        // DECREASE

        btnDecrease.setOnClickListener(v -> {

            int count = Integer.parseInt(
                    tvItemCount.getText().toString()
            );

            if (count > 1) {

                count--;

                tvItemCount.setText("" + count);

                CartManager.cartItems.remove(product);

            } else {

                cartContainer.setVisibility(View.GONE);

                btnAddToCart.setVisibility(View.VISIBLE);

                CartManager.cartItems.remove(product);
            }

        });

    }
}