package com.example.zepto;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    ArrayList<Order> list;

    public OrderAdapter(ArrayList<Order> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Order order = list.get(position);

        holder.name.setText(order.getName());
        holder.status.setText(order.getStatus());
        holder.image.setImageResource(order.getImage());

        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(v.getContext(), ProductDetailsActivity.class);

            intent.putExtra("name", order.getName());
            intent.putExtra("price", "₹50");
            intent.putExtra("mrp", "₹80");
            intent.putExtra("quantity", "1 Kg");
            intent.putExtra("image", order.getImage());

            v.getContext().startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name, status;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.orderImage);
            name = itemView.findViewById(R.id.orderName);
            status = itemView.findViewById(R.id.orderStatus);
        }
    }
}