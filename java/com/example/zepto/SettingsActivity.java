package com.example.zepto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    LinearLayout ordersLayout;

    EditText addressInput;

    Button saveAddressBtn, deleteAddressBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ordersLayout = findViewById(R.id.ordersLayout);

        addressInput = findViewById(R.id.addressInput);

        saveAddressBtn = findViewById(R.id.saveAddressBtn);

        deleteAddressBtn = findViewById(R.id.deleteAddressBtn);



        // OPEN ORDERS

        ordersLayout.setOnClickListener(v -> {

            Intent intent = new Intent(
                    SettingsActivity.this,
                    OrdersActivity.class
            );

            startActivity(intent);

        });



        // SHARED PREFERENCES

        SharedPreferences preferences =
                getSharedPreferences("AddressData", MODE_PRIVATE);



        // LOAD SAVED ADDRESS

        addressInput.setText(
                preferences.getString("address", "")
        );



        // SAVE ADDRESS

        saveAddressBtn.setOnClickListener(v -> {

            SharedPreferences.Editor editor =
                    preferences.edit();

            editor.putString(
                    "address",
                    addressInput.getText().toString()
            );

            editor.apply();

            Toast.makeText(
                    SettingsActivity.this,
                    "Address Saved",
                    Toast.LENGTH_SHORT
            ).show();

        });



        // DELETE ADDRESS

        deleteAddressBtn.setOnClickListener(v -> {

            SharedPreferences.Editor editor =
                    preferences.edit();

            editor.remove("address");

            editor.apply();

            addressInput.setText("");

            Toast.makeText(
                    SettingsActivity.this,
                    "Address Deleted",
                    Toast.LENGTH_SHORT
            ).show();

        });

    }
}