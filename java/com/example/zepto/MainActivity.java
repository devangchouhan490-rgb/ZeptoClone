package com.example.zepto;

import android.Manifest;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText phoneInput;

    public Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        // NOTIFICATION PERMISSION

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
        ) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.POST_NOTIFICATIONS},
                    101
            );

        } else {

            NotificationHelper.showNotification(this);
        }



        phoneInput = findViewById(R.id.phoneInput);

        continueButton = findViewById(R.id.continueButton);



        // TERMS TEXT

        TextView termsText = findViewById(R.id.termText);

        String fullText =
                "By continuing, you agree to our \n Terms of Use & Privacy Policy";

        SpannableString spannable =
                new SpannableString(fullText);



        spannable.setSpan(
                new ForegroundColorSpan(
                        Color.parseColor("#FF7050")
                ),
                32,
                fullText.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        termsText.setText(spannable);




        // BUTTON CLICK

        continueButton.setOnClickListener(v -> {

            String phoneNumber =
                    phoneInput.getText()
                            .toString()
                            .trim();



            // EMPTY CHECK

            if (phoneNumber.isEmpty()) {

                phoneInput.setError(
                        "Enter Mobile Number"
                );

                return;
            }



            // EXACT 10 DIGIT CHECK

            if (!phoneNumber.matches("^[6-9][0-9]{9}$")) {

                phoneInput.setError(
                        "Enter Valid 10 Digit Mobile Number"
                );

                return;
            }



            // SAME DIGITS CHECK

            char first = phoneNumber.charAt(0);

            boolean same = true;

            for (int i = 1; i < phoneNumber.length(); i++) {

                if (phoneNumber.charAt(i) != first) {

                    same = false;

                    break;
                }
            }



            if (same) {

                phoneInput.setError(
                        "Invalid Mobile Number"
                );

                return;
            }



            // VALID NUMBER

            Toast.makeText(
                    MainActivity.this,
                    "Phone number entered: " + phoneNumber,
                    Toast.LENGTH_SHORT
            ).show();



            Intent intent =
                    new Intent(
                            MainActivity.this,
                            ProductPage.class
                    );

            intent.putExtra(
                    "phone_number",
                    phoneNumber
            );

            startActivity(intent);

        });

    }



    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            String[] permissions,
            int[] grantResults
    ) {

        super.onRequestPermissionsResult(
                requestCode,
                permissions,
                grantResults
        );

        if (requestCode == 101) {

            if (grantResults.length > 0
                    && grantResults[0]
                    == PackageManager.PERMISSION_GRANTED) {

                NotificationHelper.showNotification(this);
            }
        }
    }
}