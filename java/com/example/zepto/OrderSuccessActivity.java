package com.example.zepto;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OrderSuccessActivity extends AppCompatActivity {

    Button backHomeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success);

        backHomeBtn = findViewById(R.id.backHomeBtn);

        backHomeBtn.setOnClickListener(v -> {

            Intent intent = new Intent(
                    OrderSuccessActivity.this,
                    ProductPage.class
            );

            intent.addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP
            );

            startActivity(intent);

            finish();

        });
    }
}