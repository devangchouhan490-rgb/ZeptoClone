package com.example.zepto;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {


    private Context mContext;
    private List<Product> mProductList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.mContext = context;
        this.mProductList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.product_item, parent, false);

        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        Product product = mProductList.get(position);

        holder.tvProductName.setText(product.getName());
        holder.tvProductPrice.setText(product.getPrice());
        holder.tvProductMrp.setText(product.getMrp());

        holder.tvProductMrp.setPaintFlags(
                holder.tvProductMrp.getPaintFlags()
                        | Paint.STRIKE_THRU_TEXT_FLAG
        );

        holder.tvQuantity.setText(product.getQuantity());

        holder.imageView.setImageResource(product.getImageResId());



        // PRODUCT CLICK → DETAILS PAGE

        holder.imageView.setOnClickListener(v -> {

            Intent intent = new Intent(
                    mContext,
                    ProductDetailsActivity.class
            );

            intent.putExtra("name", product.getName());
            intent.putExtra("price", product.getPrice());
            intent.putExtra("mrp", product.getMrp());
            intent.putExtra("quantity", product.getQuantity());
            intent.putExtra("image", product.getImageResId());

            mContext.startActivity(intent);

        });


        // ADD TO CART

        holder.btnAddToCart.setOnClickListener(v -> {
            holder.btnAddToCart.setClickable(false);
            //CartManager.cartItems.add(product);
            CartManager.getInstance()
                    .addToCart(product);

            Toast.makeText(
                    mContext,
                    "Added To Cart",
                    Toast.LENGTH_SHORT
            ).show();

            holder.btnAddToCart.setVisibility(View.GONE);

            holder.cartContainer.setVisibility(View.VISIBLE);

        });



        // INCREASE ITEM

        holder.btnIncrease.setOnClickListener(v -> {

            String current =
                    holder.tvItemCount
                            .getText()
                            .toString();

            int count = Integer.parseInt(current);

            count = count + 1;

            holder.tvItemCount.setText(
                    "" + count
            );

            CartManager.getInstance()
                    .cartItems
                    .add(product);

        });



        // DECREASE ITEM

        holder.btnDecrease.setOnClickListener(v -> {

            String current =
                    holder.tvItemCount
                            .getText()
                            .toString();

            int count = Integer.parseInt(current);

            if (count > 1) {

                count = count - 1;

                holder.tvItemCount.setText(
                        "" + count
                );

                CartManager.getInstance()
                        .cartItems
                        .remove(product);

            } else {

                holder.cartContainer
                        .setVisibility(View.GONE);

                holder.btnAddToCart
                        .setVisibility(View.VISIBLE);

                CartManager.getInstance()
                        .cartItems
                        .remove(product);
            }

        });

    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView tvProductName,
                tvProductPrice,
                tvProductMrp,
                tvQuantity,
                tvItemCount;

        ImageView imageView;

        Button btnAddToCart,
                btnIncrease,
                btnDecrease;

        LinearLayout cartContainer;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            tvProductName = itemView.findViewById(R.id.product_name);

            tvProductPrice = itemView.findViewById(R.id.product_price);

            tvProductMrp = itemView.findViewById(R.id.product_mrp);

            tvQuantity = itemView.findViewById(R.id.quantity);

            imageView = itemView.findViewById(R.id.product_image);

            btnAddToCart = itemView.findViewById(R.id.add_to_cart);

            btnIncrease = itemView.findViewById(R.id.btn_increase);

            btnDecrease = itemView.findViewById(R.id.btn_decrease);

            tvItemCount = itemView.findViewById(R.id.item_count);

            cartContainer = itemView.findViewById(R.id.cart_container);
        }
    }
}