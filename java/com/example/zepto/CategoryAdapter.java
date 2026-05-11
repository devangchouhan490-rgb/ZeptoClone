package com.example.zepto;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryAdapter
        extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private Context context;
    private List<Category> categoryList;

    public CategoryAdapter(
            Context context,
            List<Category> categoryList
    ) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType
    ) {

        View view = LayoutInflater.from(context)
                .inflate(
                        R.layout.item_category,
                        parent,
                        false
                );

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder,
            int position
    ) {

        Category category = categoryList.get(position);

        holder.imageView.setImageResource(
                category.getImageResId()
        );

        holder.textView.setText(
                category.getName()
        );



        holder.itemView.setOnClickListener(v -> {

            String categoryName =
                    category.getName().toLowerCase();



            // FRUITS

            if (categoryName.equals("fruits & vegetables")) {

                Intent intent = new Intent(
                        context,
                        FruitsActivity.class
                );

                context.startActivity(intent);
            }
            else if (categoryName.contains("dry fruits")) {

                Intent intent = new Intent(
                        context,
                        MasalaActivity.class
                );

                context.startActivity(intent);
            }


            // DAIRY

            else if (categoryName.contains("dairy")) {

                Intent intent = new Intent(
                        context,
                        DairyActivity.class
                );

                context.startActivity(intent);
            }



            // ATTA RICE

            else if (categoryName.contains("atta")) {

                Intent intent = new Intent(
                        context,
                        AttaRiceActivity.class
                );

                context.startActivity(intent);
            }



            // SNACKS

            else if (categoryName.contains("snacks")) {

                Intent intent = new Intent(
                        context,
                        SnacksActivity.class
                );

                context.startActivity(intent);
            }

        });

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class ViewHolder
            extends RecyclerView.ViewHolder {

        ImageView imageView;

        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView =
                    itemView.findViewById(R.id.categoryImage);

            textView =
                    itemView.findViewById(R.id.categoryName);
        }
    }
}