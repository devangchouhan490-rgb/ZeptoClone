package com.example.zepto;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    public static ArrayList<Product> cartItems = new ArrayList<>();

    private static CartManager instance;

    private CartManager() {

        if (cartItems == null) {

            cartItems = new ArrayList<>();
        }
    }


    public static synchronized CartManager getInstance() {

        if (instance == null) {

            instance = new CartManager();
        }

        return instance;
    }



    // ADD ITEM

    public void addToCart(Product product) {

        cartItems.add(product);
    }



    // REMOVE ITEM

    public void removeFromCart(
            Product product,
            Context context
    ) {

        cartItems.remove(product);

        saveCart(context);
    }



    // GET ITEMS

    public List<Product> getCartItems() {
        return cartItems;
    }



    // CLEAR CART

    public void clearCart() {

        cartItems.clear();
    }



    // SAVE CART

    public void saveCart(Context context) {

        SharedPreferences preferences =
                context.getSharedPreferences(
                        "CartData",
                        Context.MODE_PRIVATE
                );

        SharedPreferences.Editor editor =
                preferences.edit();

        JSONArray jsonArray = new JSONArray();

        try {

            for (Product product : cartItems) {

                JSONObject object = new JSONObject();

                object.put(
                        "name",
                        product.getName()
                );

                object.put(
                        "price",
                        product.getPrice()
                );

                object.put(
                        "mrp",
                        product.getMrp()
                );

                object.put(
                        "quantity",
                        product.getQuantity()
                );

                object.put(
                        "image",
                        product.getImageResId()
                );

                jsonArray.put(object);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        editor.putString(
                "cart_items",
                jsonArray.toString()
        );

        editor.apply();
    }



    // LOAD CART

    public void loadCart(Context context) {

        SharedPreferences preferences =
                context.getSharedPreferences(
                        "CartData",
                        Context.MODE_PRIVATE
                );

        String data =
                preferences.getString(
                        "cart_items",
                        ""
                );

        cartItems.clear();

        try {

            JSONArray jsonArray =
                    new JSONArray(data);

            for (int i = 0;
                 i < jsonArray.length();
                 i++) {

                JSONObject object =
                        jsonArray.getJSONObject(i);

                Product product = new Product(

                        object.getString("name"),

                        object.getInt("image"),

                        object.getString("price"),

                        object.getString("mrp"),

                        object.getString("quantity")
                );

                cartItems.add(product);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}